package com.test;

public class Fish {
    String name;

    static String defaultName = "Default Fish";

    public Fish(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.println(name);
    }

    public static String getDefaultName() {
        return "Seva";
    }
}
