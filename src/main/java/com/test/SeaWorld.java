package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SeaWorld {
    public static void main(String[] args) throws IOException {
        String name1;
        System.out.println("Enter fish name:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        name1 = reader.readLine();
        String name2 = "Seva";
        Fish fishechka = new Fish(name1);
        Fish fishechka2 = new Fish(name2);
        List<Fish> fishes = new ArrayList<>();
        fishes.add(fishechka);
        fishes.add(fishechka2);
        fishechka.showName();
        fishechka2.showName();
//        Sea sea = new Sea(fishechka, 10, 20);
//        sea.showFishName();
//        sea.showShape();
    }
}
