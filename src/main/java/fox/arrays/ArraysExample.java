package fox.arrays;

public class ArraysExample {
    public static void main(String[] args) {
        int[] m = new int[5];
        for (int i = 0; i < m.length; i++) {
            m[i] = i * 2;
        }
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }
    }
}
