package com.ffmpeg.cli;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--FFMPEG CLI--");
        System.out.println("1️⃣ Convert Video to audio");
        System.out.println("2️⃣ Encode Soft Subtitle into Video");
        System.out.println("3️⃣ Burn Subtitle into Video");
        System.out.println("4️⃣ Extract Subtitle from Video");
        System.out.println("5️⃣ Exit");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Choice:");
        int choice = sc.nextInt();

        try {
            switch (choice) {
                case 1:
                    System.out.println("Enter location of video with ext:");
                    String inputFilePathAudio = sc.next();
                    System.out.println("Enter location where you want output with file name & '.aac' ext:");
                    String outputFilePathAudio = sc.next();
                    FFMPEGCommands.convertVideoToAudio(inputFilePathAudio, outputFilePathAudio);
                    break;
                case 2:
                    System.out.println("Enter location of video with ext:");
                    String inputFilePathEncode = sc.next();
                    System.out.println("Enter location of soft subtitle with ext:");
                    String inputFilePathSubEncode = sc.next();
                    System.out.println("Enter location where you want output with file name & ext:");
                    String outputFilePathEncode = sc.next();
                    FFMPEGCommands.encodeSoftSubtitleIntoVideo(inputFilePathEncode, outputFilePathEncode, inputFilePathSubEncode);
                    break;
                case 3:
                    System.out.println("Enter location of video with ext:");
                    String inputFilePathBurn = sc.next();
                    System.out.println("Enter location of soft subtitle with ext:");
                    String inputFilePathSubBurn = sc.next();
                    System.out.println("Enter location where you want output with file name & ext:");
                    String outputFilePathBurn = sc.next();
                    FFMPEGCommands.burnSubtitleIntoVideo(inputFilePathBurn, outputFilePathBurn, inputFilePathSubBurn);
                    break;
                case 4:
                    System.out.println("Enter location of video with ext:");
                    String inputFilePathExtract = sc.next();
                    System.out.println("Enter location where you want output with file name & '.srt' ext:");
                    String outputFilePathExtract = sc.next();
                    FFMPEGCommands.extractSubtitleFromVideo(inputFilePathExtract, outputFilePathExtract);
                    break;
                case 5:
                    System.out.println("Exited Successfully");
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error executing FFMPEG command: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
