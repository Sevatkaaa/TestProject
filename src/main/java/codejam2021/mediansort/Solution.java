package codejam2021.mediansort;

import java.io.*;
import java.util.*;

public class Solution {

    private static int questions = 0;
    private static int max_q = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();
        max_q = q;
        for (int ipo = 0; ipo < t; ipo++) {
            boolean ttt = solve(n, in);
            if (!ttt) {
                return;
            }
        }
    }

    private static boolean solve(int n, Scanner in) {
        List<Integer> allNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            allNums.add(i + 1);
        }
        int a = 1;
        int b = 2;
        int c = 3;
        List<Integer> ans = new ArrayList<>();
        ask(a, b, c);
        int median123 = in.nextInt();
        int minVal;
        int maxVal;
        if (median123 == b) {
            minVal = a;
            maxVal = c;
            ans.add(a);
            ans.add(b);
            ans.add(c);
        } else if (median123 == a) {
            minVal = b;
            maxVal = c;
            ans.add(b);
            ans.add(a);
            ans.add(c);
        } else {
            minVal = a;
            maxVal = b;
            ans.add(a);
            ans.add(c);
            ans.add(b);
        }
        allNums.remove(new Integer(a));
        allNums.remove(new Integer(b));
        allNums.remove(new Integer(c));
        for (int i = 0; i < n - 3; i++) {
            int cur = allNums.get(i);
            ask(minVal, maxVal, cur);
            int curMed = in.nextInt();
            if (curMed == maxVal) {
                ans.add(cur);
                maxVal = cur;
            } else if (curMed == minVal) {
                ans.add(0, cur);
                minVal = cur;
            } else {
                insertIntoMiddle(ans, 1, ans.size() - 2, cur, in);
            }
        }
        printAnswer(ans);
        return in.nextInt() == 1;
    }

    private static void insertIntoMiddle(List<Integer> ans, int first, int last, int cur, Scanner in) {
        if (last < first) {
            ans.add(first, cur);
            return;
        }
        if (last == first) {
            Integer lastVal = ans.get(last);
            int minVal = ans.get(0);
            ask(minVal, lastVal, cur);
            int curMed = in.nextInt();
            if (curMed == lastVal) {
                ans.add(last + 1, cur);
            } else {
                ans.add(last, cur);
            }
            return;
        }
        if (last - first == 1) {
            Integer lastVal = ans.get(last);
            Integer firstVal = ans.get(first);
            ask(lastVal, firstVal, cur);
            int curMed = in.nextInt();
            if (curMed == cur) {
                ans.add(first + 1, cur);
            } else if (curMed == firstVal) {
                ans.add(first, cur);
            } else {
                ans.add(first + 2, cur);
            }
            return;
        }
        int middle1 = (last - first + 2) / 3 + first - 1;
        int middle2 = (last - first + 2) / 3 * 2 + first - 1;
        ask(ans.get(middle1), ans.get(middle2), cur);
        int curMed = in.nextInt();
        if (curMed == cur) {
            insertIntoMiddle(ans, middle1 + 1, middle2 - 1, cur, in);
        } else if (curMed == ans.get(middle1)) {
            insertIntoMiddle(ans, first, middle1 - 1, cur, in);
        } else {
            insertIntoMiddle(ans, middle2 + 1, last, cur, in);
        }
    }

    private static void printAnswer(List<Integer> ans) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());
        System.out.flush();
    }

    private static void ask(int a, int b, int c) {
        questions++;
        System.out.println(a + " " + b + " " + c);
        System.out.flush();
    }
}
