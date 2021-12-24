package test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TextCounter {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> symbols = new HashMap<>();
        Map<Character, String> symbolCiphers = new HashMap<>();
        List<Character> symbolsOrdered = new ArrayList<>();
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Sov\\IdeaProjects\\TestProject2\\src\\main\\resources\\other\\test.txt"));
        while (r.ready()) {
            char[] chars = r.readLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] < 'а' || chars[i] > 'я') && chars[i] != ' ' && chars[i] != 'і' && chars[i] != 'ї' && chars[i] != 'є' || chars[i] == 'ъ' || chars[i] == 'ы') {
                    System.out.println("Неправильні дані, символ " + chars[i] + " на позиції " + i);
                    return;
                }
                symbolsOrdered.add(chars[i]);
                if (symbols.get(chars[i]) != null) {
                    symbols.put(chars[i], symbols.get(chars[i]) + 1);
                } else {
                    symbols.put(chars[i], 1);
                }
            }
        }
        System.out.println("Кількість різних символів у тексті: " + symbols.size());
        int powerOfTwo = 0;
        while (Math.pow(2, powerOfTwo) < symbols.size()) {
            powerOfTwo++;
        }
        System.out.println("Найменший степінь двійки (кількість бітів): " + powerOfTwo);
        System.out.println("Найменше значення степеню двійки: " + (int)Math.pow(2, powerOfTwo));
        System.out.println("Символи у порядку зчитування: " + symbolsOrdered);
        System.out.println("Символи у порядку спадання частоти:");
        List<Map.Entry<Character, Integer>> collect = symbols.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());
        System.out.println(collect);

        List<Character> characters = new ArrayList<>(symbols.keySet());
        for (int i = 0; i < characters.size(); i++) {
            String currentCipher = Integer.toBinaryString(i);
            while(currentCipher.length() < powerOfTwo) {
                currentCipher = "0" + currentCipher;
            }
            symbolCiphers.put(characters.get(i), currentCipher);
            System.out.println("Шифр для " + characters.get(i) + ": " + currentCipher);
        }
        BufferedWriter w = new BufferedWriter(new FileWriter("C:\\Users\\Sov\\IdeaProjects\\TestProject2\\src\\main\\resources\\other\\res.txt"));
        for (int i = 0; i < symbolsOrdered.size(); i++) {
            w.write(symbolCiphers.get(symbolsOrdered.get(i)));
        }
        w.flush();
        w.close();
        r.close();
    }
}
