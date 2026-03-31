# check_windows_deps.ps1
# Diagnostic script: checks whether ARO Desktop's required DLLs are present.
# Reads PE import tables directly — no Visual Studio / dumpbin needed.
# Run on user's Windows machine:  powershell -ExecutionPolicy Bypass -File check_windows_deps.ps1

$ErrorActionPreference = "SilentlyContinue"

# ---- Helper: Read DLL imports from a PE file's import table ----
function Get-PEImports {
    param([string]$FilePath)
    try {
        $stream = [System.IO.File]::OpenRead($FilePath)
        $reader = New-Object System.IO.BinaryReader($stream)

        # DOS header: e_lfanew at offset 0x3C
        $stream.Position = 0x3C
        $peOffset = $reader.ReadInt32()

        # PE signature (4 bytes) + COFF header (20 bytes)
        $stream.Position = $peOffset + 4 + 20

        # Optional header magic to determine PE32 vs PE32+
        $magic = $reader.ReadUInt16()
        if ($magic -eq 0x20B) {
            # PE32+ (64-bit): Import Table RVA at optional header offset 112
            $stream.Position = $peOffset + 24 + 112
        } elseif ($magic -eq 0x10B) {
            # PE32 (32-bit): Import Table RVA at optional header offset 96. 
            $stream.Position = $peOffset + 24 + 96
        } else {
            $reader.Close(); $stream.Close()
            return @()
        }

        $importRVA = $reader.ReadUInt32()
        $importSize = $reader.ReadUInt32()
        if ($importRVA -eq 0) { $reader.Close(); $stream.Close(); return @() }

        # Read section headers to map RVA -> file offset
        $stream.Position = $peOffset + 6
        $numSections = $reader.ReadUInt16()
        $stream.Position = $peOffset + 20
        $optHeaderSize = $reader.ReadUInt16()
        $sectionStart = $peOffset + 24 + $optHeaderSize

        $sections = @()
        for ($i = 0; $i -lt $numSections; $i++) {
            $stream.Position = $sectionStart + ($i * 40) + 12
            $va = $reader.ReadUInt32()
            $rawSize = $reader.ReadUInt32()
            $rawPtr = $reader.ReadUInt32()
            $sections += [PSCustomObject]@{ VA=$va; RawSize=$rawSize; RawPtr=$rawPtr;
                                            VAEnd=($va + $rawSize) }
        }

        function RVAtoFileOffset($rva) {
            foreach ($s in $sections) {
                if ($rva -ge $s.VA -and $rva -lt $s.VAEnd) {
                    return $rva - $s.VA + $s.RawPtr
                }
            }
            return -1
        }

        # Walk import directory entries (20 bytes each, null-terminated)
        $imports = @()
        $entryOffset = RVAtoFileOffset $importRVA
        if ($entryOffset -lt 0) { $reader.Close(); $stream.Close(); return @() }

        while ($true) {
            $stream.Position = $entryOffset + 12  # Name RVA is at offset 12
            $nameRVA = $reader.ReadUInt32()
            if ($nameRVA -eq 0) { break }

            $nameFileOffset = RVAtoFileOffset $nameRVA
            if ($nameFileOffset -ge 0) {
                $stream.Position = $nameFileOffset
                $nameBytes = @()
                while ($true) {
                    $b = $reader.ReadByte()
                    if ($b -eq 0) { break }
                    $nameBytes += $b
                }
                $dllName = [System.Text.Encoding]::ASCII.GetString($nameBytes)
                $imports += $dllName.ToLower()
            }
            $entryOffset += 20
        }

        $reader.Close(); $stream.Close()
        return $imports
    } catch {
        return @()
    }
}

# Windows system DLLs — always present, never bundled
$script:systemDllPatterns = @(
    'kernel32.dll','kernelbase.dll','ntdll.dll','user32.dll','gdi32.dll',
    'advapi32.dll','shell32.dll','ole32.dll','oleaut32.dll','comctl32.dll',
    'comdlg32.dll','ws2_32.dll','wsock32.dll','winmm.dll','shlwapi.dll',
    'version.dll','setupapi.dll','crypt32.dll','wintrust.dll','secur32.dll',
    'bcrypt.dll','ncrypt.dll','iphlpapi.dll','dnsapi.dll','userenv.dll',
    'netapi32.dll','dwmapi.dll','uxtheme.dll','imm32.dll','msimg32.dll',
    'gdiplus.dll','d3d11.dll','d3d9.dll','dxgi.dll','d2d1.dll','dwrite.dll',
    'opengl32.dll','winhttp.dll','wininet.dll','urlmon.dll','msvcrt.dll',
    'ucrtbase.dll','rpcrt4.dll','powrprof.dll','msvcp_win.dll','combase.dll',
    'dbghelp.dll','psapi.dll','wtsapi32.dll','propsys.dll','shcore.dll',
    'profapi.dll','cabinet.dll','msi.dll','uiautomationcore.dll','oleacc.dll',
    'gdi32full.dll','win32u.dll','cfgmgr32.dll','mscoree.dll',
    'api-ms-win-*','ext-ms-win-*'
)

function Is-SystemDll($name) {
    foreach ($p in $script:systemDllPatterns) {
        if ($p.Contains('*')) { if ($name -like $p) { return $true } }
        elseif ($name -eq $p) { return $true }
    }
    return $false
}

