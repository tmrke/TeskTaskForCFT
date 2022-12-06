package ru.try_again.sort_by_merge;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {        //переделать все на long
        Reader reader = new Reader();

        int[] arr1 = reader.getIntArrayFromFile("in4.txt");
        int[] arr2 = reader.getIntArrayFromFile("in5.txt");

        String[] arr3 = reader.getStringArrayFromFile("in1.txt");
        System.out.println(Arrays.toString(arr3));

        String[] arr4 = reader.getStringArrayFromFile("in2.txt");
        System.out.println(Arrays.toString(arr4));

        System.out.println(Arrays.toString(Sort.getAscSortStringsArray(arr3, arr4)));
        System.out.println(Arrays.toString(Sort.getDescSortStringsArray(arr3, arr4)));
    }
}
