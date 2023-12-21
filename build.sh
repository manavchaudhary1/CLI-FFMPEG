#!/bin/bash

# Define your source code and output directories
SOURCE_DIR="src"
OUTPUT_DIR="out"
JAR_NAME="FFMPEG_CLI.jar"
MANIFEST_FILE="Manifest.txt"
JAR_FOLDER="jar"

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
