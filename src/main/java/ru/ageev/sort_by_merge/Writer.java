package ru.ageev.sort_by_merge;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Writer {
    private final FileOutputStream fileOutputStream;

    public Writer(String outputFileName) throws IOException {
        File outputFile = new File("src/main/resources/" + outputFileName);
        fileOutputStream = new FileOutputStream(outputFile, false);
    }


    public void writeToFile(String[] strings) throws IOException {
        for (String line : strings) {
            line = line + System.lineSeparator();
            fileOutputStream.write(line.getBytes(StandardCharsets.UTF_8));
        }

        fileOutputStream.close();
    }

    public void writeToFile(int[] numbers) throws IOException {
        for (int number : numbers) {
            fileOutputStream.write((number + System.lineSeparator()).getBytes());
        }

        fileOutputStream.close();
    }
}
