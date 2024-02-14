#!/bin/bash

# Define your source code and output directories
sourceDir="src"
outputDir="out"
jarName="CLI_FFMPEG.jar"
manifestFile="Manifest.txt"
jarFolder="jar"
projectDirectory=$(pwd)

###########################################################################
#Script Name : build.sh
#Description : Used to build JAR file of java files from source directories
#Creation Date : 12-20-2023
#Author      : Manav
#Email       : manavchaudhary041@gmail.com
###########################################################################

clear

# Print Application Name
case $OS in
  Windows*|mysis*|mingw*|cygwin*) # windows
    cd lib/figlet || exit
    ./figlet "Hermes Stream"
    cd .. &&  cd ..
    ;;
  linux*) #linux
    figlet "Hermes Stream"
    ;;
esac

echo "Building CLI-FFMPEG"

# Create output directory if it doesn't exist
mkdir -p "$outputDir"

# Compiling Java source files
echo "Compiling..."

javac -cp "$projectDirectory/lib/picocli/picocli.jar" -d "$outputDir" -sourcepath "$sourceDir" "$sourceDir/main/java/com/ffmpeg/cli/*.java" "$sourceDir/main/java/com/ffmpeg/cli/FFMPEGCommands/*.java"

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."

    # Create JAR file with manifest and specified classes
    echo "Creating JAR file..."
    mkdir -p "$jarFolder"
    jar cvfm "$jarFolder/$jarName" "$manifestFile" -C "$outputDir" .

    # Check if JAR creation was successful
    if [ $? -eq 0 ]; then
        echo "JAR file created successfully: $jarFolder/$jarName"
    else
        echo "Error creating JAR file."
    fi
else
    echo "Error during compilation."
fi

echo "Run the compiled JAR file? (Y/N)"

read -r choice

case $choice in
  [Yy])
    cd "$jarFolder" || exit
    java -jar "$jarName"
    ;;
  [Nn])
    echo "Exiting"
    exit
    ;;
  *)
    echo "Invalid option!"
    echo "Exiting"
    exit
    ;;
esac
