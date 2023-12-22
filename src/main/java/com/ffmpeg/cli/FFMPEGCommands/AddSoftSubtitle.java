package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;

import java.io.IOException;

public class AddSoftSubtitle {
    public static void encodeSoftSubtitleIntoVideo(String inputFilePath, String outputFilePath,String inputFilePathSub) throws IOException {
        String ffmpegCommand ="ffmpeg -i " + inputFilePath + " -i " + inputFilePathSub + " -c:s mov_text -c:v libx264 -c:a copy " + outputFilePath;
        ProcessBuild.executeCommand(ffmpegCommand);
    }
}
