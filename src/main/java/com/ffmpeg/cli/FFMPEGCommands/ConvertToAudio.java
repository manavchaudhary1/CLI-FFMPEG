package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;

import java.io.IOException;
import java.util.Scanner;

public class ConvertToAudio {
    public static void convertVideoToAudio(String inputFilePath, String outputFileName) throws IOException {
        // Get the project path
        String projectPathWithJAR = System.getProperty("user.dir");
        //Remove jar from projectPath
        String projectPath = projectPathWithJAR.replace("jar","");

        // Construct the ffmpegPath using the projectPath
        String ffmpegPath = projectPath + "/lib/ffmpeg/bin/ffmpeg";

        //Output File Location
        String outputFilePath = projectPath+"/output/";

        //Select Audio Stream
        System.out.println("Enter number of Audio Stream:");
        System.out.println("If Single Audio File then Enter '0' FFMPEG start indexing from '0';");
        Scanner input =  new Scanner(System.in);
        int optionAudioFile = input.nextInt();

        // Build the ffmpeg command
        String ffmpegCommand = ffmpegPath + " -i " + inputFilePath + " -map 0:a:"+optionAudioFile+" "+outputFilePath+ outputFileName;

        // Execute the FFMPEG command
        try{
            ProcessBuild.executeCommand(ffmpegCommand);
            System.out.println("Output File saved at Location :"+outputFilePath);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
