package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;

import java.io.IOException;
import java.util.Scanner;

public class ChangeVidExtention{
    public static void changeVidExt(String inputVidPath)throws IOException {
        // Get the project path
        String projectPathWithJAR = System.getProperty("user.dir");
        //Remove jar from projectPath
        String projectPath = projectPathWithJAR.replace("jar","");
        System.out.println(projectPath);

        // Construct the ffmpegPath using the projectPath
        String ffmpegPath = projectPath + "/lib/ffmpeg/bin/ffmpeg";

        System.out.println("Available Extentions for Video Format are:");
        System.out.println(
                """
                        mp4 (MPEG-4 Part 14)
                        mkv (Matroska)
                        avi (Audio Video Interleave)
                        mov (QuickTime Movie)
                        wmv (Windows Media Video)
                        flv (Flash Video)
                        OGV (Ogg Video)
                        MPEG (Moving Picture Experts Group)
                        webm (WebM)""");
        System.out.println("Enter Output File Name with Extention:");

        String outputFileName;
        try (Scanner scanner = new Scanner(System.in)) {
            outputFileName = scanner.next();
            if (outputFileName.isEmpty()) {
                System.err.println("Output file name cannot be empty.");
                return;
            }
        }

        //Output File Location
        String outputFilePath = projectPath+"output/"+outputFileName;
        System.out.println(outputFilePath);

        String ffmpegCommand = ffmpegPath + " -i " + inputVidPath + " " + outputFilePath;

        try {
            ProcessBuild.executeCommand(ffmpegCommand);
            System.out.println("Output File saved at Location :" + outputFilePath);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
