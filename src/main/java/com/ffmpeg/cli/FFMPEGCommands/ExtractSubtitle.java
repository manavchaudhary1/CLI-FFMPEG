package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;
import java.io.IOException;

public class ExtractSubtitle {
    public static void extractSubtitleFromVideo(String inputFilePath, String outputFileName) throws IOException {

        //ANSI Colors Codes
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";

        // Get the project path
        String projectPathWithJAR = System.getProperty("user.dir");

        // Remove "jar" from the end of the projectPath, if it exists
        String jarSuffix = "jar";
        String projectPath = projectPathWithJAR.endsWith(jarSuffix) ? projectPathWithJAR.substring(0, projectPathWithJAR.length() - jarSuffix.length()) : projectPathWithJAR;


        // Construct the ffmpegPath using the projectPath
        String ffmpegPath = projectPath + "/lib/ffmpeg/bin/ffmpeg";

        //Output File Location
        String outputFilePath = projectPath+"/output/"+outputFileName;
        String ffmpegCommand = ffmpegPath +" -i " + inputFilePath + " -c:s srt " + outputFilePath;

        // Execute the FFMPEG command
        try{
            ProcessBuild.executeCommand(ffmpegCommand);
            System.err.println(ANSI_RED + "Output file name cannot be empty." + ANSI_RESET);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
