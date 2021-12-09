package com.test;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(new File("/Users/sov/Desktop/qooco/tasks/appUpdates2/buffer AppUpdates2.txt")));
        while(r.ready()) {
            System.out.println(r.readLine());
        }
    }
}
