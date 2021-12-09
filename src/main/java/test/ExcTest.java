package test;

public class ExcTest {
    public static void main(String[] args) {
        System.out.println(doThis());
    }

    private static int doThis() {
        try {
            throw new RuntimeException("123");
        } catch (Exception e) {
            return 1;
        } finally {
            return 0;
        }
    }
}
