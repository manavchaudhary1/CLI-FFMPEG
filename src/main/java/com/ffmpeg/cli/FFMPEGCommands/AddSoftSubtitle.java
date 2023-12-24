package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;
import java.io.IOException;

public class AddSoftSubtitle {
    public static void encodeSoftSubtitleIntoVideo(String inputFilePath, String outputFilePath, String inputFilePathSub) throws IOException {
        String videoCodec = inputFilePathSub.matches("(?i).*mp4") ? "libx264" : "libx265";
        System.out.println("----Right now only mp4 & mkv are only supported----");
        String ffmpegCommand = "ffmpeg -i " + inputFilePath + " -i " + inputFilePathSub + " -c:s srt -c:v " + videoCodec + " -c:a copy " + outputFilePath;
        ProcessBuild.executeCommand(ffmpegCommand);
    }
}

