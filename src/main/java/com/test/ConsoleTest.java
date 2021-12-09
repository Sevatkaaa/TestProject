package com.test;

import java.io.Console;
import java.io.IOException;

public class ConsoleTest {
    public static void main(String[] args) throws IOException {
        Console console = System.console();
        String s = console.readLine();
        for (int i = 0; i < 3; i++) {

            console.format("%s", s);
        }
    }
}
