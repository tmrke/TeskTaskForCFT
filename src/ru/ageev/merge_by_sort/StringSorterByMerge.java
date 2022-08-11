package ru.ageev.merge_by_sort;

import java.io.IOException;

public class StringSorterByMerge implements SorterByMerge {
    private final String[][] stringsArrays;

    public StringSorterByMerge(FileReader... inputStringsArray) {
        stringsArrays = getStringsArrays(inputStringsArray);
    }

    private String[][] getStringsArrays(FileReader... inputStringsArray) {
        String[][] stringsArray = new String[inputStringsArray.length][];

        for (int i = 0; i < stringsArray.length; ++i) {
            stringsArray[i] = inputStringsArray[i].getStringsArray();
        }

        return stringsArray;
    }

    private String[] getSortStringData(String[] strings) {
        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;

            for (int i = 1; i < strings.length; i++) {
                if (strings[i].compareTo(strings[i - 1]) < 0) {
                    String temp = strings[i];
                    strings[i] = strings[i - 1];
                    strings[i - 1] = temp;

                    needIteration = true;
                }
            }
        }

        return strings;
    }

    @Override
    public String[] getByAscendingSortingMergeData() {
        String[] result = stringsArrays[0];

        for (int i = 0; i < stringsArrays.length - 1; ++i) {
            result = mergeTwoStringsArrays(result, stringsArrays[i + 1]);
        }

        return getSortStringData(result);
    }

    @Override
    public void writeToFile(String outputFileName, SortMode sortMode) throws IOException {
        Writer writer = new Writer(outputFileName);
        if (sortMode == SortMode.DESCENDING) {
            writer.writeToFile(getByDescendingSortingMergeData());
        } else {
            writer.writeToFile(getByAscendingSortingMergeData());
        }
    }

    @Override
    public String[] getByDescendingSortingMergeData() {
        String[] reverseStrings = new String[getSortStringData(getByAscendingSortingMergeData()).length];

        for (int i = 0; i < reverseStrings.length; ++i) {
            reverseStrings[i] = getSortStringData(getByAscendingSortingMergeData())[reverseStrings.length - 1 - i];
        }

        return reverseStrings;
    }

    private String[] mergeTwoStringsArrays(String[] array1, String[] array2) {
        String[] mergeArray = new String[array1.length + array2.length];

        int i = array1.length - 1;
        int j = array2.length - 1;

        for (int k = mergeArray.length; k > 0; mergeArray[k] = j >= 0
                && (i < 0 || array1[i].compareTo(array2[j]) < 0) ? array2[j--] : array1[i--]) {
            --k;
        }

        return mergeArray;
    }
}