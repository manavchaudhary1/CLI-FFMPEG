### CLI-FFMPEG
FFMPEG based CLI Application using JAVA
Used for simple ffmpeg commands

***Installation Process***

~Make sure java is installed in your system  (i'm using java21). 

**Install FFMPEG EXE**

**Linux/WSL**

```
cd \path\to\project\CLI-FFMPEG
```

The script has Windows-style line endings (CRLF), which can cause "command not found" errors on Unix-like systems.

To fix this issue, you can convert the line endings to Unix-style (LF).

>You can use the dos2unix or sed command to do this.

using dos2unix:
```
dos2unix lib_setup.sh
```

If dos2unix is not available, you can use sed:
```
sed -i 's/\r$//' lib_setup.sh
```

then run,
```
bash lib_setup.sh
```

**Windows**

**Use GitBash**

```
cd \path\to\project\CLI-FFMPEG
```

then run,
```
./lib_setup.sh
```

***Building Process***

Make sure you are in root directory of project

**Linux/WSL**

```
chmod +x build.sh
```
```
chmod +x lib/ffmpeg/bin/ffmpeg
```
The script has Windows-style line endings (CRLF), which can cause "command not found" errors on Unix-like systems.

To fix this issue, you can convert the line endings to Unix-style (LF).

>You can use the dos2unix or sed command to do this.

using dos2unix:
```
dos2unix build.sh
```

If dos2unix is not available, you can use sed:
```
sed -i 's/\r$//' build.sh
```

After running one of these commands,then run

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
