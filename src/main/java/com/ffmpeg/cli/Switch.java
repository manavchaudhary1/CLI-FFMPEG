package com.ffmpeg.cli;

import com.ffmpeg.cli.FFMPEGCommands.*;

import picocli.CommandLine.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;
import java.util.Scanner;

@Command(name = "Switch", mixinStandardHelpOptions = true, version = "Switch 1.0", description = "Switch between different FFMPEG commands")
public class Switch{
    public static void choice(){
        //ANSI Colors Codes
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";
        String Mangenta = "\u001B[35m";

        //Ansi Style Codes
        String Bold = "\u001B[1m";
        String Italic = "\u001B[3m";
        String Underline = "\u001B[4m";
        String Strike = "\u001B[9m";
        String Blink = "\u001B[5m";


        String header = "--------FFMPEG CLI--------";
        System.out.println(ANSI_CYAN + Bold + Italic + centerText(header) + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "1) Convert Video Extension" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "2) Convert Video to audio" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "3) Encode Soft Subtitle into Video" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "4) Burn Subtitle into Video" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "5) Extract Subtitle from Video" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "6) Exit" + ANSI_RESET);


        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_BLUE+"Enter Choice:"+ANSI_RESET);
        int choice = sc.nextInt();

        try {
            switch (choice) {
                case 1:
                    //Change Video Format
                    System.out.println(ANSI_BLUE+"Enter location of video with ext:"+ANSI_RESET);
                    String inputFilePathVid = sc.next();

                    ChangeVidExtention.changeVidExt(inputFilePathVid);
                    break;
                case 2:
                    //Convert Video to audio
                    System.out.println(ANSI_BLUE + "Enter location of video with ext:" + ANSI_RESET);
                    String inputFilePathAudio = sc.next();

                    System.out.println(ANSI_BLUE + "Enter output file name with'.aac' ext:" + ANSI_RESET);
                    String outputFileNameAudio = sc.next();

                    ConvertToAudio.convertVideoToAudio(inputFilePathAudio, outputFileNameAudio);
                    break;
                case 3:
                    //Encode Soft subs to video
                    System.out.println(ANSI_BLUE + "Enter location of video with ext:" + ANSI_RESET);
                    String inputFilePathEncode = sc.next();

                    System.out.println(ANSI_BLUE + "Enter location of soft subtitle with ext:" + ANSI_RESET);
                    String inputFilePathSubEncode = sc.next();

                    System.out.println(ANSI_CYAN + Italic + "----Right now only mp4 & mkv are only supported----" + ANSI_RESET);
                    System.out.println(ANSI_BLUE + "Enter file name & ext:" + ANSI_RESET);
                    String outputFileNameEncode = sc.next();

                    AddSoftSubtitle.encodeSoftSubtitleIntoVideo(inputFilePathEncode, outputFileNameEncode, inputFilePathSubEncode);
                    break;
                case 4:
                    //Encode Hard subs to video
                    System.out.println(ANSI_BLUE + "Enter location of video with ext:" + ANSI_RESET);
                    String inputFilePathBurn = sc.next();

                    System.out.println(ANSI_CYAN + Italic + "------------NOTE:Please enter drive in this format D\\:/path/to/your/file.srt-----------" + ANSI_RESET);
                    System.out.println(ANSI_RED + "Otherwise prasing error" + ANSI_RESET);

                    System.out.println(ANSI_BLUE + "Enter location of soft subtitle with ext:" + ANSI_RESET);
                    String inputFilePathSubBurn = sc.next();

                    System.out.println(ANSI_BLUE + "Enter file name & ext:" + ANSI_RESET);
                    String outputFileBurn = sc.next();

                    BurnSubtitle.burnSubtitleIntoVideo(inputFilePathBurn, inputFilePathSubBurn, outputFileBurn);
                    break;

                case 5:
                    //Extract soft subs from video
                    System.out.println(ANSI_BLUE + "Enter location of video with ext:" + ANSI_RESET);
                    String inputFilePathExtract = sc.next();

                    System.out.println(ANSI_BLUE + "Enter file name & '.srt' ext:" + ANSI_RESET);
                    String outputFileNameExtract = sc.next();

                    ExtractSubtitle.extractSubtitleFromVideo(inputFilePathExtract, outputFileNameExtract);
                    break;
                case 6:
                    System.out.println(ANSI_RED + "Exited Successfully...." + ANSI_RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid Choice" + ANSI_RESET);
                    break;
            }
            System.out.println(ANSI_GREEN + "Operation Successfull!" + ANSI_RESET);
            sc.close();
        } catch (Exception e) {
            System.out.println(ANSI_PURPLE +"An unexpected error occurred: " + ANSI_RESET + ANSI_RED + e.getMessage() +ANSI_RESET);
        }
    }

    private static String centerText(String text) {
        int terminalWidth = getTerminalWidth();
        int spaces = (terminalWidth - text.length()) / 2;
        return " ".repeat(Math.max(0, spaces)) + text;
    }

    private static int getTerminalWidth() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "mode", "con");
            Process process = processBuilder.start();
            process.waitFor();
            if (process.exitValue() == 0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Columns")) {
                        // Extract the width from the output (e.g., "Columns:    120")
                        String[] parts = line.trim().split("\\s+");
                        if (parts.length >= 2) {
                            return Integer.parseInt(parts[1]);
                        }
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return 80; // default value
    }
}
