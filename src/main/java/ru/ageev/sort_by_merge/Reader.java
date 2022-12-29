package ru.ageev.sort_by_merge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private final String pathWithoutName = "src/main/resources/";

    public String[] getStringsFromFiles(String... fileNames) {
        ArrayList<String> filesStrings = new ArrayList<>();
        String path;

        for (String name : fileNames) {
            path = pathWithoutName + name;

            try {
                Scanner scanner = new Scanner(new FileInputStream(path));

                while (scanner.hasNext()) {
                    String currentString = scanner.nextLine();

                    if (!currentString.contains(" ")) {
                        filesStrings.add(currentString);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        return filesStrings.toArray(new String[0]);
    }

    public int[] getNumbersArrayFromFile(String... fileNames) {
        ArrayList<Integer> filesNumbers = new ArrayList<>();
        String path;

        for (String name : fileNames) {
            path = pathWithoutName + name;

            try {
                Scanner scanner = new Scanner(new FileInputStream(path));

                while (scanner.hasNext()) {
                    String currentString = scanner.nextLine();

                    if (!currentString.contains(" ")) {
                        try {
                            filesNumbers.add(Integer.valueOf(currentString));
                        } catch (NumberFormatException ignored) {
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        return filesNumbers.stream().mapToInt(i -> i).toArray();
    }
}
