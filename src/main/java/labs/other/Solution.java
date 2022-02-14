package labs.other;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Будь ласка, введіть true/false");
        boolean a = true, b = true, aRead = false, bRead = false;
        while (!aRead) {
            try {
                a = s.nextBoolean();
                aRead = true;
            } catch (Exception e) {
                s = new Scanner(System.in);
                System.out.println("Будь ласка, введіть true/false");
            }
        }
        System.out.println("Будь ласка, введіть true/false");
        while (!bRead) {
            try {
                b = s.nextBoolean();
                bRead = true;
            } catch (Exception e) {
                s = new Scanner(System.in);
                System.out.println("Будь ласка, введіть true/false");
            }
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();
        System.out.println(!a);
        System.out.println(!b);
        System.out.println("Слабка конюнкція");
        System.out.println(a && b);
        System.out.println("Сильна конюнкція");
        System.out.println((a && !b) || (!a && b));
        System.out.println("Слабка дизюнкція");
        System.out.println(a || b);
        System.out.println("Сильна дизюнкція");
        System.out.println((!a || b) && (a || !b));
        System.out.println("Імплікація");
        System.out.println(!a || b);
        System.out.println(a == b);
        System.out.println("Штрих Шефера");
        System.out.println(!(a && b));
        System.out.println("Стрілка Пірса");
        System.out.println(!(a || b));
    }
}
