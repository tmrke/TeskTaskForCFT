package ru.try_again.sort_by_merge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    public String[] getStringArrayFromFile(String fileName) {
        ArrayList<String> fileStrings = new ArrayList<>();

        String pathWithoutName = "src/ru/try_again/resources/";
        String path = pathWithoutName + fileName;

        try {
            Scanner scanner = new Scanner(new FileInputStream(path));

            while (scanner.hasNext()) {                         // обработать пробелы
                String currentString = scanner.nextLine();

                if (!currentString.contains(" ")) {
                    fileStrings.add(currentString);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        String[] array = new String[fileStrings.size()];

        return fileStrings.toArray(array);
    }

    public int[] getIntArrayFromFile(String fileName) {
        String[] stringsArray = getStringArrayFromFile(fileName);

        int[] intArray = new int[stringsArray.length];

        return Arrays.stream(stringsArray).mapToInt(Integer::parseInt).toArray();
    }


}
