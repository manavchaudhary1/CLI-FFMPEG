package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;
import java.io.IOException;

public class AddSoftSubtitle {
    public static void encodeSoftSubtitleIntoVideo(String inputFilePath, String outputFileName, String inputFilePathSub) throws IOException {

        //ANSI Colors Codes
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        
        // Get the project path
        String projectPathWithJAR = System.getProperty("user.dir");
        //Remove jar from projectPath
        String projectPath = projectPathWithJAR.replace("jar","");

        // Construct the ffmpegPath using the projectPath
        String ffmpegPath = projectPath + "/lib/ffmpeg/bin/ffmpeg";

        //Output File Location
        String outputFilePath = projectPath+"output/"+outputFileName;
        
        String videoCodec = outputFileName.matches("(?i).*mp4") ? "libx264" : "libx265";

        String subtitleCodec = videoCodec.equals("libx264") ? "mov_text" : "srt";

        String ffmpegCommand = ffmpegPath +" -i " + inputFilePath + " -i " + inputFilePathSub + " -c:s "+ subtitleCodec +" -c:v " + videoCodec + " -c:a copy " + outputFilePath;

        // Execute the FFMPEG command
        try{
            ProcessBuild.executeCommand(ffmpegCommand);
            System.err.println(ANSI_RED + "Output file name cannot be empty." + ANSI_RESET);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}

