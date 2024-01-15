package com.ffmpeg.cli;

import com.ffmpeg.cli.FFMPEGCommands.AddSoftSubtitle;
import com.ffmpeg.cli.FFMPEGCommands.BurnSubtitle;
import com.ffmpeg.cli.FFMPEGCommands.ConvertToAudio;
import com.ffmpeg.cli.FFMPEGCommands.ExtractSubtitle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Switch {
    public static void choice(){
        System.out.println("--------FFMPEG CLI--------");
        System.out.println("1) Convert Video to audio");
        System.out.println("2) Encode Soft Subtitle into Video");
        System.out.println("3) Burn Subtitle into Video");
        System.out.println("4) Extract Subtitle from Video");
        System.out.println("5) Exit");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Choice:");
        int choice = sc.nextInt();

        try {
            switch (choice) {
                case 1:
                    //Convert Video to audio
                    System.out.println("Enter location of video with ext:");
                    String inputFilePathAudio = sc.next();

                    System.out.println("Enter output file name with'.aac' ext:");
                    String outputFileNameAudio = sc.next();

                    ConvertToAudio.convertVideoToAudio(inputFilePathAudio, outputFileNameAudio);
                    break;
                case 2:
                    //Encode Soft subs to video
                    System.out.println("Enter location of video with ext:");
                    String inputFilePathEncode = sc.next();

                    System.out.println("Enter location of soft subtitle with ext:");
                    String inputFilePathSubEncode = sc.next();

                    System.out.println("----Right now only mp4 & mkv are only supported----");
                    System.out.println("Enter file name & ext:");
                    String outputFileNameEncode = sc.next();

                    AddSoftSubtitle.encodeSoftSubtitleIntoVideo(inputFilePathEncode, outputFileNameEncode, inputFilePathSubEncode);
                    break;
                case 3:
                    //Encode Hard subs to video
                    System.out.println("Enter location of video with ext:");
                    String inputFilePathBurn = sc.next();

                    System.out.println("------------NOTE:Please enter drive in this format D\\:/path/to/your/file.srt-----------");
                    System.out.println("Otherwise prasing error");

                    System.out.println("Enter location of soft subtitle with ext:");
                    String inputFilePathSubBurn = sc.next();

                    System.out.println("Enter file name & ext:");
                    String outputFileBurn = sc.next();

                    BurnSubtitle.burnSubtitleIntoVideo(inputFilePathBurn, inputFilePathSubBurn, outputFileBurn);
                    break;

                case 4:
                    //Extract soft subs from video
                    System.out.println("Enter location of video with ext:");
                    String inputFilePathExtract = sc.next();

                    System.out.println("Enter file name & '.srt' ext:");
                    String outputFileNameExtract = sc.next();

                    ExtractSubtitle.extractSubtitleFromVideo(inputFilePathExtract, outputFileNameExtract);
                    break;
                case 5:
                    System.out.println("Exited Successfully....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            System.out.println("Operation Successfull!");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error executing FFMPEG command: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
