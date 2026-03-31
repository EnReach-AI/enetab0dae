# check_windows_deps.ps1
# Diagnostic script: checks whether ARO Desktop's required DLLs are present.
# Run on user's Windows machine:  powershell -ExecutionPolicy Bypass -File check_windows_deps.ps1

$ErrorActionPreference = "SilentlyContinue"

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

# ---- 3. Check app-bundled DLLs (if installed) ----
$appDirs = @(
    "$env:ProgramFiles\ARO Desktop",
    "${env:ProgramFiles(x86)}\ARO Desktop",
    "$env:LocalAppData\Programs\ARO Desktop"
)

Write-Host "[App Installation Check]" -ForegroundColor Yellow
$appFound = $false
foreach ($dir in $appDirs) {
    if (Test-Path "$dir\aro_desktop.exe") {
        $appFound = $true
        Write-Host "  Found installation at: $dir" -ForegroundColor Green

        # Use dumpbin if available, otherwise list DLLs in directory
        $exePath = Join-Path $dir "aro_desktop.exe"
        $dumpbin = Get-Command "dumpbin.exe" -ErrorAction SilentlyContinue
        if ($dumpbin) {
            Write-Host "  Checking DLL imports with dumpbin..." -ForegroundColor Gray
            $deps = & dumpbin.exe /DEPENDENTS $exePath 2>$null |
                    Select-String "\.dll" |
                    ForEach-Object { $_.Line.Trim() }
            foreach ($dep in $deps) {
                $found = (Test-Path (Join-Path $dir $dep)) -or (Test-Path (Join-Path $sys32 $dep))
                if ($found) {
                    Write-Host "    OK   $dep" -ForegroundColor Green
                } else {
                    Write-Host "    MISS $dep" -ForegroundColor Red
                }
            }
        } else {
            # Fallback: list DLLs bundled in the app directory
            $bundled = Get-ChildItem -Path $dir -Filter "*.dll" | Select-Object -ExpandProperty Name
            Write-Host "  Bundled DLLs: $($bundled -join ', ')" -ForegroundColor Gray
        }
        break
    }
}
if (-not $appFound) {
    Write-Host "  ARO Desktop not found in standard locations (not yet installed?)" -ForegroundColor Gray
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

Write-Host ""
