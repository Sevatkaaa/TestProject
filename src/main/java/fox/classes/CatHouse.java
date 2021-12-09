package fox.classes;

import java.util.Scanner;

public class CatHouse {
    public static void main(String[] args) {
//        Cat elya = new Cat("Elya", 13);
//        Cat semen = new Cat("Semen", 10);
//        Cat emptyCat = new Cat();
//
//        System.out.println("Hello, I am " + elya.name + " my age is " + elya.age);
//        System.out.println("Hello, I am " + semen.name + " my age is " + semen.age);
//        System.out.println("Hello, I am " + emptyCat.name + " my age is " + emptyCat.age);
        System.out.println("Сколько всего котов?");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count > Cat.maxCount) {
            count = Cat.maxCount;
            System.out.println("Максимум может быть " + Cat.maxCount + " котов");
        }
        Cat[] cats = new Cat[count];
        for (int i = 0; i < count; i++) {
            cats[i] = new Cat(scanner.next(), scanner.nextInt());
        }

        cats[0].printCat();
        System.out.println(cats[0].getName());
        cats[0].setName("EmptyCat");
        Cat.printCatCount();
    }
}
