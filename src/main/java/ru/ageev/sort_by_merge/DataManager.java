package ru.ageev.sort_by_merge;

import java.io.IOException;

public class DataManager {
    public static void start(String... parameters) throws IOException {
        SortMode sortMode;
        DataType dataType;
        String outputFileName;
        String[] inputFilesNames;

        if (parameters[1].contains("txt")) {
            sortMode = SortMode.ASCENDING;

            if (parameters[0].equals("-i")) {
                dataType = DataType.INTEGER;
            } else if (parameters[0].equals("-s")) {
                dataType = DataType.STRING;
            } else {
                System.out.println("Неккоректный аргумент для типа данных, по умолчанию будет использоваться \"-i\"");
                dataType = DataType.INTEGER;
            }

            outputFileName = parameters[1];
            inputFilesNames = new String[parameters.length - 2];

            System.arraycopy(parameters, 2, inputFilesNames, 0, inputFilesNames.length);
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
                System.out.println("Неккоректный аргумент для типа данных, по умолчанию будет использоваться \"-i\"");
                System.out.println("Неккоректный аргумент для варианта сортировки, по умолчанию будет использоваться \"-a\"");
                sortMode = SortMode.ASCENDING;
                dataType = DataType.INTEGER;
            }

            outputFileName = parameters[2];
            inputFilesNames = new String[parameters.length - 3];
            System.arraycopy(parameters, 3, inputFilesNames, 0, inputFilesNames.length);
        }

        Reader reader = new Reader();
        Writer writer = new Writer(outputFileName);

        if (sortMode == SortMode.ASCENDING && dataType == DataType.INTEGER) {
            writer.writeToFile(Sort.getAscSortNumbersArray(reader.getNumbersArrayFromFile(inputFilesNames)));
        } else if (sortMode == SortMode.DESCENDING && dataType == DataType.INTEGER) {
            writer.writeToFile(Sort.getDescSortNumbersArray(reader.getNumbersArrayFromFile(inputFilesNames)));
        } else if (sortMode == SortMode.ASCENDING) {
            writer.writeToFile(Sort.getAscSortStringsArray(reader.getStringsFromFiles(inputFilesNames)));
        } else {
            writer.writeToFile(Sort.getDescSortStringsArray(reader.getStringsFromFiles(inputFilesNames)));
        }
    }
}
