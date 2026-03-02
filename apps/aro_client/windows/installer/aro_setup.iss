#define MyAppName "ARO Desktop"
#define MyAppVersion "0.0.1"
#define MyAppPublisher "ARO Network"
#define MyAppURL "https://aro.network"
#define MyAppExeName "aro_desktop.exe"

[Setup]

AppId={{E6390888-0010-4820-9786-0C7A14897099}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}

AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}

DefaultDirName={autopf}\{#MyAppName}
DefaultGroupName={#MyAppName}

DisableDirPage=no
DisableProgramGroupPage=yes

PrivilegesRequired=lowest

ArchitecturesInstallIn64BitMode=x64

; Place uninstaller files outside {app} so {app} can be fully removed.
UninstallFilesDir={localappdata}\{#MyAppName}\uninstall
CreateUninstallRegKey=yes
Uninstallable=yes

; Output to the app root (apps/aro_client) so CI can upload it easily.
OutputDir=..\..
OutputBaseFilename=AROClient-Setup

SetupIconFile=..\runner\resources\app_icon.ico

Compression=lzma
SolidCompression=yes
WizardStyle=modern

UninstallDisplayIcon={app}\{#MyAppExeName}

AppMutex=AROClientMutex

[Languages]

Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]

Name: "desktopicon"; Description: "Create a desktop icon"; Flags: unchecked

[Files]

Source: "..\..\build\windows\x64\runner\Release\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]

Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]

Filename: "{app}\{#MyAppExeName}";
Description: "Launch {#MyAppName}";
Flags: nowait postinstall skipifsilent

[UninstallDelete]

; NOTE:
; We intentionally do NOT delete "{app}" or "{app}\aro_desktop.exe.WebView2" here.
; When WebView2 keeps file handles open, Inno will show the finished-page warning:
;   "Some elements could not be removed..."
; We instead run a detached cleanup script after the uninstaller exits.

[Code]

procedure KillProcess(ProcessName: string);
var
  ResultCode, i: Integer;
begin
  for i := 1 to 6 do
  begin
    Exec(
      'taskkill',
      '/IM "' + ProcessName + '" /F /T',
      '',
      SW_HIDE,
      ewWaitUntilTerminated,
      ResultCode
    );
    Sleep(800);
  end;
end;

procedure KillAllProcesses();
begin
  KillProcess('{#MyAppExeName}');

  KillProcess('flutter_window.exe');
end;

function IsProcessRunning(ProcessName: string): Boolean;
var
  ResultCode: Integer;
  OutFile, Content, Cmd: string;
begin
  Result := False;

  OutFile := ExpandConstant('{tmp}\aro_tasklist.txt');
  DeleteFile(OutFile);

  Cmd := 'tasklist /FI "IMAGENAME eq ' + ProcessName + '" /NH > "' + OutFile + '"';

  if Exec('cmd.exe', '/c ' + Cmd, '', SW_HIDE, ewWaitUntilTerminated, ResultCode) then
  begin
    if LoadStringFromFile(OutFile, Content) then
      Result := Pos(LowerCase(ProcessName), LowerCase(Content)) > 0;
  end;
end;

procedure WaitAllProcessesExit(TimeoutMS: Integer);
var
  Elapsed: Integer;
begin
  Elapsed := 0;
  while Elapsed < TimeoutMS do
  begin
    if not (IsProcessRunning('{#MyAppExeName}') or
            IsProcessRunning('flutter_window.exe')) then
      Exit;

    Sleep(500);
    Elapsed := Elapsed + 500;
  end;
end;

procedure WaitWebView2Exit(TimeoutMS: Integer);
var
  Elapsed: Integer;
begin
  Elapsed := 0;
  while Elapsed < TimeoutMS do
  begin
    if not (IsProcessRunning('msedgewebview2.exe') or
            IsProcessRunning('edgewebview2.exe')) then
      Exit;

    Sleep(500);
    Elapsed := Elapsed + 500;
  end;
end;

function DeleteTreeBestEffort(DirName: string): Boolean;
begin
  Result := True;
  if DirExists(DirName) then
    Result := DelTree(DirName, True, True, True);
end;

function EscapeForPowerShellSingleQuotedString(Value: string): string;
begin
  { In PowerShell, single-quoted strings escape a single quote by doubling it. }
  Result := StringChangeEx(Value, '''', '''''', True);
end;

procedure KillWebView2ForFolder(WebView2Dir: string);
var
  ResultCode: Integer;
  EscDir, PS: string;
begin
  { Best-effort: stop only WebView2 processes whose command line references
    our app-specific WebView2 user data folder. This avoids killing WebView2
    used by other apps. }
  EscDir := EscapeForPowerShellSingleQuotedString(WebView2Dir);

  PS :=
    '$dir = ''' + EscDir + '''; ' +
    'Get-CimInstance Win32_Process | ' +
    'Where-Object { ' +
    '  ($_.Name -eq ''msedgewebview2.exe'' -or $_.Name -eq ''edgewebview2.exe'') ' +
    '  -and $_.CommandLine -and ($_.CommandLine -like (''*'' + $dir + ''*'')) ' +
    '} | ForEach-Object { ' +
    '  try { Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue } catch {} ' +
    '};';

  Exec(
    'powershell.exe',
    '-NoProfile -ExecutionPolicy Bypass -Command "' + PS + '"',
    '',
    SW_HIDE,
    ewWaitUntilTerminated,
    ResultCode
  );
end;

procedure KillWebView2GlobalLastResort();
begin
  { Last resort: kill WebView2 runtime processes globally.
    This can affect other apps using WebView2, so only call this when our
    WebView2 folder remains locked after multiple retries. }
  KillProcess('msedgewebview2.exe');
  KillProcess('edgewebview2.exe');
end;

var
  g_webview2_dir: string;
  g_app_dir: string;

procedure StartDetachedCleanup(AppDir: string; WebView2Dir: string);
var
  ResultCode: Integer;
  CmdPath, Cmd: string;
  Content: AnsiString;
begin
  { Runs AFTER uninstall exits to avoid file-in-use problems.
    Best-effort: kill processes and retry directory deletion. }
  CmdPath := ExpandConstant('{tmp}\aro_cleanup.cmd');
  DeleteFile(CmdPath);

  Cmd :=
    '@echo off' + #13#10 +
    'setlocal enableextensions' + #13#10 +
    'set "APP_DIR=' + AppDir + '"' + #13#10 +
    'set "WV2_DIR=' + WebView2Dir + '"' + #13#10 +
    'set "WV2_TOKEN={#MyAppExeName}.WebView2"' + #13#10 +
    'set "LOG=%TEMP%\aro_uninstall_cleanup.log"' + #13#10 +
    'echo ===== ARO cleanup start %DATE% %TIME% =====>>"%LOG%"' + #13#10 +
    'echo APP_DIR="%APP_DIR%">>"%LOG%"' + #13#10 +
    'echo WV2_DIR="%WV2_DIR%">>"%LOG%"' + #13#10 +
    'echo WV2_TOKEN="%WV2_TOKEN%">>"%LOG%"' + #13#10 +
    'for /l %%i in (1,1,20) do (' + #13#10 +
    '  echo ---- attempt %%i %DATE% %TIME% ---->>"%LOG%"' + #13#10 +
    '  taskkill /IM "{#MyAppExeName}" /F /T >nul 2>nul' + #13#10 +
    '  taskkill /IM "flutter_window.exe" /F /T >nul 2>nul' + #13#10 +
    '  powershell.exe -NoProfile -ExecutionPolicy Bypass -Command "$a=$env:APP_DIR; $w=$env:WV2_DIR; $t=$env:WV2_TOKEN; Get-CimInstance Win32_Process | Where-Object { $_.CommandLine -and (($_.CommandLine -like (''*'' + $w + ''*'')) -or ($_.CommandLine -like (''*'' + $a + ''*'')) -or ($_.CommandLine -like (''*'' + $t + ''*''))) } | ForEach-Object { try { Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue } catch {} }" >>"%LOG%" 2>&1' + #13#10 +
    '  wmic process where "CommandLine like ''%{#MyAppExeName}.WebView2%''" call terminate >>"%LOG%" 2>&1' + #13#10 +
    '  if %%i LSS 6 (' + #13#10 +
    '    powershell.exe -NoProfile -ExecutionPolicy Bypass -Command "$dir=$env:WV2_DIR; $tok=$env:WV2_TOKEN; Get-CimInstance Win32_Process | Where-Object { ($_.Name -eq ''msedgewebview2.exe'' -or $_.Name -eq ''edgewebview2.exe'') -and $_.CommandLine -and (($_.CommandLine -like (''*'' + $dir + ''*'')) -or ($_.CommandLine -like (''*'' + $tok + ''*''))) } | ForEach-Object { try { Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue } catch {} }" >>"%LOG%" 2>&1' + #13#10 +
    '  ) else (' + #13#10 +
    '    echo global taskkill webview2>>"%LOG%"' + #13#10 +
    '    taskkill /IM "msedgewebview2.exe" /F /T >>"%LOG%" 2>&1' + #13#10 +
    '    taskkill /IM "edgewebview2.exe" /F /T >>"%LOG%" 2>&1' + #13#10 +
    '    taskkill /IM "WebView2Manager.exe" /F /T >>"%LOG%" 2>&1' + #13#10 +
    '  )' + #13#10 +
    '  tasklist /FO TABLE | findstr /I "msedgewebview2.exe edgewebview2.exe" >>"%LOG%" 2>&1' + #13#10 +
    '  if exist "%WV2_DIR%" attrib -r -s -h "%WV2_DIR%\*" /s /d >nul 2>nul' + #13#10 +
    '  if exist "%WV2_DIR%" rmdir /s /q "%WV2_DIR%" >nul 2>nul' + #13#10 +
    '  if exist "%APP_DIR%" rmdir /s /q "%APP_DIR%" >nul 2>nul' + #13#10 +
    '  if exist "%WV2_DIR%" echo WV2_DIR still exists>>"%LOG%"' + #13#10 +
    '  if exist "%APP_DIR%" echo APP_DIR still exists>>"%LOG%"' + #13#10 +
    '  if not exist "%APP_DIR%" goto :done' + #13#10 +
    '  timeout /t 1 /nobreak >nul' + #13#10 +
    ')' + #13#10 +
    'if exist "%APP_DIR%" (' + #13#10 +
    '  echo scheduling RunOnce cleanup>>"%LOG%"' + #13#10 +
    '  reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\RunOnce" /v "ARODesktopCleanup" /t REG_SZ /d "cmd /c rmdir /s /q ""%WV2_DIR%"" & rmdir /s /q ""%APP_DIR%""" /f >>"%LOG%" 2>&1' + #13#10 +
    ')' + #13#10 +
    ':done' + #13#10 +
    'echo ===== ARO cleanup end %DATE% %TIME% =====>>"%LOG%"' + #13#10 +
    'del /f /q "%~f0" >nul 2>nul' + #13#10 +
    'endlocal' + #13#10;

  Content := AnsiString(Cmd);
  SaveStringToFile(CmdPath, Content, False);

  { Start detached so uninstall can finish immediately. }
  Exec(
    'cmd.exe',
    '/c start "" /min "' + CmdPath + '"',
    '',
    SW_HIDE,
    ewNoWait,
    ResultCode
  );
end;

procedure CurUninstallStepChanged(CurUninstallStep: TUninstallStep);
var
  i: Integer;
begin
  if CurUninstallStep = usUninstall then
  begin
    { Kill the main app early so it can release WebView2 handles before
      file removal starts. }
    KillAllProcesses();
    WaitAllProcessesExit(30000);
    g_app_dir := ExpandConstant('{app}');
    g_webview2_dir := ExpandConstant('{app}\\{#MyAppExeName}.WebView2');

    { Proactively free locks held by WebView2 so uninstall can remove {app}. }
    if g_webview2_dir <> '' then
    begin
      for i := 1 to 6 do
      begin
        if DeleteTreeBestEffort(g_webview2_dir) then
          Break;

        KillWebView2ForFolder(g_webview2_dir);
        Sleep(600);
      end;

      if DirExists(g_webview2_dir) then
      begin
        KillWebView2GlobalLastResort();
        WaitWebView2Exit(15000);
        DeleteTreeBestEffort(g_webview2_dir);
      end;
    end;
  end
  else if CurUninstallStep = usPostUninstall then
  begin
    { Final safety net: run detached cleanup to remove WebView2 + install dir
      after the uninstaller exits, preventing "Some elements..." warnings. }
    if (g_app_dir <> '') and (g_webview2_dir <> '') then
      StartDetachedCleanup(g_app_dir, g_webview2_dir);
  end;
end;