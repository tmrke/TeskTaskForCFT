package ru.ageev.merge_by_sort;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SorterByMerge {
    String[] getByAscendingSortingMergeData() throws FileNotFoundException;

    void writeToFile(String var1, SortMode var2) throws IOException;

    String[] getByDescendingSortingMergeData();
}
