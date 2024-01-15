package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;
import java.io.IOException;

public class ExtractSubtitle {
    public static void extractSubtitleFromVideo(String inputFilePath, String outputFileName) throws IOException {
        // Get the project path
        String projectPathWithJAR = System.getProperty("user.dir");
        //Remove jar from projectPath
        String projectPath = projectPathWithJAR.replace("jar","");

        // Construct the ffmpegPath using the projectPath
        String ffmpegPath = projectPath + "/lib/ffmpeg/bin/ffmpeg";

        //Output File Location
        String outputFilePath = projectPath+"/output/"+outputFileName;
        String ffmpegCommand = ffmpegPath +" -i " + inputFilePath + " -c:s srt " + outputFilePath;

        // Execute the FFMPEG command
        try{
            ProcessBuild.executeCommand(ffmpegCommand);
            System.out.println("Output File saved at Location :"+outputFilePath);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
