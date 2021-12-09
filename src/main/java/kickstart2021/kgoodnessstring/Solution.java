package kickstart2021.kgoodnessstring;

import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            System.out.println("Case #" + i + ": " + solve(n, k, s));
        }
    }

    private static int solve(int n, int k, String s) {
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                count++;
            }
        }
        return Math.abs(k - count);
    }
}
