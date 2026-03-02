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

DefaultDirName={autopf}{#MyAppName}
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

UninstallDisplayIcon={app}{#MyAppExeName}

AppMutex=AROClientMutex

UninstallFilesDir={localappdata}{#MyAppName}\uninstall
CreateUninstallRegKey=yes
Uninstallable=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "Create a desktop icon"; Flags: unchecked

[Files]
Source: "....\build\windows\x64\runner\Release*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{autoprograms}{#MyAppName}"; Filename: "{app}{#MyAppExeName}"
Name: "{autodesktop}{#MyAppName}"; Filename: "{app}{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}{#MyAppExeName}"; Description: "Launch {#MyAppName}"; Flags: nowait postinstall skipifsilent

[UninstallDelete]

; 删除 WebView2 缓存
Type: filesandordirs; Name: "{app}{#MyAppExeName}.WebView2"

; 删除安装目录
Type: filesandordirs; Name: "{app}"

; 删除 AppData 缓存
Type: filesandordirs; Name: "{localappdata}\ARO Desktop"
Type: filesandordirs; Name: "{appdata}\ARO Desktop"

[Code]

procedure KillProcess(ProcessName: string);
var
ResultCode: Integer;
begin
Exec(
'taskkill',
'/F /T /IM ' + ProcessName,
'',
SW_HIDE,
ewWaitUntilTerminated,
ResultCode
);
end;

procedure KillAllProcesses();
var
ResultCode: Integer;
begin

KillProcess('{#MyAppExeName}');
KillProcess('flutter_window.exe');

KillProcess('msedgewebview2.exe');
KillProcess('edgewebview2.exe');
KillProcess('WebView2Manager.exe');

Exec(
'cmd.exe',
'/c wmic process where "CommandLine like ''%aro_desktop.exe.WebView2%''" call terminate',
'',
SW_HIDE,
ewWaitUntilTerminated,
ResultCode
);

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

for i := 1 to 30 do
begin

```
if not (
  IsProcessRunning('{#MyAppExeName}') or
  IsProcessRunning('flutter_window.exe') or
  IsProcessRunning('msedgewebview2.exe')
) then
  exit;

Sleep(500);
```

end;

end;

procedure CurUninstallStepChanged(CurUninstallStep: TUninstallStep);
begin

if CurUninstallStep = usUninstall then
begin

```
KillAllProcesses();

WaitProcessesExit();
```

end;

end;
