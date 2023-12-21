### CLI-FFMPEG
FFMPEG based CLI Application using JAVA
Used for simple ffmpeg commands

**Installation Process**
~Make sure java is installed in your system  i'm using java21.
~Make sure FFMPEG is installed in your system
Right now i'm not providing FFMPEG lib with project 
so you have to install it manually 

**Install FFMPEG using choco on window**
First run your Shell (i.e. cmd , powershell , etc) in administrative mode
*Install with cmd.exe*
```
@"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "[System.Net.ServicePointManager]::SecurityProtocol = 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"
```
*Install with Powershell*
It require extra steps
```
Get-ExecutionPolicy
```
If it returns *Restricted* then run next cmd otherwise not
```
Set-ExecutionPolicy AllSigned
```
OR
```
Set-ExecutionPolicy Bypass -Scope Process
```
Now run
```
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```

Check if installation is successful using
```
choco || choco -?
```

>You can also refer to there official page for setup [CHOCOLATEY](https://docs.chocolatey.org/en-us/choco/setup)

*Now install ffmpeg*
Make sure to run teminal in adminstrative mode
```
choco install ffmpeg
```
Verify installation 
```
ffmpeg
```

>choco will install ffmpeg in "C:\ProgramData\chocolatey\bin\ffmpeg.exe" 
if not then please manually change path of "FFMPEG_PATH" variable  in src/main/java/com/ffmpeg/cli/FFMPEGCommands.java

***Building Process***
**Linux/WSL**
make sure you are in root directory of projet
```
chmod +x build.sh
```
then run
```
bash build.sh
```

**Windows**
*Use GitBash*
```
./build.sh
```

**Running**
```
cd jar
```
```
java -jar FFMPEG-CLI.jar
```

*Samples are provided in sample folder*
Make sure when running cmds 
Location of files are strictly correct
``` drive name:/path/to/your/project/sample/dwsample.webm```

**If any issue occur please raise issue**
