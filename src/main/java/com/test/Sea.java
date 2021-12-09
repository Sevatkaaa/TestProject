package com.test;

public class Sea {
    Fish fish;
    int length;
    int width;

    public Sea(Fish fish) {
        this.fish = fish;
    }

    public Sea(Fish fish, int length, int width) {
        this.fish = fish;
        this.length = length;
        this.width = width;
    }

    public void showFishName() {
        System.out.println(fish.name);
    }

    public void showShape() {
        System.out.println(length * width);
    }
}