Write-Host "========================================" -ForegroundColor Cyan
Write-Host " ARO Desktop - Windows Dependency Check" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# ---- 1. Check MSVC Runtime DLLs (from VC++ Redistributable) ----
$vcDlls = @(
    "vcruntime140.dll",
    "vcruntime140_1.dll",
    "msvcp140.dll",
    "msvcp140_1.dll",
    "msvcp140_2.dll",
    "concrt140.dll",
    "vccorlib140.dll"
)

$sys32 = [System.Environment]::GetFolderPath("System")
if (-not $sys32) { $sys32 = "$env:SystemRoot\System32" }

Write-Host "[MSVC Runtime DLLs] (from Visual C++ Redistributable)" -ForegroundColor Yellow
$vcMissing = @()
foreach ($dll in $vcDlls) {
    $path = Join-Path $sys32 $dll
    if (Test-Path $path) {
        $ver = (Get-Item $path).VersionInfo.ProductVersion
        Write-Host "  OK   $dll  (v$ver)" -ForegroundColor Green
    } else {
        Write-Host "  MISS $dll" -ForegroundColor Red
        $vcMissing += $dll
    }
}
Write-Host ""

# ---- 2. Check WebView2 Runtime ----
Write-Host "[WebView2 Runtime]" -ForegroundColor Yellow
$wv2Key = "HKLM:\SOFTWARE\WOW6432Node\Microsoft\EdgeUpdate\Clients\{F3017226-FE2A-4295-8BDF-00C3A9A7E4C5}"
$wv2Ver = (Get-ItemProperty -Path $wv2Key -Name "pv" -ErrorAction SilentlyContinue).pv
if ($wv2Ver) {
    Write-Host "  OK   WebView2 Runtime v$wv2Ver" -ForegroundColor Green
} else {
    Write-Host "  MISS WebView2 Runtime (required for ARO Desktop Tauri build)" -ForegroundColor Red
}
Write-Host ""

# ---- 3. Deep scan: read PE imports from installed app binaries ----
$appDirs = @(
    "$env:ProgramFiles\ARO Desktop",
    "${env:ProgramFiles(x86)}\ARO Desktop",
    "$env:LocalAppData\Programs\ARO Desktop"
)

Write-Host "[Deep DLL Dependency Scan]" -ForegroundColor Yellow
$appFound = $false
$allMissing = @()

foreach ($dir in $appDirs) {
    if (Test-Path "$dir\aro_desktop.exe") {
        $appFound = $true
        Write-Host "  Installation: $dir" -ForegroundColor Green
        Write-Host ""

        # Collect all bundled DLL names
        $bundled = Get-ChildItem -Path $dir -Recurse -Filter "*.dll" |
                   ForEach-Object { $_.Name.ToLower() }

        # Scan every EXE and DLL in the installation
        $binaries = Get-ChildItem -Path $dir -Recurse -Include *.exe,*.dll
        foreach ($bin in $binaries) {
            $imports = Get-PEImports $bin.FullName
            foreach ($dep in $imports) {
                if (-not $dep) { continue }
                $inBundle = $dep -in $bundled
                $inSystem = (Is-SystemDll $dep) -or (Test-Path (Join-Path $sys32 $dep))
                if (-not $inBundle -and -not $inSystem) {
                    Write-Host "  MISS  $dep  (needed by $($bin.Name))" -ForegroundColor Red
                    $allMissing += [PSCustomObject]@{ Binary=$bin.Name; Missing=$dep }
                }
            }
        }
        break
    }
}

if (-not $appFound) {
    Write-Host "  ARO Desktop not found in standard locations (not yet installed?)" -ForegroundColor Gray
} elseif ($allMissing.Count -eq 0) {
    Write-Host "  All DLL dependencies are satisfied." -ForegroundColor Green
}
Write-Host ""

# ---- 4. Summary & Recommendations ----
Write-Host "========================================" -ForegroundColor Cyan
Write-Host " Summary" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan

if ($vcMissing.Count -gt 0) {
    Write-Host ""
    Write-Host "MISSING VC++ Runtime DLLs: $($vcMissing -join ', ')" -ForegroundColor Red
    Write-Host ""
    Write-Host "FIX: Install the Visual C++ 2015-2022 Redistributable (x64):" -ForegroundColor Yellow
    Write-Host "     https://aka.ms/vs/17/release/vc_redist.x64.exe" -ForegroundColor White
    Write-Host ""
    Write-Host "Or run this command (as Administrator):" -ForegroundColor Yellow
    Write-Host '     winget install Microsoft.VCRedist.2015+.x64' -ForegroundColor White
} else {
    Write-Host "  All required VC++ Runtime DLLs are present." -ForegroundColor Green
}

if (-not $wv2Ver) {
    Write-Host ""
    Write-Host "MISSING WebView2 Runtime (needed only for Tauri-based ARO Desktop)" -ForegroundColor Red
    Write-Host "FIX: https://developer.microsoft.com/en-us/microsoft-edge/webview2/" -ForegroundColor White
}

if ($allMissing.Count -gt 0) {
    Write-Host ""
    Write-Host "UNKNOWN MISSING DLLs (from PE import scan):" -ForegroundColor Red
    $allMissing | Format-Table -Property Binary, Missing -AutoSize
}

Write-Host ""
