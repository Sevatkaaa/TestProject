package algorithms.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrefixSum {

    private List<Integer> sum = new ArrayList<>();

    public PrefixSum(List<Integer> numbers) {
        sum.add(0);
        for (int i = 1; i <= numbers.size(); i++) {
            sum.add(sum.get(i - 1) + numbers.get(i - 1));
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter array:");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = r.readLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String value : s1) {
            numbers.add(Integer.parseInt(value));
        }
        PrefixSum prefixSum = new PrefixSum(numbers);
        System.out.println("Enter num of queries:");
        int count = Integer.parseInt(r.readLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Enter l, r:"); // 1 3 // 1 2 3 4 5 // 1, 2, 3 = 0, 3 not inclusive
            String[] s2 = r.readLine().split(" ");
            int sum = prefixSum.getSum(Integer.parseInt(s2[0]) - 1,Integer.parseInt(s2[1]));
            System.out.println("Sum is " + sum);
        }
    }

    private int getSum(int l, int r) {
        return sum.get(r) - sum.get(l);
    }
}
