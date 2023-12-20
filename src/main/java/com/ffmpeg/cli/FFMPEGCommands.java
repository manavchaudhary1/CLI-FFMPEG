package com.ffmpeg.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class FFMPEGCommands{

    private static final String FFMPEG_PATH = "C:\\ProgramData\\chocolatey\\bin\\ffmpeg.exe";

    public static void convertVideoToAudio(String inputFilePath, String outputFilePath) throws IOException {
        String ffmpegCommand ="ffmpeg -i " + inputFilePath + " -vn -c:a aac -strict experimental " + outputFilePath;
        // Execute the FFMPEG command
        executeCommand(ffmpegCommand);
    }

    public static void encodeSoftSubtitleIntoVideo(String inputFilePath, String outputFilePath,String inputFilePathSub) throws IOException {
        String ffmpegCommand ="ffmpeg -i " + inputFilePath + " -i " + inputFilePathSub + " -c:s mov_text -c:v libx264 -c:a copy " + outputFilePath;
        executeCommand(ffmpegCommand);
    }

    public static void burnSubtitleIntoVideo(String inputFilePath, String outputFilePath, String inputFilePathSub) throws IOException {
        String ffmpegCommand = "ffmpeg -i " + inputFilePath + " -vf subtitle=" + inputFilePathSub + " " + outputFilePath;
        executeCommand(ffmpegCommand);
    }

    public static void extractSubtitleFromVideo(String inputFilePath, String outputFilePath) throws IOException {
        String ffmpegCommand = "ffmpeg -i " + inputFilePath + " -c:s srt " + outputFilePath;
        executeCommand(ffmpegCommand);
    }

    private static void executeCommand(String command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
        processBuilder.redirectErrorStream(true);  // Redirect error stream to input stream

        Process process = processBuilder.start();

        // Read the combined output and error streams
        try (InputStream inputStream = process.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new IOException("Command execution failed with exit code " + exitCode);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }




}
