#!/bin/bash

# Define your source code and output directories
SOURCE_DIR="src"
OUTPUT_DIR="out"
JAR_NAME="FFMPEG_CLI.jar"
MANIFEST_FILE="Manifest.txt"
JAR_FOLDER="jar"

clear

#figlet -c "FFMPEG_CLI" Not available in Windows
echo "Building CLI-FFMPEG"
echo
echo  "    ______  _        _____           _______  _______  ______   ______  _______  ______   "
echo  "   / _____)| |      (_____)         (_______)(_______)|  ___ \ (_____ \(_______)/ _____)  "
echo  "  | /      | |         _      ___    _____    _____   | | _ | | _____) )_____  | /  ___   "
echo  "  | |      | |        | |    (___)  |  ___)  |  ___)  | || || ||  ____/|  ___) | | (___)  "
echo  "  | \_____ | |_____  _| |_          | |      | |      | || || || |     | |_____| \____/|  "
echo  "   \______)|_______)(_____)         |_|      |_|      |_||_||_||_|     |_______)\_____/   "


###########################################################################
#Script Name : build.sh
#Description : Used to build JAR file of java files from source directories
#Creation Date : 12-20-2023
#Author      : Manav
#Email       : manavchaudhary041@gmail.com
###########################################################################

# Create output directory if it doesn't exist
mkdir -p "$OUTPUT_DIR"

# Compiling Java source files
echo "Compiling..."
javac -d "$OUTPUT_DIR" -sourcepath "$SOURCE_DIR" "$SOURCE_DIR"/main/java/com/ffmpeg/cli/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."

    # Create JAR file with manifest and specified classes
    echo "Creating JAR file..."
    mkdir -p "$JAR_FOLDER"
    jar cvfm "$JAR_FOLDER/$JAR_NAME" "$MANIFEST_FILE" -C "$OUTPUT_DIR" .

    # Check if JAR creation was successful
    if [ $? -eq 0 ]; then
        echo "JAR file created successfully: $JAR_NAME"
    else
        echo "Error creating JAR file."
    fi
else
    echo "Error during compilation."
fi
