package codejam2021.round1c.roaring;

import java.util.*;
import java.io.*;
public class Solution {

    static class Node {
        String val;
        int count;
        Node left;
        Node right;

        public Node(String val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static String solve(Scanner in) {
        Set<String> present = new HashSet<>();
        String a = in.next();
        String b = in.next();
        Node n = new Node(a, 0);
        Queue<Node> q = new LinkedList<>();
        if (a.equals(b)) {
            return "0";
        }
        q.add(n);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            String notA = not(cur.val);
            String doubled = doubled(cur.val);
            if (notA.equals(b) || doubled.equals(b)) {
                return cur.count + 1 + "";
            }
            cur.left = new Node(notA, cur.count + 1);
            cur.right = new Node(doubled, cur.count + 1);
            if (!present.contains(cur.left.val)) {
                q.add(cur.left);
                present.add(cur.left.val);
            }
            if (!present.contains(cur.right.val)) {
                q.add(cur.right);
                present.add(cur.right.val);
            }
            if (present.size() > 80000) {
                return "IMPOSSIBLE";
            }
        }
        return "IMPOSSIBLE";
    }

    private static String doubled(String a) {
        if (a.equals("0")) {
            return a;
        }
        return a + "0";
    }

    private static String not(String a) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') {
                s.append("1");
            } else {
                s.append("0");
            }
        }
        String s1 = s.toString();
        if (!s1.contains("1")) {
            return "0";
        }
        return s1.substring(s1.indexOf('1'));
    }
}
