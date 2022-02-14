package fox;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exam {
    StringBuilder getSB() {
        StringBuilder returnVal = new StringBuilder("5");
        try {
            String[] s = {"123", "12"};
            System.out.println(s[2]);
        } catch (Exception e) {
            System.out.println("Return of method: " + returnVal);
            return returnVal;
        } finally {
            returnVal.append("5");
            System.out.println("Return of method: " + returnVal);
            return returnVal;
        }
    }
    public static void main(String[] args) {
        Exam e = new Exam();
        System.out.println(e.getSB());
    }
}
