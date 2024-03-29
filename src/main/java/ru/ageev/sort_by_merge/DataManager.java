package ru.ageev.sort_by_merge;

import java.io.IOException;

public class DataManager {
    public static void start(String... parameters) {
        try {
            SortMode sortMode;
            DataType dataType;
            String outputFileName;
            String[] inputFileNames;

            if (parameters[1].contains("txt")) {
                sortMode = SortMode.ASCENDING;

                if (parameters[0].equals("-i")) {
                    dataType = DataType.INTEGER;
                } else if (parameters[0].equals("-s")) {
                    dataType = DataType.STRING;
                } else {
                    System.out.println("Некорректный аргумент для типа данных, по умолчанию будет использоваться \"-i\"");
                    dataType = DataType.INTEGER;
                }

                outputFileName = parameters[1];
                inputFileNames = new String[parameters.length - 2];

                System.arraycopy(parameters, 2, inputFileNames, 0, inputFileNames.length);
            } else {
                if (parameters[0].equals("-a") && parameters[1].equals("-i") || parameters[1].equals("-a") && parameters[0].equals("-i")) {
                    sortMode = SortMode.ASCENDING;
                    dataType = DataType.INTEGER;
                } else if (parameters[0].equals("-d") && parameters[1].equals("-i") || parameters[1].equals("-d") && parameters[0].equals("-i")) {
                    sortMode = SortMode.DESCENDING;
                    dataType = DataType.INTEGER;
                } else if (parameters[0].equals("-a") && parameters[1].equals("-s") || parameters[1].equals("-a") && parameters[0].equals("-s")) {
                    sortMode = SortMode.ASCENDING;
                    dataType = DataType.STRING;
                } else if (parameters[0].equals("-d") && parameters[1].equals("-s") || parameters[1].equals("-d") && parameters[0].equals("-s")) {
                    sortMode = SortMode.DESCENDING;
                    dataType = DataType.STRING;
                } else {
                    System.out.println("Некорректный аргумент для типа данных, по умолчанию будет использоваться \"-i\"");
                    System.out.println("Некорректный аргумент для варианта сортировки, по умолчанию будет использоваться \"-a\"");
                    sortMode = SortMode.ASCENDING;
                    dataType = DataType.INTEGER;
                }

                outputFileName = parameters[2];
                inputFileNames = new String[parameters.length - 3];
                System.arraycopy(parameters, 3, inputFileNames, 0, inputFileNames.length);
            }

            Reader reader = new Reader();
            Writer writer = new Writer(outputFileName);

            if (sortMode == SortMode.ASCENDING && dataType == DataType.INTEGER) {
                writer.writeToFile(Sort.getAscSortNumbersArray(reader.getNumbersArrayFromFile(inputFileNames)));
            } else if (sortMode == SortMode.DESCENDING && dataType == DataType.INTEGER) {
                writer.writeToFile(Sort.getDescSortNumbersArray(reader.getNumbersArrayFromFile(inputFileNames)));
            } else if (sortMode == SortMode.ASCENDING) {
                writer.writeToFile(Sort.getAscSortStringsArray(reader.getStringsFromFiles(inputFileNames)));
            } else {
                writer.writeToFile(Sort.getDescSortStringsArray(reader.getStringsFromFiles(inputFileNames)));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Для корректного запуска программы нужно указать минимум 2 аргумента: имена исходного и результирующего файлов");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
