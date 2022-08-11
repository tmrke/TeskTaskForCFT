package ru.ageev.main;

import ru.ageev.merge_by_sort.DataManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataManager dataManager = new DataManager(args);
        dataManager.mergeSortAndWrite();
        //-s out.txt in4.txt in5.txt in6.txt
    }
}