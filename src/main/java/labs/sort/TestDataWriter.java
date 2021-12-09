package labs.sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestDataWriter {
    private static final String DIR = "/Users/sov/Desktop/Sov/projects/src/main/resources/sort/";
    private static final String FILE = "test10.txt";

    public static void main(String[] args) throws IOException {
        String fileName = DIR + FILE;
        BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < 4000000; i++) {
            String s = "";
            for (int j = 0; j < 10; j++) {
                char v1 = (char) ((int)(Math.random() * 10) + 48);
                char v2 = (char) ((int)(Math.random() * 26) + 97);
                double random = Math.random();
                if (random > 0.66) {
                    s += v1;
                } else if (random > 0.33){
                    s += v2;
                }
            }
            w.write(s + "\n");
        }
        w.close();
    }
}
