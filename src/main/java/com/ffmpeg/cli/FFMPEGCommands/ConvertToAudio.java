package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;

import java.io.IOException;
import java.util.Scanner;

public class ConvertToAudio {
    public static void convertVideoToAudio(String inputFilePath, String outputFileName) throws IOException {
        //ANSI Colors Codes
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_YELLOW = "\u001B[33m";

        // Get the project path
        String projectPathWithJAR = System.getProperty("user.dir");

        // Remove "jar" from the end of the projectPath, if it exists
        String jarSuffix = "jar";
        String projectPath = projectPathWithJAR.endsWith(jarSuffix) ? projectPathWithJAR.substring(0, projectPathWithJAR.length() - jarSuffix.length()) : projectPathWithJAR;


        // Construct the ffmpegPath using the projectPath
        String ffmpegPath = projectPath + "/lib/ffmpeg/bin/ffmpeg";

        //Output File Location
        String outputFilePath = projectPath+"/output/";

        //Select Audio Stream
        System.out.println(ANSI_BLUE + "Enter number of Audio Stream:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "If Single Audio File then Enter '0' FFMPEG start indexing from '0';" + ANSI_RESET);
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
