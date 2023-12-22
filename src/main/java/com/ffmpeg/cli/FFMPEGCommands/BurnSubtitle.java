package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;

import java.io.IOException;

public class BurnSubtitle {
    public static void burnSubtitleIntoVideo(String inputFilePath, String inputFilePathSub, String outputFilePath) throws IOException {
        String ffmpegCommand = "ffmpeg -i " + inputFilePath + " -vf subtitles=" + inputFilePathSub + " " + outputFilePath;
        ProcessBuild.executeCommand(ffmpegCommand);
    }
}
