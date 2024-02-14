package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;

import java.io.IOException;
import java.util.Scanner;

public class ChangeVidExtention{
    public static void changeVidExt(String inputVidPath)throws IOException {
        //ANSI Colors Codes
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_CYAN = "\u001B[36m";

        //Ansi Style Codes
        String Bold = "\u001B[1m";
        String Italic = "\u001B[3m";


        // Get the project path
        String projectPathWithJAR = System.getProperty("user.dir");
        //Remove jar from projectPath
        String projectPath = projectPathWithJAR.replace("jar","");

        // Construct the ffmpegPath using the projectPath
        String ffmpegPath = projectPath + "/lib/ffmpeg/bin/ffmpeg";

        System.out.println(ANSI_YELLOW + Italic + "Available Extentions for Video Format are:" + ANSI_RESET);
        System.out.println(ANSI_CYAN +
                """
                    >mp4 (MPEG-4 Part 14)
                    >mkv (Matroska)
                    >avi (Audio Video Interleave)
                    >mov (QuickTime Movie)
                    >wmv (Windows Media Video)
                    >flv (Flash Video)
                    >OGV (Ogg Video)
                    >MPEG (Moving Picture Experts Group)
                    >webm (WebM)"""
                            + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Enter Output File Name with Extention:" + ANSI_RESET);

        String outputFileName;
        try (Scanner scanner = new Scanner(System.in)) {
            outputFileName = scanner.next();
            if (outputFileName.isEmpty()) {
                System.err.println(ANSI_RED + "Output file name cannot be empty." + ANSI_RESET);
                return;
            }
        }

        //Output File Location
        String outputFilePath = projectPath+"output/"+outputFileName;

        String ffmpegCommand = ffmpegPath + " -i " + inputVidPath + " " + outputFilePath;

        try {
            ProcessBuild.executeCommand(ffmpegCommand);
            System.out.println(ANSI_CYAN + "Output File saved at Location :" + Italic + Bold + outputFilePath + ANSI_RESET);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
