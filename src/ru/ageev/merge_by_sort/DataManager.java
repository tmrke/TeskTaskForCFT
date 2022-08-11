package ru.ageev.merge_by_sort;

import java.io.IOException;

public class DataManager {
    private final SortMode sortMode;
    private final DataType dataType;
    private final String outputFileName;

    private final String[] inputFilesNames;

    public DataManager(String[] args) {
        if (args[1].contains("txt")) {
            sortMode = SortMode.ASCENDING;

            if (args[0].equals("-i")) {
                dataType = DataType.INTEGER;
            } else if (args[0].equals("-s")) {
                dataType = DataType.STRING;
            } else {
                System.out.println("Неккоректный аргумент для типа данных, по умолчанию будет использоваться \"-i\"");
                dataType = DataType.INTEGER;
            }

            outputFileName = args[1];
            inputFilesNames = new String[args.length - 2];

            System.arraycopy(args, 2, inputFilesNames, 0, inputFilesNames.length);
        } else {
            if (args[0].equals("-a") && args[1].equals("-i") || args[1].equals("-a") && args[0].equals("-i")) {
                sortMode = SortMode.ASCENDING;
                dataType = DataType.INTEGER;
            } else if (args[0].equals("-d") && args[1].equals("-i") || args[1].equals("-d") && args[0].equals("-i")) {
                sortMode = SortMode.DESCENDING;
                dataType = DataType.INTEGER;
            } else if (args[0].equals("-a") && args[1].equals("-s") || args[1].equals("-a") && args[0].equals("-s")) {
                sortMode = SortMode.ASCENDING;
                dataType = DataType.STRING;
            } else if (args[0].equals("-d") && args[1].equals("-s") || args[1].equals("-d") && args[0].equals("-s")) {
                sortMode = SortMode.DESCENDING;
                dataType = DataType.STRING;
            } else {
                System.out.println("Неккоректный аргумент для типа данных, по умолчанию будет использоваться \"-i\"");
                System.out.println("Неккоректный аргумент для варианта сортировки, по умолчанию будет использоваться \"-a\"");
                sortMode = SortMode.ASCENDING;
                dataType = DataType.INTEGER;
            }

            outputFileName = args[2];
            inputFilesNames = new String[args.length - 3];

            System.arraycopy(args, 3, inputFilesNames, 0, inputFilesNames.length);
        }
    }

    public SorterByMerge getMergeByType() {
        if (dataType == DataType.STRING) {
            return new StringSorterByMerge(getFileData(inputFilesNames));
        }

        if (dataType == DataType.INTEGER) {
            return new NumbersSorterByMerge(getFileData(inputFilesNames));
        }

        throw new IllegalArgumentException("Неверно введен параметр типа данных");
    }

    public FileReader[] getFileData(String[] inputFilesNames) {
        FileReader[] filesData = new FileReader[inputFilesNames.length];

        for (int i = 0; i < filesData.length; ++i) {
            filesData[i] = new FileReader("src/ru/ageev/resources/" + inputFilesNames[i]);
        }

        return filesData;
    }

    public void mergeSortAndWrite() throws IOException {
        SorterByMerge sorterByMerge = getMergeByType();
        sorterByMerge.writeToFile(outputFileName, sortMode);
    }
}