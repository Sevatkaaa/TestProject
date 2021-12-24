package test;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalizer {
    public static void main(String[] args) throws IOException {
        System.out.println("Введіть шаблон слова: ");
        String regexp = new Scanner(System.in).next();
        List<Character> symbols = new ArrayList<>();
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Sov\\IdeaProjects\\TestProject2\\src\\main\\resources\\other\\test.txt"));
        while (r.ready()) {
            char[] chars = r.readLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] < 'a' || chars[i] > 'z') && chars[i] != ' ') {
                    System.out.println("Неправильні дані через сивол " + chars[i]);
                    return;
                }
                symbols.add(chars[i]);
            }
        }
        String text = "";
        for (int i = 0; i < symbols.size(); i++) {
            text += symbols.get(i);
        }
        System.out.println("Текст: " + text);
        String[] words = text.split(" ");
        Pattern pattern = Pattern.compile(regexp);
        for (int i = 0; i < words.length; i++) {
            Matcher matcher = pattern.matcher(words[i]);
            if (matcher.find()) {
                System.out.println(words[i]);
            }
        }
        r.close();
    }
}
