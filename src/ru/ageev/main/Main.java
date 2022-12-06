package ru.ageev.main;

import ru.ageev.sort_by_merge.DataManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataManager.start("-s", "-d", "out.txt", "in4.txt", "in5.txt", "in6.txt");

        // "-s", "out.txt", "in4.txt", "in5.txt", "in6.txt"
    }
}