package fox.string;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Привет, как тебя зовут?");
//        String name = scanner.next();
//        System.out.println("Приятно познакомиться, " + name + ", сколько тебе лет?");
//        int age = scanner.nextInt();
//        System.out.println("Я " + name + " мне " + age + " лет");

        System.out.println("Сколько минимышей у нас есть?");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Минимыш " + i);
        }
    }
}
