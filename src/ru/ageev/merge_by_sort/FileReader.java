package ru.ageev.merge_by_sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private List<String> lines;

    public FileReader(String path) {
        lines = new ArrayList<>();
        lines = getStringsListFromFile(path);
    }

    public String[] getStringsArray() {
        String[] stringsArray = new String[lines.size()];

        for (int i = 0; i < stringsArray.length; ++i) {
            stringsArray[i] = lines.get(i);
        }

        return stringsArray;
    }

    public List<String> getDataList() {
        return List.copyOf(lines);
    }

    public List<String> getStringsListFromFile(String path) {
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();

                if (!currentLine.contains(" ")) {
                    lines.add(currentLine);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return lines;
    }
}
