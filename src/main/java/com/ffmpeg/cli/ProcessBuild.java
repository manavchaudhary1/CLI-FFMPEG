package com.ffmpeg.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessBuild {
    public static void executeCommand(String command) throws IOException {

        //ANSI Colors Codes
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_MAGENTA = "\u001B[35m";

        //Ansi Style Codes
        String Italic = "\u001B[3m";

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
                    if (line.toLowerCase().contains("error")) {
                        System.out.println(ANSI_RED + line + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_GREEN + line + ANSI_RESET);
                    }
                }

                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    throw new IOException(ANSI_MAGENTA+ "Command execution failed with exit code " +ANSI_RESET + ANSI_RED + Italic + exitCode + ANSI_RESET);
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
