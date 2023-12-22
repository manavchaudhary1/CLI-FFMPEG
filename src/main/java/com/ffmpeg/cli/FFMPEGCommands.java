package com.ffmpeg.cli;

import java.io.IOException;
public class FFMPEGCommands{

    private static final String FFMPEG_PATH = "C:\\ProgramData\\chocolatey\\bin\\ffmpeg.exe";

    public static void convertVideoToAudio(String inputFilePath, String outputFilePath) throws IOException {
        String ffmpegCommand ="ffmpeg -i " + inputFilePath + " -vn -c:a aac -strict experimental " + outputFilePath;
        // Execute the FFMPEG command
        ProcessBuild.executeCommand(ffmpegCommand);
    }

    public static void encodeSoftSubtitleIntoVideo(String inputFilePath, String outputFilePath,String inputFilePathSub) throws IOException {
        String ffmpegCommand ="ffmpeg -i " + inputFilePath + " -i " + inputFilePathSub + " -c:s mov_text -c:v libx264 -c:a copy " + outputFilePath;
        ProcessBuild.executeCommand(ffmpegCommand);
    }

    public static void burnSubtitleIntoVideo(String inputFilePath, String inputFilePathSub, String outputFilePath) throws IOException {
        String ffmpegCommand = "ffmpeg -i " + inputFilePath + " -vf subtitles=" + inputFilePathSub + " " + outputFilePath;
        ProcessBuild.executeCommand(ffmpegCommand);
    }

    public static void extractSubtitleFromVideo(String inputFilePath, String outputFilePath) throws IOException {
        String ffmpegCommand = "ffmpeg -i " + inputFilePath + " -c:s srt " + outputFilePath;
        ProcessBuild.executeCommand(ffmpegCommand);
    }
}
