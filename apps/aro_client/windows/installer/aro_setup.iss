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
Type: filesandordirs; Name: "{localappdata}\{#MyAppExeName}.WebView2"

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
ExecAndLog(ExpandConstant('{sys}\taskkill.exe'), '/F /T /IM ' + ProcessName, '');
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
  LocalWebView2Dir: string;
begin
  AppWebView2Dir := ExpandConstant('{app}\{#MyAppExeName}.WebView2');
  LocalWebView2Dir := ExpandConstant('{localappdata}\{#MyAppExeName}.WebView2');

  Log('CleanupWebView2Dirs: try remove ' + AppWebView2Dir);
  ForceDeleteDir(AppWebView2Dir);

  Log('CleanupWebView2Dirs: try remove ' + LocalWebView2Dir);
  ForceDeleteDir(LocalWebView2Dir);
end;

procedure KillAllProcesses();
var
  WebView2DirToken: string;
  AppExePath: string;
  FlutterWindowExePath: string;
  AppWebView2Dir: string;
  LocalWebView2Dir: string;
  PS: string;
begin

AppExePath := ExpandConstant('{app}\{#MyAppExeName}');
FlutterWindowExePath := ExpandConstant('{app}\flutter_window.exe');

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
AppWebView2Dir := ExpandConstant('{app}\{#MyAppExeName}.WebView2');
LocalWebView2Dir := ExpandConstant('{localappdata}\{#MyAppExeName}.WebView2');
PS :=
  '-NoProfile -ExecutionPolicy Bypass -Command '
  + '"$token=''''' + WebView2DirToken + '''''; '
  + '$appDir=''''' + AppWebView2Dir + '''''; '
  + '$localDir=''''' + LocalWebView2Dir + '''''; '
  + 'Get-CimInstance Win32_Process | '
  + 'Where-Object { $_.CommandLine -and (($_.CommandLine -like (''*'' + $token + ''*'')) -or ($_.CommandLine -like (''*'' + $appDir + ''*'')) -or ($_.CommandLine -like (''*'' + $localDir + ''*''))) } | '
  + 'ForEach-Object { try { Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue } catch {} }"';

ExecAndLog('powershell.exe', PS, '');

{ Fallback for older environments where CIM is unavailable }
ExecAndLog('cmd.exe', '/c wmic process where "CommandLine like ''%' + WebView2DirToken + '%''" call terminate', '');

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
  KillAllProcesses();
  WaitProcessesExit();
  CleanupWebView2Dirs();
  Result := True;
end;
