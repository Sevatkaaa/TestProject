package com.test;

public class BoolTest {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = new String("123").intern();
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
    }
}
