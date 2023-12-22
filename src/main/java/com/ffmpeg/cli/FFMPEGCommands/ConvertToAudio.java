package com.ffmpeg.cli.FFMPEGCommands;

import com.ffmpeg.cli.ProcessBuild;
import java.io.IOException;

public class ConvertToAudio {
    public static void convertVideoToAudio(String inputFilePath, String outputFilePath) throws IOException {
        String ffmpegCommand ="ffmpeg -i " + inputFilePath + " -vn -c:a aac -strict experimental " + outputFilePath;
        // Execute the FFMPEG command
        ProcessBuild.executeCommand(ffmpegCommand);
    }
}
