package com.test;

public class PrintTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            System.out.println(1);
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Finished in " + (finishTime - startTime) + " ms");
    }
}
