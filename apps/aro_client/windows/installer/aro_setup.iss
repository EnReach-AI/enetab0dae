#define MyAppName "ARO"
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

OutputDir=.\Output
OutputBaseFilename=ARO_Setup

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

; WebView2
Type: filesandordirs; Name: "{app}\aro_desktop.exe.WebView2"

; AppData
Type: filesandordirs; Name: "{userappdata}\ARO"
Type: filesandordirs; Name: "{localappdata}\ARO"

; Flutter
Type: filesandordirs; Name: "{userappdata}\aro_desktop"
Type: filesandordirs; Name: "{localappdata}\aro_desktop"

; vendor
Type: filesandordirs; Name: "{userappdata}\com.aro"
Type: filesandordirs; Name: "{localappdata}\com.aro"

; logs
Type: filesandordirs; Name: "{userappdata}\libstudy"

; Documents
Type: filesandordirs; Name: "{userdocs}\ARO Desktop"

; 安装目录
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

  ; 主程序
  KillProcess('aro_desktop.exe');

  ; Flutter
  KillProcess('flutter_window.exe');

  ; WebView2
  KillProcess('msedgewebview2.exe');

  ; WebView2备用
  KillProcess('edgewebview2.exe');

  ; Edge残留
  KillProcess('msedge.exe');

end;


function IsProcessRunning(ProcessName: string): Boolean;
var
  ResultCode: Integer;
  OutFile, Content, Cmd: string;
begin
  Result := False;

  OutFile := ExpandConstant('{tmp}\aro_tasklist.txt');
  DeleteFile(OutFile);

  Cmd :=
    'tasklist /FI "IMAGENAME eq ' + ProcessName +
    '" /NH > "' + OutFile + '"';

  if Exec(
     'cmd.exe',
     '/c ' + Cmd,
     '',
     SW_HIDE,
     ewWaitUntilTerminated,
     ResultCode
  ) then
  begin
    if LoadStringFromFile(OutFile, Content) then
      Result := Pos(LowerCase(ProcessName), LowerCase(Content)) > 0;
  end;
end;


procedure WaitProcessExit(ProcessName: string; TimeoutMS: Integer);
var
  Elapsed: Integer;
begin
  Elapsed := 0;

  while Elapsed < TimeoutMS do
  begin
    if not IsProcessRunning(ProcessName) then
      Exit;

    Sleep(500);
    Elapsed := Elapsed + 500;
  end;
end;


procedure CurUninstallStepChanged(CurUninstallStep: TUninstallStep);
begin

  if CurUninstallStep = usUninstall then
  begin

    KillAllProcesses();

    WaitProcessExit('aro_desktop.exe', 10000);

  end;

end;