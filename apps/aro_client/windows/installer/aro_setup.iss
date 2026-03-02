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

UninstallFilesDir={app}\uninstall
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

Type: filesandordirs; Name: "{app}\aro_desktop.exe.WebView2"

Type: filesandordirs; Name: "{app}"

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
    if not (IsProcessRunning('aro_desktop.exe') or
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
    g_webview2_dir := ExpandConstant('{app}\aro_desktop.exe.WebView2');
  end
  else if CurUninstallStep = usPostUninstall then
  begin
    { After most files are removed, retry deleting the WebView2 folder.
      If it remains locked, stop WebView2 processes (targeted first, then
      global last-resort) and retry. }
    if g_webview2_dir <> '' then
    begin
      for i := 1 to 20 do
      begin
        if DeleteTreeBestEffort(g_webview2_dir) then
          Break;

        if i <= 14 then
          KillWebView2ForFolder(g_webview2_dir)
        else
          KillWebView2GlobalLastResort();

        WaitWebView2Exit(10000);
        Sleep(800);
      end;
    end;
  end;
end;