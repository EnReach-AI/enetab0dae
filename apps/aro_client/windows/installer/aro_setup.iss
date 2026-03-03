#define MyAppName "ARO Desktop"
#define MyAppVersion "0.0.1"
#define MyAppPublisher "ARO Network"
#define MyAppURL "https://aro.network"
#define MyAppExeName "aro_desktop.exe"
#define MyAppExeBase "aro_desktop"

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

; 必须管理员权限，否则无法删除 Program Files
PrivilegesRequired=admin

ArchitecturesInstallIn64BitMode=x64

Compression=lzma
SolidCompression=yes
WizardStyle=modern

OutputDir=....
OutputBaseFilename=AROClient-Setup

SetupIconFile=..\runner\resources\app_icon.ico

UninstallDisplayIcon={app}\{#MyAppExeName}

AppMutex=AROClientMutex

; Ask Restart Manager to close running app-related processes during uninstall/install
CloseApplications=yes
RestartApplications=no
CloseApplicationsFilter={#MyAppExeName},flutter_window.exe,msedgewebview2.exe,edgewebview2.exe,WebView2Manager.exe

UninstallFilesDir={localappdata}\{#MyAppName}\uninstall
CreateUninstallRegKey=yes
Uninstallable=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "Create a desktop icon"; Flags: unchecked

[Files]
Source: "....\build\windows\x64\runner\Release*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "Launch {#MyAppName}"; Flags: nowait postinstall skipifsilent

[UninstallDelete]

; 删除 WebView2 缓存
Type: filesandordirs; Name: "{app}\{#MyAppExeName}.WebView2"
Type: filesandordirs; Name: "{app}\{#MyAppExeName}.webview2"
Type: filesandordirs; Name: "{app}\{#MyAppExeBase}.WebView2"
Type: filesandordirs; Name: "{app}\{#MyAppExeBase}.webview2"
Type: filesandordirs; Name: "{localappdata}\{#MyAppExeName}.WebView2"
Type: filesandordirs; Name: "{localappdata}\{#MyAppExeName}.webview2"
Type: filesandordirs; Name: "{localappdata}\{#MyAppExeBase}.WebView2"
Type: filesandordirs; Name: "{localappdata}\{#MyAppExeBase}.webview2"
Type: filesandordirs; Name: "{userappdata}\{#MyAppExeName}.WebView2"
Type: filesandordirs; Name: "{userappdata}\{#MyAppExeName}.webview2"
Type: filesandordirs; Name: "{userappdata}\{#MyAppExeBase}.WebView2"
Type: filesandordirs; Name: "{userappdata}\{#MyAppExeBase}.webview2"
Type: filesandordirs; Name: "{localappdata}\{#MyAppName}\{#MyAppExeName}.WebView2"
Type: filesandordirs; Name: "{localappdata}\{#MyAppName}\{#MyAppExeName}.webview2"
Type: filesandordirs; Name: "{localappdata}\{#MyAppName}\{#MyAppExeBase}.WebView2"
Type: filesandordirs; Name: "{localappdata}\{#MyAppName}\{#MyAppExeBase}.webview2"
Type: filesandordirs; Name: "{userappdata}\{#MyAppName}\{#MyAppExeName}.WebView2"
Type: filesandordirs; Name: "{userappdata}\{#MyAppName}\{#MyAppExeName}.webview2"
Type: filesandordirs; Name: "{userappdata}\{#MyAppName}\{#MyAppExeBase}.WebView2"
Type: filesandordirs; Name: "{userappdata}\{#MyAppName}\{#MyAppExeBase}.webview2"

; 删除安装目录
Type: filesandordirs; Name: "{app}"

; 删除 AppData 缓存
Type: filesandordirs; Name: "{localappdata}\{#MyAppName}"
Type: filesandordirs; Name: "{appdata}\{#MyAppName}"

[Code]

function ExecAndLog(const Filename, Params, WorkingDir: string): Integer;
var
  ResultCode: Integer;
  Ok: Boolean;
begin
  Ok := Exec(Filename, Params, WorkingDir, SW_HIDE, ewWaitUntilTerminated, ResultCode);
  Log(Format('Exec: %s %s => ok=%d, rc=%d', [Filename, Params, Ord(Ok), ResultCode]));
  if Ok then
    Result := ResultCode
  else
    Result := -1;
end;

procedure KillProcess(ProcessName: string);
begin
{ Direct execution }
ExecAndLog(ExpandConstant('{sys}\taskkill.exe'), '/F /T /IM ' + ProcessName, '');
{ Mirror the most reliable interactive form: cmd /c taskkill ... }
ExecAndLog('cmd.exe', '/c taskkill /F /T /IM ' + ProcessName, '');
{ Fallback: rely on PATH resolution }
ExecAndLog('taskkill.exe', '/F /T /IM ' + ProcessName, '');
end;

procedure KillProcessByNamePS(const ProcessBaseName: string);
var
  PS: string;
begin
  { ProcessBaseName should be without .exe, e.g. "aro_desktop" }
  PS :=
    '-NoProfile -ExecutionPolicy Bypass -Command '
    + '"$n=''''' + ProcessBaseName + '''''; '
    + '$ps = Get-Process -Name $n -ErrorAction SilentlyContinue; '
    + 'if ($ps) { '
    + '  $ps | ForEach-Object { try { $_.CloseMainWindow() | Out-Null } catch {} }; '
    + '  Start-Sleep -Milliseconds 800; '
    + '  $ps = Get-Process -Name $n -ErrorAction SilentlyContinue; '
    + '  $ps | ForEach-Object { try { Stop-Process -Id $_.Id -Force -ErrorAction SilentlyContinue } catch {} }; '
    + '}"';

  ExecAndLog(ExpandConstant('{sys}\WindowsPowerShell\v1.0\powershell.exe'), PS, '');
end;

procedure KillProcessByExeNameCIM(const ExeName: string);
var
  PS: string;
begin
  { ExeName should include .exe, e.g. "aro_desktop.exe" }
  PS :=
    '-NoProfile -ExecutionPolicy Bypass -Command '
    + '"$n=''''' + ExeName + '''''; '
    + 'Get-CimInstance Win32_Process -Filter (\"Name=''$n''\") -ErrorAction SilentlyContinue | '
    + 'ForEach-Object { try { Invoke-CimMethod -InputObject $_ -MethodName Terminate -ErrorAction SilentlyContinue | Out-Null } catch {} }"';

  ExecAndLog(ExpandConstant('{sys}\WindowsPowerShell\v1.0\powershell.exe'), PS, '');
end;

procedure KillProcessByPath(const ExePath: string);
var
  PS: string;
begin
  PS :=
    '-NoProfile -ExecutionPolicy Bypass -Command '
    + '"$p=''''' + ExePath + '''''; '
    + 'Get-CimInstance Win32_Process | '
    + 'Where-Object { $_.ExecutablePath -and ($_.ExecutablePath -ieq $p) } | '
    + 'ForEach-Object { try { Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue } catch {} }"';

  ExecAndLog(ExpandConstant('{sys}\WindowsPowerShell\v1.0\powershell.exe'), PS, '');
end;

procedure KillProcessByExeNameWMIC(const ExeName: string);
begin
  { WMIC is deprecated, but still a useful fallback on some systems }
  ExecAndLog('cmd.exe',
    '/c wmic process where "Name=\"' + ExeName + '\"" call terminate',
    ''
  );
end;

procedure RemoveAutoStartEntries();
var
  ValueName: string;
begin
  ValueName := '{#MyAppName}';

  { Common autostart registry keys }
  ExecAndLog('cmd.exe', '/c reg delete "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v "' + ValueName + '" /f', '');
  ExecAndLog('cmd.exe', '/c reg delete "HKLM\Software\Microsoft\Windows\CurrentVersion\Run" /v "' + ValueName + '" /f', '');

  { Some environments may use exe base name as value }
  ExecAndLog('cmd.exe', '/c reg delete "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v "{#MyAppExeBase}" /f', '');
  ExecAndLog('cmd.exe', '/c reg delete "HKLM\Software\Microsoft\Windows\CurrentVersion\Run" /v "{#MyAppExeBase}" /f', '');

  { Scheduled task names (best-effort; ignore failures) }
  ExecAndLog('cmd.exe', '/c schtasks /Delete /TN "{#MyAppName}" /F', '');
  ExecAndLog('cmd.exe', '/c schtasks /Delete /TN "{#MyAppExeBase}" /F', '');
end;

procedure KillProcessByNameTaskkillPidPS(const ProcessBaseName: string);
var
  PS: string;
begin
  { Use taskkill by PID list; sometimes more effective cross-session }
  PS :=
    '-NoProfile -ExecutionPolicy Bypass -Command '
    + '"$n=''''' + ProcessBaseName + '''''; '
    + '$p = Get-Process -Name $n -ErrorAction SilentlyContinue; '
    + 'if ($p) { $p | Select-Object -ExpandProperty Id | ForEach-Object { '
    + '  try { & taskkill.exe /F /T /PID $_ | Out-Null } catch {} '
    + '} }"';
  ExecAndLog(ExpandConstant('{sys}\WindowsPowerShell\v1.0\powershell.exe'), PS, '');
end;

procedure KillProcessesUnderDir(const DirPath: string);
var
  PS: string;
begin
  PS :=
    '-NoProfile -ExecutionPolicy Bypass -Command '
    + '"$dir=''''' + DirPath + '''''; '
    + 'Get-CimInstance Win32_Process | '
    + 'Where-Object { $_.ExecutablePath -and ($_.ExecutablePath -like ($dir + ''\\*'')) } | '
    + 'ForEach-Object { try { Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue } catch {} }"';

  ExecAndLog(ExpandConstant('{sys}\WindowsPowerShell\v1.0\powershell.exe'), PS, '');
end;

function ForceDeleteDir(const DirPath: string): Boolean;
var
  i: Integer;
begin
  if not DirExists(DirPath) then
  begin
    Result := True;
    exit;
  end;

  Result := False;
  for i := 1 to 20 do
  begin
    ExecAndLog('cmd.exe', '/c attrib -r -s -h /s /d "' + DirPath + '\\*"', '');

    if DelTree(DirPath, True, True, True) then
    begin
      if not DirExists(DirPath) then
      begin
        Result := True;
        exit;
      end;
    end;

    ExecAndLog('cmd.exe', '/c rd /s /q "' + DirPath + '"', '');
    Sleep(300);

    if not DirExists(DirPath) then
    begin
      Result := True;
      exit;
    end;
  end;

  Log('ForceDeleteDir: failed to remove ' + DirPath);
end;

procedure CleanupWebView2Dirs();
var
  AppWebView2Dir: string;
  AppWebView2DirNoExe: string;
  AppWebView2DirLower: string;
  AppWebView2DirNoExeLower: string;
  LocalWebView2Dir: string;
  LocalWebView2DirNoExe: string;
  LocalWebView2DirLower: string;
  LocalWebView2DirNoExeLower: string;
  RoamingWebView2Dir: string;
  RoamingWebView2DirNoExe: string;
  RoamingWebView2DirLower: string;
  RoamingWebView2DirNoExeLower: string;
  LocalAppSubWebView2Dir: string;
  LocalAppSubWebView2DirNoExe: string;
  LocalAppSubWebView2DirLower: string;
  LocalAppSubWebView2DirNoExeLower: string;
  RoamingAppSubWebView2Dir: string;
  RoamingAppSubWebView2DirNoExe: string;
  RoamingAppSubWebView2DirLower: string;
  RoamingAppSubWebView2DirNoExeLower: string;
begin
  AppWebView2Dir := ExpandConstant('{app}\{#MyAppExeName}.WebView2');
  AppWebView2DirNoExe := ExpandConstant('{app}\{#MyAppExeBase}.WebView2');
  AppWebView2DirLower := ExpandConstant('{app}\{#MyAppExeName}.webview2');
  AppWebView2DirNoExeLower := ExpandConstant('{app}\{#MyAppExeBase}.webview2');
  LocalWebView2Dir := ExpandConstant('{localappdata}\{#MyAppExeName}.WebView2');
  LocalWebView2DirNoExe := ExpandConstant('{localappdata}\{#MyAppExeBase}.WebView2');
  LocalWebView2DirLower := ExpandConstant('{localappdata}\{#MyAppExeName}.webview2');
  LocalWebView2DirNoExeLower := ExpandConstant('{localappdata}\{#MyAppExeBase}.webview2');
  RoamingWebView2Dir := ExpandConstant('{userappdata}\{#MyAppExeName}.WebView2');
  RoamingWebView2DirNoExe := ExpandConstant('{userappdata}\{#MyAppExeBase}.WebView2');
  RoamingWebView2DirLower := ExpandConstant('{userappdata}\{#MyAppExeName}.webview2');
  RoamingWebView2DirNoExeLower := ExpandConstant('{userappdata}\{#MyAppExeBase}.webview2');
  LocalAppSubWebView2Dir := ExpandConstant('{localappdata}\{#MyAppName}\{#MyAppExeName}.WebView2');
  LocalAppSubWebView2DirNoExe := ExpandConstant('{localappdata}\{#MyAppName}\{#MyAppExeBase}.WebView2');
  LocalAppSubWebView2DirLower := ExpandConstant('{localappdata}\{#MyAppName}\{#MyAppExeName}.webview2');
  LocalAppSubWebView2DirNoExeLower := ExpandConstant('{localappdata}\{#MyAppName}\{#MyAppExeBase}.webview2');
  RoamingAppSubWebView2Dir := ExpandConstant('{userappdata}\{#MyAppName}\{#MyAppExeName}.WebView2');
  RoamingAppSubWebView2DirNoExe := ExpandConstant('{userappdata}\{#MyAppName}\{#MyAppExeBase}.WebView2');
  RoamingAppSubWebView2DirLower := ExpandConstant('{userappdata}\{#MyAppName}\{#MyAppExeName}.webview2');
  RoamingAppSubWebView2DirNoExeLower := ExpandConstant('{userappdata}\{#MyAppName}\{#MyAppExeBase}.webview2');

  Log('CleanupWebView2Dirs: try remove ' + AppWebView2Dir);
  ForceDeleteDir(AppWebView2Dir);

  Log('CleanupWebView2Dirs: try remove ' + AppWebView2DirLower);
  ForceDeleteDir(AppWebView2DirLower);

  Log('CleanupWebView2Dirs: try remove ' + AppWebView2DirNoExe);
  ForceDeleteDir(AppWebView2DirNoExe);

  Log('CleanupWebView2Dirs: try remove ' + AppWebView2DirNoExeLower);
  ForceDeleteDir(AppWebView2DirNoExeLower);

  Log('CleanupWebView2Dirs: try remove ' + LocalWebView2Dir);
  ForceDeleteDir(LocalWebView2Dir);

  Log('CleanupWebView2Dirs: try remove ' + LocalWebView2DirLower);
  ForceDeleteDir(LocalWebView2DirLower);

  Log('CleanupWebView2Dirs: try remove ' + LocalWebView2DirNoExe);
  ForceDeleteDir(LocalWebView2DirNoExe);

  Log('CleanupWebView2Dirs: try remove ' + LocalWebView2DirNoExeLower);
  ForceDeleteDir(LocalWebView2DirNoExeLower);

  Log('CleanupWebView2Dirs: try remove ' + RoamingWebView2Dir);
  ForceDeleteDir(RoamingWebView2Dir);

  Log('CleanupWebView2Dirs: try remove ' + RoamingWebView2DirLower);
  ForceDeleteDir(RoamingWebView2DirLower);

  Log('CleanupWebView2Dirs: try remove ' + RoamingWebView2DirNoExe);
  ForceDeleteDir(RoamingWebView2DirNoExe);

  Log('CleanupWebView2Dirs: try remove ' + RoamingWebView2DirNoExeLower);
  ForceDeleteDir(RoamingWebView2DirNoExeLower);

  Log('CleanupWebView2Dirs: try remove ' + LocalAppSubWebView2Dir);
  ForceDeleteDir(LocalAppSubWebView2Dir);

  Log('CleanupWebView2Dirs: try remove ' + LocalAppSubWebView2DirLower);
  ForceDeleteDir(LocalAppSubWebView2DirLower);

  Log('CleanupWebView2Dirs: try remove ' + LocalAppSubWebView2DirNoExe);
  ForceDeleteDir(LocalAppSubWebView2DirNoExe);

  Log('CleanupWebView2Dirs: try remove ' + LocalAppSubWebView2DirNoExeLower);
  ForceDeleteDir(LocalAppSubWebView2DirNoExeLower);

  Log('CleanupWebView2Dirs: try remove ' + RoamingAppSubWebView2Dir);
  ForceDeleteDir(RoamingAppSubWebView2Dir);

  Log('CleanupWebView2Dirs: try remove ' + RoamingAppSubWebView2DirLower);
  ForceDeleteDir(RoamingAppSubWebView2DirLower);

  Log('CleanupWebView2Dirs: try remove ' + RoamingAppSubWebView2DirNoExe);
  ForceDeleteDir(RoamingAppSubWebView2DirNoExe);

  Log('CleanupWebView2Dirs: try remove ' + RoamingAppSubWebView2DirNoExeLower);
  ForceDeleteDir(RoamingAppSubWebView2DirNoExeLower);
end;

procedure KillAllProcesses();
var
  WebView2DirToken: string;
  WebView2DirTokenNoExe: string;
  AppExePath: string;
  FlutterWindowExePath: string;
  AppWebView2Dir: string;
  AppWebView2DirNoExe: string;
  LocalWebView2Dir: string;
  LocalWebView2DirNoExe: string;
  RoamingWebView2Dir: string;
  RoamingWebView2DirNoExe: string;
  PS: string;
begin

RemoveAutoStartEntries();

AppExePath := ExpandConstant('{app}\{#MyAppExeName}');
FlutterWindowExePath := ExpandConstant('{app}\flutter_window.exe');

{ First try: close gracefully then force kill by PID/name (more reliable than /IM on some systems) }
KillProcessByNamePS('{#MyAppExeBase}');
KillProcessByNamePS('flutter_window');
KillProcessByNameTaskkillPidPS('{#MyAppExeBase}');
KillProcessByNameTaskkillPidPS('flutter_window');
KillProcessByExeNameCIM('{#MyAppExeName}');
KillProcessByExeNameCIM('flutter_window.exe');
KillProcessByExeNameWMIC('{#MyAppExeName}');
KillProcessByExeNameWMIC('flutter_window.exe');

KillProcess('{#MyAppExeName}');
KillProcess('flutter_window.exe');
KillProcessByPath(AppExePath);
KillProcessByPath(FlutterWindowExePath);
KillProcessesUnderDir(ExpandConstant('{app}'));

{ Avoid killing all WebView2 runtime processes system-wide.
  Instead, terminate only those that reference our app's WebView2 user-data dir (see PowerShell below). }

{ Kill processes whose CommandLine references the app's WebView2 user-data dir.
  WMIC is deprecated on newer Windows, so prefer PowerShell/CIM. }
WebView2DirToken := '{#MyAppExeName}.WebView2';
WebView2DirTokenNoExe := '{#MyAppExeBase}.WebView2';
AppWebView2Dir := ExpandConstant('{app}\{#MyAppExeName}.WebView2');
AppWebView2DirNoExe := ExpandConstant('{app}\{#MyAppExeBase}.WebView2');
LocalWebView2Dir := ExpandConstant('{localappdata}\{#MyAppExeName}.WebView2');
LocalWebView2DirNoExe := ExpandConstant('{localappdata}\{#MyAppExeBase}.WebView2');
RoamingWebView2Dir := ExpandConstant('{userappdata}\{#MyAppExeName}.WebView2');
RoamingWebView2DirNoExe := ExpandConstant('{userappdata}\{#MyAppExeBase}.WebView2');
PS :=
  '-NoProfile -ExecutionPolicy Bypass -Command '
  + '"$token=''''' + WebView2DirToken + '''''; '
  + '$tokenNoExe=''''' + WebView2DirTokenNoExe + '''''; '
  + '$appDir=''''' + AppWebView2Dir + '''''; '
  + '$appDirNoExe=''''' + AppWebView2DirNoExe + '''''; '
  + '$localDir=''''' + LocalWebView2Dir + '''''; '
  + '$localDirNoExe=''''' + LocalWebView2DirNoExe + '''''; '
  + '$roamingDir=''''' + RoamingWebView2Dir + '''''; '
  + '$roamingDirNoExe=''''' + RoamingWebView2DirNoExe + '''''; '
  + 'Get-CimInstance Win32_Process | '
  + 'Where-Object { $_.CommandLine -and (($_.CommandLine -like (''*'' + $token + ''*'')) -or ($_.CommandLine -like (''*'' + $tokenNoExe + ''*'')) -or ($_.CommandLine -like (''*'' + $appDir + ''*'')) -or ($_.CommandLine -like (''*'' + $appDirNoExe + ''*'')) -or ($_.CommandLine -like (''*'' + $localDir + ''*'')) -or ($_.CommandLine -like (''*'' + $localDirNoExe + ''*'')) -or ($_.CommandLine -like (''*'' + $roamingDir + ''*'')) -or ($_.CommandLine -like (''*'' + $roamingDirNoExe + ''*''))) } | '
  + 'ForEach-Object { try { Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue } catch {} }"';

ExecAndLog('powershell.exe', PS, '');

{ Fallback for older environments where CIM is unavailable }
ExecAndLog('cmd.exe', '/c wmic process where "CommandLine like ''%' + WebView2DirToken + '%''" call terminate', '');
ExecAndLog('cmd.exe', '/c wmic process where "CommandLine like ''%' + WebView2DirTokenNoExe + '%''" call terminate', '');

{ Last fallback: if still locked by WebView2 runtime, force-kill common runtime process names }
ExecAndLog(ExpandConstant('{sys}\taskkill.exe'), '/F /T /IM msedgewebview2.exe', '');
ExecAndLog(ExpandConstant('{sys}\taskkill.exe'), '/F /T /IM edgewebview2.exe', '');
ExecAndLog(ExpandConstant('{sys}\taskkill.exe'), '/F /T /IM WebView2Manager.exe', '');

end;

function IsProcessRunning(ProcessName: string): Boolean;
var
ResultCode: Integer;
TmpFile, Content, Cmd: string;
begin
Result := False;

TmpFile := ExpandConstant('{tmp}\tasklist.txt');
DeleteFile(TmpFile);

Cmd := 'tasklist /FI "IMAGENAME eq ' + ProcessName + '" /NH > "' + TmpFile + '"';

if Exec('cmd.exe', '/c ' + Cmd, '', SW_HIDE, ewWaitUntilTerminated, ResultCode) then
begin
if LoadStringFromFile(TmpFile, Content) then
Result := Pos(LowerCase(ProcessName), LowerCase(Content)) > 0;
end;

function EnsureAppNotRunningNoUI(): Boolean;
var
  i: Integer;
begin
  { Non-interactive: keep trying to terminate the app before uninstall deletes files }
  { Up to ~60 seconds total (120 * 500ms) }
  for i := 1 to 120 do
  begin
    if not IsProcessRunning('{#MyAppExeName}') then
    begin
      Result := True;
      exit;
    end;

    Log(Format('EnsureAppNotRunningNoUI: attempt %d to terminate %s', [i, '{#MyAppExeName}']));
    RemoveAutoStartEntries();
    KillAllProcesses();
    { Extra direct name-based fallbacks in case the process is outside {app} }
    KillProcessByExeNameWMIC('{#MyAppExeName}');
    KillProcessByExeNameCIM('{#MyAppExeName}');
    KillProcess('{#MyAppExeName}');
    WaitProcessesExit();
    Sleep(500);
  end;

  Result := not IsProcessRunning('{#MyAppExeName}');
  if not Result then
    Log('EnsureAppNotRunningNoUI: WARNING: app still running after repeated kill attempts');
end;
end;

procedure WaitProcessesExit();
var
i: Integer;
begin

for i := 1 to 120 do
begin
if not (
  IsProcessRunning('{#MyAppExeName}') or
  IsProcessRunning('flutter_window.exe') or
  IsProcessRunning('msedgewebview2.exe') or
  IsProcessRunning('edgewebview2.exe') or
  IsProcessRunning('WebView2Manager.exe')
) then
  exit;

Sleep(500);
end;

end;

procedure CurUninstallStepChanged(CurUninstallStep: TUninstallStep);
begin

if CurUninstallStep = usUninstall then
begin
KillAllProcesses();

WaitProcessesExit();
EnsureAppNotRunningNoUI();
CleanupWebView2Dirs();
end;

if CurUninstallStep = usPostUninstall then
begin
  { Retry once more at the end to handle delayed process exits }
  CleanupWebView2Dirs();
end;

end;

function InitializeUninstall(): Boolean;
begin
  { Run early so files/directories are not locked when deletion starts }
  Log('InitializeUninstall: attempting to terminate running processes');
  Log(Format('InitializeUninstall: IsAdminLoggedOn=%d', [Ord(IsAdminLoggedOn)]));
  Log(Format('InitializeUninstall: IsPowerUserLoggedOn=%d', [Ord(IsPowerUserLoggedOn)]));
  KillAllProcesses();
  WaitProcessesExit();
  CleanupWebView2Dirs();
  { No UI and do not block uninstall; just attempt aggressively }
  EnsureAppNotRunningNoUI();
  Result := True;
end;
