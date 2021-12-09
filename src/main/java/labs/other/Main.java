package labs.other;

import java.io.*;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {

    private static final HashSet<String> words = new HashSet<>();
    private static final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    private static boolean isWordWithoutDuplicates(String test) { // "abcb"
        HashSet<Character> symbols = new HashSet<>();
        char[] chars = test.toCharArray(); // ['a', 'b', 'c', 'b']
        for (char c : chars) {
            symbols.add(c); // +a, +b, +c, (not +b)
        }
        return symbols.size() == test.length(); // 3 != 4
    }

    private static BufferedReader fileInput(String filePath) {
        try {
            File file = new File(filePath);

            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        String text;
        BufferedReader file = null;
        while (file == null) {
            System.out.println("Enter FULL file path:");
            String filePath = consoleReader.readLine();
            file = fileInput(filePath);
        }

        text = file.lines().collect(Collectors.joining( " ")); // all lines separated by space
        String[] splitedText = text.split("[^A-Za-z]"); // all words in array

        for (String word : splitedText) {
            word = word.toLowerCase(); // Hello -> hello
            if (word.length() > 30) { // if word is longer than 30, cut it
                word = word.substring(0, 30);
            }
            if (!word.isEmpty() && isWordWithoutDuplicates(word)) {
                words.add(word);
            }
        }
        System.out.println("Count of words: " + words.size());
        for (String word : words) {
            System.out.println(word);
        }
    }
}
