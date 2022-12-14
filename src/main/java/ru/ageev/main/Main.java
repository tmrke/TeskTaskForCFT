package ru.ageev.main;

import ru.ageev.sort_by_merge.DataManager;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        DataManager.start(args);
        System.out.println("Hello CFT!");
        System.out.println(Arrays.toString(args));

        // -s out.txt in4.txt in5.txt in6.txt
    }
}