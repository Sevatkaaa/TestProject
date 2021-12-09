package kickstart2021.lshapedplots;

import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(r, c, in));
        }
    }

    private static int solve(int r, int c, Scanner in) {
        int sum = 0;
        String[] rows = new String[r];
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                sb.append(in.next());
            }
            rows[i] = sb.toString();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += sum(rows, r, c, i, j);
            }
        }
        return sum;
    }

    private static int sum(String[] rows, int r, int c, int i, int j) {
        if (rows[i].charAt(j) == '0') {
            return 0;
        }
        int top = 0;
        for (int k = i; k >= 0; k--) {
            if (rows[k].charAt(j) == '1') {
                top++;
            } else {
                break;
            }
        }
        int bottom = 0;
        for (int k = i; k < r; k++) {
            if (rows[k].charAt(j) == '1') {
                bottom++;
            } else {
                break;
            }
        }
        int right = 0;
        for (int k = j; k < c; k++) {
            if (rows[i].charAt(k) == '1') {
                right++;
            } else {
                break;
            }
        }
        int left = 0;
        for (int k = j; k >= 0; k--) {
            if (rows[i].charAt(k) == '1') {
                left++;
            } else {
                break;
            }
        }
        if (top == 1 && bottom == 1 || left == 1 && right == 1) {
            return 0;
        }
        int num = 0;
        // top long
        if (top > 3) {
            num += Math.min(top / 2 - 1, right - 1);
            num += Math.min(top / 2 - 1, left - 1);
        }
        // bottom long
        if (bottom > 3) {
            num += Math.min(bottom / 2 - 1, right - 1);
            num += Math.min(bottom / 2 - 1, left - 1);
        }
        // left long
        if (left > 3) {
            num += Math.min(left / 2 - 1, top - 1);
            num += Math.min(left / 2 - 1, bottom - 1);
        }
        // right long
        if (right > 3) {
            num += Math.min(right / 2 - 1, top - 1);
            num += Math.min(right / 2 - 1, bottom - 1);
        }
        return num;
    }
}
