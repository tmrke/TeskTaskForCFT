package ru.ageev.sort_by_merge;

import java.util.Arrays;

public class Sort {
    private static boolean isNumbersArraySort(int[] array) {             //проверка, что массив отсортирован по возрастанию. Оставил Warning, в угоду тому, что бы не использовать отрицание в названии функции
        for (int i = 0; i <= array.length; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isStringsArraySort(String[] array) {
        for (int i = 0; i <= array.length; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] getAscSortNumbersArray(int[] inputArray) {
        int i = 0;
        int j = 0;

        int[] subArray1 = Arrays.copyOfRange(inputArray, 0, inputArray.length / 2);
        int[] subArray2 = Arrays.copyOfRange(inputArray, inputArray.length / 2, inputArray.length);

        int[] array = new int[inputArray.length];

        if (!isNumbersArraySort(subArray1)) {
            subArray1 = getAscSortNumbersArray(subArray1);
        }

        if (!isNumbersArraySort(subArray2)) {
            subArray2 = getAscSortNumbersArray(subArray2);
        }

        for (int k = 0; k < array.length; k++) {
            if (i >= subArray1.length) {
                array[k] = subArray2[j];
                j++;
            } else if (j >= subArray2.length) {
                array[k] = subArray1[i];
                i++;
            } else if (subArray1[i] < subArray2[j]) {
                array[k] = subArray1[i];
                i++;
            } else {
                array[k] = subArray2[j];
                j++;
            }
        }

        return array;
    }

    public static int[] getDescSortNumbersArray(int[] inputArray) {
        int i = 0, j = 0;

        int[] subArray1 = Arrays.copyOfRange(inputArray, 0, inputArray.length / 2);
        int[] subArray2 = Arrays.copyOfRange(inputArray, inputArray.length / 2, inputArray.length);

        int[] array = new int[inputArray.length];

        if (!isNumbersArraySort(subArray1)) {
            subArray1 = getAscSortNumbersArray(subArray1);
        }

        if (!isNumbersArraySort(subArray2)) {
            subArray2 = getAscSortNumbersArray(subArray2);
        }

        for (int k = array.length - 1; k >= 0; k--) {
            if (i >= subArray1.length) {
                array[k] = subArray2[j];
                j++;
            } else if (j >= subArray2.length) {
                array[k] = subArray1[i];
                i++;
            } else if (subArray1[i] < subArray2[j]) {
                array[k] = subArray1[i];
                i++;
            } else {
                array[k] = subArray2[j];
                j++;
            }
        }

        return array;
    }

    public static String[] getAscSortStringsArray(String[] inputArray) {
        int i = 0, j = 0;

        String[] subArray1 = Arrays.copyOfRange(inputArray, 0, inputArray.length / 2);
        String[] subArray2 = Arrays.copyOfRange(inputArray, inputArray.length / 2, inputArray.length);

        String[] array = new String[inputArray.length];

        if (!isStringsArraySort(subArray1)) {
            subArray1 = getAscSortStringsArray(subArray1);
        }

        if (!isStringsArraySort(subArray2)) {
            subArray2 = getAscSortStringsArray(subArray2);
        }

        for (int k = 0; k < array.length; k++) {
            if (i >= subArray1.length) {
                array[k] = subArray2[j];
                j++;
            } else if (j >= subArray2.length) {
                array[k] = subArray1[i];
                i++;
            } else if (subArray1[i].compareTo(subArray2[j]) < 0) {
                array[k] = subArray1[i];
                i++;
            } else {
                array[k] = subArray2[j];
                j++;
            }
        }

        return array;
    }

    public static String[] getDescSortStringsArray(String[] inputArray) {
        int i = 0, j = 0;

        String[] subArray1 = Arrays.copyOfRange(inputArray, 0, inputArray.length / 2);
        String[] subArray2 = Arrays.copyOfRange(inputArray, inputArray.length / 2, inputArray.length);

        String[] array = new String[inputArray.length];

        if (!isStringsArraySort(subArray1)) {
            subArray1 = getAscSortStringsArray(subArray1);
        }

        if (!isStringsArraySort(subArray2)) {
            subArray2 = getAscSortStringsArray(subArray2);
        }

        for (int k = array.length - 1; k >= 0; k--) {
            if (i >= subArray1.length) {
                array[k] = subArray2[j];
                j++;
            } else if (j >= subArray2.length) {
                array[k] = subArray1[i];
                i++;
            } else if (subArray1[i].compareTo(subArray2[j]) < 0) {
                array[k] = subArray1[i];
                i++;
            } else {
                array[k] = subArray2[j];
                j++;
            }
        }

        return array;
    }
}