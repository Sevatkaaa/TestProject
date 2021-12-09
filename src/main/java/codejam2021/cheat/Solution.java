package codejam2021.cheat;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static final int a = 100;
    public static final int b = 10000;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int p = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static int solve(Scanner in) {
        Map<Integer, Integer> count = new HashMap<>();
        boolean[][] solved = new boolean[a][b];
        for (int i = 0; i < a; i++) {
            int countCur = 0;
            String s = in.next();
            for (int j = 0; j < b; j++) {
                if (s.charAt(j) == '1') {
                    solved[i][j] = true;
                    countCur++;
                }
            }
            count.put(i + 1, Math.abs(countCur));
        }
        List<String> s1 = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < a; j++) {
                if (solved[j][i]) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            s1.add(sb.toString());
        }
        s1.sort(Comparator.comparingInt(Solution::get1Count));
        s1 = s1.stream().filter(s -> get1Count(s) == 0).limit(b / 4).collect(Collectors.toList());
        int[] num = new int[a];
        for (int i = 0; i < s1.size(); i++) {
            for (int j = 0; j < a; j++) {
                if (s1.get(i).charAt(j) == '1') {
                    num[j] += (s1.size() - i);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > num[max]) {
                max = i;
            }
        }
        return max + 1;
    }

    private static int get1Count(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                c++;
            }
        }
        return c;
    }
}
