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

echo "Detected OS: $OS"

echo "Downloading Dependencies for $OS"

 #Installing Figlet LIB

case $OS in
  mysis*|mingw*|cygwin*) # windows
  cd "$LIBRARY_DIR" || exit
  git clone https://gitlab.com/manavchaudhary1/figlet.git
  if [ $? -eq 0 ]; then
        echo "Dependencies Downloaded Successfully..."
  fi
  ;;
 linux*)
   if dpkg -l | grep -q figlet; then
       echo "FIGlet is installed."
   else
       echo "Figlet is not installed."
       echo "Run 'sudo apt install figlet'"
       exit 1
   fi
  ;;
  *)
  echo "Unsupported or unknown operating system: $OS"
    ;;
esac

#clear

#Print Application Name

case $OS in
  mysis*|mingw*|cygwin*) # windows
    cd figlet || exit
    ./figlet -c Hermes Stream
    cd .. &&  cd ..
    ;;
  linux*) #linux
    figlet Hermes Stream
    ;;
esac

###########################################################################
# Script Name: lib_setup.sh
# Description: Used to Download FFMPEG exe files
# Creation Date: 01-15-2024
# Author: Manav
# Email: manavchaudhary041@gmail.com
###########################################################################

case $OS in
  msys*|mingw*|cygwin*)  # Windows
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
    ;;
  linux*)
    cd "$LIBRARY_DIR" || exit
    git clone https://gitlab.com/manavchaudhary1/ffmpeg_lib_linux.git
    cd ffmpeg_lib_linux || exit
    tar -xf ffmpeg.tar.gz -C "$userHome/$LIBRARY_DIR"
    if [ $? -eq 0 ]; then
      echo "Library Downloaded Successfully..."
    fi
    cd ..
    rm -rf ffmpeg_lib_linux
    if [ $? -eq 0 ]; then
      echo "Exiting.."
    else
      echo "Error removing tar file. Manually remove tar file in $LIBRARY_DIR folder"
    fi
    ;;
  *)
    echo "Unsupported or unknown operating system: $OS"
    ;;
esac
