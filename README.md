### CLI-FFMPEG
FFMPEG based CLI Application using JAVA
Used for simple ffmpeg commands

***Installation Process***

~Make sure java is installed in your system  (i'm using java21). 

**Install FFMPEG**

**Linux/WSL**
```
sudo apt install ffmpeg
```
**Windows**

*First run your PowerShell in administrative mode*
```
cd /path/to/project/CLI-FFMPEG && ./Install-Dependencies.ps1
```
>For installing ffmpeg in windows , Script will install CHOCOLATEY then FFMPEG will be installed.

>You can also refer to there official page for setup [CHOCOLATEY](https://docs.chocolatey.org/en-us/choco/setup)

>choco will install ffmpeg in "C:\ProgramData\chocolatey\bin\ffmpeg.exe"

***Building Process***

Make sure you are in root directory of project

**Linux/WSL**

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

***Running***

```
cd jar
```

```
java -jar FFMPEG-CLI.jar
```

*Samples are provided in sample folder*

Make sure when running cmds 

Location of files are strictly correct
``` 
drive name  D:/path/to/your/project/sample/dwsample.webm
```

**If any issue occur please raise issue**
