package ru.ageev.merge_by_sort;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Writer {
    private final FileOutputStream fileOutputStream;

    public Writer(String outputFileName) throws IOException {
        File outputFile = new File("src/ru/ageev/resources/" + outputFileName);

        //noinspection ResultOfMethodCallIgnored
        outputFile.createNewFile();
        fileOutputStream = new FileOutputStream(outputFile, false);
    }

    public void writeToFile(String[] strings) throws IOException {
        for (String line : strings) {
            line = line + System.lineSeparator();
            fileOutputStream.write(line.getBytes(StandardCharsets.UTF_8));
        }

        fileOutputStream.close();
    }
}
