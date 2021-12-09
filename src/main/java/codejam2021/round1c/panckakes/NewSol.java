package codejam2021.round1c.panckakes;

import java.util.*;
import java.io.*;
public class NewSol {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static String solve(Scanner in) {
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            p.add(in.nextInt());
        }
        if (n == 1) {
            return String.format("%.8f", 1.0 * (k - 1) / k);
        }
        Collections.sort(p);
        List<Integer> nums = new ArrayList<>();
        List<Integer> realNums = new ArrayList<>();
        nums.add(p.get(0) - 1);
        for (int i = 0; i < n - 1; i++) {
            int cur = p.get(i);
            int next = p.get(i + 1);
            if (next != cur) {
                nums.add((next - cur) / 2);
                realNums.add(next - cur - 1);
            }
        }
        int difNums = new HashSet<>(p).size();
        nums.add(k - p.get(p.size() - 1));
        Collections.sort(nums);
        Collections.sort(realNums);
        int sum = nums.get(nums.size() - 1) + nums.get(nums.size() - 2);
        int sum2 = realNums.get(realNums.size() - 1);
        if (sum < 2 && k - difNums == 2) {
            sum = 2;
        }
        return String.format("%.8f", 1.0 * Math.max(sum, sum2) / k);
    }
}
