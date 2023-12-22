package com.ffmpeg.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessBuild {
    public static void executeCommand(String command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
        processBuilder.redirectErrorStream(true);  // Redirect error stream to input stream

        try {
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
        } catch (IOException e) {
            // Log the entire exception, including the stack trace
            e.printStackTrace();
            throw e;  // rethrow the exception for higher-level handling
        }
    }
}
