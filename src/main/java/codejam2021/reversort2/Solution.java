package codejam2021.reversort2;

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

    private static String solve(Scanner in) {
        int n = in.nextInt();
        int c = in.nextInt();
        if (c < n - 1 || c > n * (n + 1) / 2 - 1) {
            return "IMPOSSIBLE";
        }
        c -= n - 1;
        int[] nums = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            ans[i] = 1;
        }
        for (int i = 0; i < n && c > 0; i++) {
            int curMax = n - i - 1;
            if (c < curMax) {
                continue;
            }
            c -= curMax;
            ans[i] += curMax;
        }
        for (int i = n - 1; i >= 0; i--) {
            reverse(nums, n - 1, n - ans[i]);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(nums[i]).append(" ");
        }
        return answer.toString().trim();
    }

    private static void reverse(int[] nums, int j, int i) {
        for (int k = i; k < (j + i + 1) / 2; k++) {
            int temp = nums[k];
            nums[k] = nums[j + i - k];
            nums[j + i - k] = temp;
        }
    }

}
