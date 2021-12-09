package kickstart2021.rabbithouse;

import java.io.*;

public class GenRand {
    public static void main(String[] args) throws IOException {
        File f = new File("/Users/sov/Desktop/Sov/projects/src/main/java/kickstart2021/rabbithouse/test.txt");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(r.readLine());
        int i2 = Integer.parseInt(r.readLine());
        BufferedWriter w = new BufferedWriter(new FileWriter(f));
        for (int i = 0; i < i1; i++) {
            int [] t = new int[i2];
            for (int j = 0; j < i2; j++) {
                t[j] = (int)(Math.random() * 2000000);
                w.write(t[j] + " ");
            }
            w.write("\n");
        }
        w.close();
        r.close();
    }
}
