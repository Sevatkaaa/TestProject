package labs.sort;

import java.io.*;
import java.util.*;

public class SortRunner {
    private static final String DIR = "/Users/sov/Desktop/Sov/projects/src/main/resources/sort/";
    private static final String FILE = "test10.txt";

    public static void main(String[] args) throws IOException {
        if (false) {
            doRegularSort();
        } else {
            doFileMergeSort(1000);
        }
    }

    private static void doRegularSort() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(DIR + FILE));
        List<String> words = new ArrayList<>();
        while (r.ready()) {
            words.add(r.readLine().trim());
        }
        r.close();
        long start = System.currentTimeMillis();
        librarySort(words);
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
//        System.out.println(words);
    }

    private static void doFileMergeSort(int fileSize) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(DIR + FILE));
        long start = System.currentTimeMillis();
        List<String> nums = new ArrayList<>();
        int fileNum = 0;
        while (r.ready()) {
            List<String> words = new ArrayList<>();
            for (int i = 0; i < fileSize && r.ready(); i++) {
                words.add(r.readLine());
            }
            librarySort(words);
            writeToFile(fileNum, words);
            fileNum++;
        }
        r.close();
        mergeFiles(fileNum);
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(nums);
    }

    private static void mergeFiles(int filesTotal) throws IOException {
        String fileName = DIR + "result/result.txt";
        BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
        List<BufferedReader> readers = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < filesTotal; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(DIR + "result/" + i + ".txt"));
            readers.add(reader);
            words.add(reader.readLine());
        }

        while (isNotEmpty(words)) {
            int minIndex = findMinIndex(words);
            w.write(words.get(minIndex) + "\n");
            BufferedReader reader = readers.get(minIndex);
            if (reader.ready()) {
                words.remove(minIndex);
                words.add(minIndex, reader.readLine().trim());
            } else {
                words.remove(minIndex);
                words.add(minIndex, null);
            }
        }

        readers.forEach(r -> {
            try {
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        w.close();
    }

    private static int findMinIndex(List<String> words) {
        String w = words.get(0);
        int index = 0;
        int i = 0;
        while (w == null) {
            w = words.get(++i);
            index++;
        }
        for (int j = i + 1; j < words.size(); j++) {
            String newWord = words.get(j);
            if (newWord == null) {
                continue;
            }
            if (newWord.compareTo(w) < 0) {
                w = newWord;
                index = j;
            }
        }
        return index;
    }

    private static boolean isNotEmpty(List<String> words) {
        return words.stream().anyMatch(Objects::nonNull);
    }

    private static void writeToFile(int fileNum, List<String> words) throws IOException {
        String fileName = DIR + "result/" + fileNum + ".txt";
        BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
        words.forEach(word -> {
            try {
                w.write(word + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        w.close();
    }

    private static void librarySort(List<String> nums) {
        LibrarySort<String> stringLibrarySort = new LibrarySort<>(10, String::compareTo);
        stringLibrarySort.sort(nums);
    }
}
