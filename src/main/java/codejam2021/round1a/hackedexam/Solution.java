package codejam2021.round1a.hackedexam;

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
        int m = in.nextInt();
        if (n == 1) {
            String s = in.next();
            int score = in.nextInt();
            if (score >= m / 2) {
                return s + " " + score + "/1";
            } else {
                return inverse(s) + " " + score + "/1";
            }
        } else if (n == 2) {
            String s1 = in.next();
            int score1 = in.nextInt();
            String s2 = in.next();
            int score2 = in.nextInt();
            String s3 = inverse(s1);
            int score3 = m - score1;
            String s4 = inverse(s2);
            int score4 = m - score2;
            if (score1 >= score2 && score1 >= score3 && score1 >= score4) {
                return s1 + " " + score1 + "/1";
            } else if (score2 >= score1 && score2 >= score3 && score2 >= score4) {
                return s2 + " " + score2 + "/1";
            } else if (score3 >= score1 && score3 >= score2 && score3 >= score4) {
                return s3 + " " + score3 + "/1";
            } else {
                return s4 + " " + score4 + "/1";
            }
        }
        return "";
    }

    private static String inverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'T') {
                sb.append("F");
            } else {
                sb.append("T");
            }
        }
        return sb.toString();
    }
}
