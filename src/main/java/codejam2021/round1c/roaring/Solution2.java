package codejam2021.round1c.roaring;

import java.util.*;
import java.io.*;
public class Solution2 {
    private static final List<Long> roaring = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i < 1000000; i++) {
            String cur = "" + i;
            int next = i + 1;
            while (true) {
                cur += next;
                next++;
                if (cur.length() < 20) {
                    try {
                        roaring.add(Long.parseLong(cur));
                    } catch (Exception e) {

                    }
                } else {
                    break;
                }
            }
        }
        Collections.sort(roaring);
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static long solve(Scanner in) {
        long y = in.nextLong();
        if (y <= 1000000) {
            return binSearch(y);
        }
        return 0;
    }

    private static long binSearch(long y) {
        int left = 0;
        int right = roaring.size() - 1;
        while (true) {
            if (right - left == 1) {
                return roaring.get(left);
            }
            int index = (right - left) / 2 + left;
            Long cur = roaring.get(index);
            if (y == cur) {
                return roaring.get(index + 1);
            } else if (y > cur) {
                left = index;
            } else {
                if (y >= roaring.get(index - 1)) {
                    return cur;
                } else {
                    right = index;
                }
            }
        }
    }
}
