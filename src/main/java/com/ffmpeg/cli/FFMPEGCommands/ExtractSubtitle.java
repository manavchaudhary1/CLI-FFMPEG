package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;
import java.io.IOException;

public class ExtractSubtitle {
    public static void extractSubtitleFromVideo(String inputFilePath, String outputFilePath) throws IOException {
        String ffmpegCommand = "ffmpeg -i " + inputFilePath + " -c:s srt " + outputFilePath;
        ProcessBuild.executeCommand(ffmpegCommand);
    }
}
