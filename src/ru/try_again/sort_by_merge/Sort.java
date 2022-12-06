package ru.try_again.sort_by_merge;

public class Sort {
    public static String[] getDescSortStringsArray(String[] array1, String[] array2) {
        String[] resultArray = new String[array1.length + array2.length];
        int i = 0, j = 0;

        stringsArraySortCheck(array1);
        stringsArraySortCheck(array2);

        for (int k = resultArray.length - 1; k >= 0; k--) {
            if (i > array1.length - 1) {
                resultArray[k] = array2[j];
                j++;
            } else if (j > array2.length - 1) {
                resultArray[k] = array1[i];
                i++;
            } else if (array1[i].compareTo(array2[j]) < 0) {
                resultArray[k] = array1[i];
                i++;
            } else if (array1[i].compareTo(array2[j]) >= 0) {
                resultArray[k] = array2[j];
                j++;
            }
        }

        return resultArray;
    }

    public static String[] getAscSortStringsArray(String[] array1, String[] array2) {
        String[] resultArray = new String[array1.length + array2.length];
        int i = 0, j = 0;

        stringsArraySortCheck(array1);
        stringsArraySortCheck(array2);

        for (int k = 0; k < resultArray.length; k++) {
            if (i > array1.length - 1) {
                resultArray[k] = array2[j];
                j++;
            } else if (j > array2.length - 1) {
                resultArray[k] = array1[i];
                i++;
            } else if (array1[i].compareTo(array2[j]) < 0) {
                resultArray[k] = array1[i];
                i++;
            } else if (array1[i].compareTo(array2[j]) >= 0) {
                resultArray[k] = array2[j];
                j++;
            }
        }

        return resultArray;
    }

    public static int[] getDescSortNumbersArray(int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        int i = 0, j = 0;

        numbersArraySortCheck(array1);
        numbersArraySortCheck(array2);

        for (int k = resultArray.length - 1; k >= 0; k--) {
            if (i > array1.length - 1) {
                resultArray[k] = array2[j];
                j++;
            } else if (j > array2.length - 1) {
                resultArray[k] = array1[i];
                i++;
            } else if (array1[i] < array2[j]) {
                resultArray[k] = array1[i];
                i++;
            } else if (array1[i] >= array2[j]) {
                resultArray[k] = array2[j];
                j++;
            }
        }

        return resultArray;
    }

    public static int[] getAscSortNumbersArray(int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        int i = 0, j = 0;

        numbersArraySortCheck(array1);
        numbersArraySortCheck(array2);

        for (int k = 0; k < resultArray.length; k++) {
            if (i > array1.length - 1) {
                resultArray[k] = array2[j];
                j++;
            } else if (j > array2.length - 1) {
                resultArray[k] = array1[i];
                i++;
            } else if (array1[i] < array2[j]) {
                resultArray[k] = array1[i];
                i++;
            } else if (array1[i] >= array2[j]) {
                resultArray[k] = array2[j];
                j++;
            }
        }

        return resultArray;
    }

    private static void numbersArraySortCheck(int[] array) {
        boolean arrayIsSort = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                arrayIsSort = false;
                break;
            }
        }

        if (!arrayIsSort) {
            for (int i = 0; i < array.length - 1; i++) {
                int minNumberIndex = i;

                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[minNumberIndex]) {
                        minNumberIndex = j;
                    }
                }

                int temp = array[i];
                array[i] = array[minNumberIndex];
                array[minNumberIndex] = temp;
            }
        }
    }

    //TODO поменять stringsArraySortCheck и numbersArraySortCheck на сотрировку слиянием
    /*
    Необходимо самостоятельно реализовать алгоритм сортировки методом слияния и использовать
    его для сортировки содержимого файлов. Не использовать библиотечные функции сортировки.

    разбить неотсортированный массив на 2 подмассива и сортировать слиянием
    */

    private static void stringsArraySortCheck(String[] array) {
        boolean arrayIsSort = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                arrayIsSort = false;
                break;
            }
        }

        if (!arrayIsSort) {
            for (int i = 0; i < array.length - 1; i++) {
                int minNumberIndex = i;

                for (int j = i + 1; j < array.length; j++) {
                    if (array[j].compareTo(array[minNumberIndex]) < 0) {
                        minNumberIndex = j;
                    }
                }

                String temp = array[i];
                array[i] = array[minNumberIndex];
                array[minNumberIndex] = temp;
            }
        }
    }
}