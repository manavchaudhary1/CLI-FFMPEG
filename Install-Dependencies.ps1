# Check if Chocolatey is installed
if (!(Get-Command choco -ErrorAction SilentlyContinue)) {
    Write-Host "Chocolatey is not installed. Installing Chocolatey..."
    # Install Chocolatey
    Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
}
else {
    Write-Host "Chocolatey is already installed."
}

# Check if FFmpeg is installed
if (!(Get-Command ffmpeg -ErrorAction SilentlyContinue)) {
    Write-Host "FFmpeg is not installed. Installing FFmpeg..."
    # Install FFmpeg using Chocolatey
    choco install ffmpeg -y
    if ($LASTEXITCODE -eq 0) {
        Write-Host "FFmpeg installation completed successfully."
    } else {
        Write-Host "Error: FFmpeg installation failed." -ForegroundColor Red
    }
} else {
    Write-Host "FFmpeg is already installed."
}
