package codejam2021.round1b.subs;

import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static int solve(Scanner in) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        if (a == 1 && b == 2) {
            if (nums[0] > nums[1]) {
                int temp = (nums[0] - nums[1] + 1) / 2;
                nums[1] += temp;
                nums[0] -= temp;
            }
            int ans = 0;
            int pow = 1;
            for (int i = 0; i < n; i++) {
                ans += pow * nums[i];
                pow *= 2;
            }
            int count = 0;
            while (ans > 0) {
                ans /= 2;
                count++;
            }
            return count;
        } else {
            return nums[n - 1] + 1;
        }
    }
}
