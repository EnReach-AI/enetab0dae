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

Compression=lzma
SolidCompression=yes
WizardStyle=modern

OutputDir=..\..
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
Source: "..\..\build\windows\x64\runner\Release\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "Launch {#MyAppName}"; Flags: nowait postinstall skipifsilent

[UninstallDelete]

Type: filesandordirs; Name: "{app}\{#MyAppExeName}.WebView2"
Type: filesandordirs; Name: "{app}"
Type: filesandordirs; Name: "{localappdata}\ARO Desktop"
Type: filesandordirs; Name: "{appdata}\ARO Desktop"

[Code]

procedure KillProcess(ProcessName: string);
var
  ResultCode, i: Integer;
begin
  for i := 1 to 5 do
  begin
    Exec(
      'taskkill',
      '/IM ' + ProcessName + ' /F /T',
      '',
      SW_HIDE,
      ewWaitUntilTerminated,
      ResultCode
    );
    Sleep(700);
  end;
end;

procedure KillAllProcesses();
begin
  KillProcess('{#MyAppExeName}');
  KillProcess('flutter_window.exe');
  KillProcess('msedgewebview2.exe');
  KillProcess('edgewebview2.exe');
  KillProcess('WebView2Manager.exe');
end;

function IsProcessRunning(ProcessName: string): Boolean;
var
  ResultCode: Integer;
  OutFile, Content, Cmd: string;
begin
  Result := False;

  OutFile := ExpandConstant('{tmp}\tasklist.txt');
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
            IsProcessRunning('flutter_window.exe') or
            IsProcessRunning('msedgewebview2.exe')) then
      Exit;

    Sleep(500);
    Elapsed := Elapsed + 500;
  end;
end;

var
  AppDir: string;

procedure RunCleanupScript();
var
  CmdPath, Cmd: string;
  ResultCode: Integer;
begin

  CmdPath := ExpandConstant('{tmp}\aro_cleanup.cmd');

  Cmd :=
    '@echo off' + #13#10 +
    'set APP=' + AppDir + #13#10 +
    'for /l %%i in (1,1,15) do (' + #13#10 +
    'taskkill /IM aro_desktop.exe /F >nul 2>nul' + #13#10 +
    'taskkill /IM flutter_window.exe /F >nul 2>nul' + #13#10 +
    'taskkill /IM msedgewebview2.exe /F >nul 2>nul' + #13#10 +
    'rmdir /s /q "%APP%" >nul 2>nul' + #13#10 +
    'if not exist "%APP%" goto done' + #13#10 +
    'timeout /t 1 >nul' + #13#10 +
    ')' + #13#10 +
    ':done' + #13#10 +
    'exit';

  SaveStringToFile(CmdPath, Cmd, False);

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
begin

  if CurUninstallStep = usUninstall then
  begin

    KillAllProcesses();
    WaitAllProcessesExit(20000);

    AppDir := ExpandConstant('{app}');
  end;

  if CurUninstallStep = usPostUninstall then
  begin

    if AppDir <> '' then
      RunCleanupScript();

  end;

end;