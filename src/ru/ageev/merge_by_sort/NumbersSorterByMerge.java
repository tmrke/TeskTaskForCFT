package ru.ageev.merge_by_sort;

import java.io.IOException;
import java.util.ArrayList;

public class NumbersSorterByMerge implements SorterByMerge {
    private final int[][] numbersArrays;

    public NumbersSorterByMerge(FileReader... inputStringsArray) {
        numbersArrays = getNumbersArrays(inputStringsArray);
    }

    private int[][] getNumbersArrays(FileReader... inputStringsArray) {
        int[][] numbersArrays = new int[inputStringsArray.length][];

        for (int i = 0; i < inputStringsArray.length; ++i) {
            ArrayList<Integer> numbersList = new ArrayList<>();

            for (int j = 0; j < inputStringsArray[i].getDataList().size(); ++j) {
                try {
                    numbersList.add(Integer.parseInt(inputStringsArray[i].getDataList().get(j)));
                } catch (NumberFormatException e) {
                    ++j;
                }
            }

            numbersArrays[i] = new int[numbersList.size()];

            for (int k = 0; k < numbersList.size(); ++k) {
                numbersArrays[i][k] = numbersList.get(k);
            }
        }

        return numbersArrays;
    }

    private int[] getSortNumbersData(int[] numbers) {
        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;

            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[i - 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = temp;

                    needIteration = true;
                }
            }
        }

        return numbers;
    }

    @Override
    public String[] getByAscendingSortingMergeData() {
        int[] result = numbersArrays[0];

        for (int i = 0; i < numbersArrays.length - 1; ++i) {
            result = mergeTwoNumbersArrays(result, numbersArrays[i + 1]);
        }

        return convertToString(getSortNumbersData(result));
    }

    private int[] mergeTwoNumbersArrays(int[] array1, int[] array2) {
        int[] mergeArray = new int[array1.length + array2.length];
        int i = array1.length - 1;
        int j = array2.length - 1;

        for (int k = mergeArray.length; k > 0; mergeArray[k] = j >= 0
                && (i < 0 || array1[i] < array2[j]) ? array2[j--] : array1[i--]) {
            --k;
        }

        return mergeArray;
    }

    @Override
    public void writeToFile(String outputFileName, SortMode sortMode) throws IOException {
        Writer writer = new Writer(outputFileName);

        if (sortMode == SortMode.ASCENDING) {
            writer.writeToFile(getByAscendingSortingMergeData());
        } else {
            writer.writeToFile(getByDescendingSortingMergeData());
        }
    }

    @Override
    public String[] getByDescendingSortingMergeData() {
        String[] reverseStrings = new String[getByAscendingSortingMergeData().length];

        for (int i = 0; i < reverseStrings.length; ++i) {
            reverseStrings[i] = getByAscendingSortingMergeData()[reverseStrings.length - 1 - i];
        }

        return reverseStrings;
    }

    private String[] convertToString(int[] numbersArray) {
        String[] stringsArray = new String[numbersArray.length];

        for (int i = 0; i < numbersArray.length; ++i) {
            stringsArray[i] = String.valueOf(numbersArray[i]);
        }

        return stringsArray;
    }
}