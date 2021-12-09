package codejam2021.reversort;

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
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = getMinIndex(nums, i);
            reverse(nums, j, i);
            ans += j - i + 1;
        }
        return ans;
    }

    private static int getMinIndex(int[] nums, int i) {
        int min = i;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] < nums[min]) {
                min = j;
            }
        }
        return min;
    }

    private static void reverse(int[] nums, int j, int i) {
        for (int k = i; k < (j + i + 1) / 2; k++) {
            int temp = nums[k];
            nums[k] = nums[j + i - k];
            nums[j + i - k] = temp;
        }
    }
}
