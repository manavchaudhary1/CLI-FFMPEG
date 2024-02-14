#!/bin/bash

# Define your source code and output directories
LIBRARY_DIR="lib"
userHome="$PWD"

echo "Downloading Dependencies."

# Create output directory if it doesn't exist
mkdir -p "$LIBRARY_DIR"

echo "Creating lib folder..."

# Determine the operating system type
OS=$(uname -s | tr '[:upper:]' '[:lower:]')

echo "Downloading Dependencies for $OS"

#Installing Figlet LIB
  cd "$LIBRARY_DIR" || exit
  git clone https://gitlab.com/manavchaudhary1/figlet.git
  if [ $? -eq 0 ]; then
        echo "Figlet Dependencies Downloaded Successfully..."
  fi

# Installing picocli JAR
cd "$userHome/$LIBRARY_DIR" || exit
git clone https://gitlab.com/manavchaudhary1/picocli.git
if [ $? -eq 0 ]; then
  echo "Picocli Dependencies Downloaded Successfully..."
fi

clear

#Print Application Name
    cd figlet || exit
    ./figlet -c Hermes Stream
    cd .. &&  cd ..

###########################################################################
# Script Name: lib_setup.sh
# Description: Used to Download FFMPEG exe files
# Creation Date: 01-15-2024
# Author: Manav
# Email: manavchaudhary041@gmail.com
###########################################################################

    cd "$LIBRARY_DIR" || exit
    git clone https://gitlab.com/manavchaudhary1/ffmpeg_lib_window.git
    cd ffmpeg_lib_window || exit
    tar -xf ffmpeg.tar.gz -C "$userHome/$LIBRARY_DIR"
    if [ $? -eq 0 ]; then
      echo "Library Downloaded Successfully..."
    fi
    cd ..
    rm -rf ffmpeg_lib_window
    if [ $? -eq 0 ]; then
      echo "Exiting.."
    else
      echo "Error removing tar file. Manually remove tar file in $LIBRARY_DIR folder"
    fi
