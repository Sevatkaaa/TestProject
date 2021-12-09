package codejam2021.round1a.appendsort;

import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(r));
        }
    }

    private static long solve(BufferedReader r) throws IOException {
        int n = Integer.parseInt(r.readLine());
        String[] nums = r.readLine().split(" ");
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += changeNum(nums, i);
        }
        return ans;
    }

    private static int changeNum(String[] nums, int i) {
        String cur = nums[i];
        String next = nums[i + 1];
        int nextLen = next.length();
        if (nextLen > cur.length()) {
            return 0;
        }
        String startCur = cur.substring(0, nextLen);
        String endCur = cur.substring(nextLen);
        int compare = startCur.compareTo(next);
        if (compare == 0) {
            if (isNineOnly(endCur)) {
                nums[i + 1] = nums[i + 1] + getZeros(endCur.length() + 1);
                return endCur.length() + 1;
            }
            String val = getNext(endCur);
            nums[i + 1] = nums[i + 1] + val;
            return val.length();
        } else if (compare < 0) {
            nums[i + 1] = nums[i + 1] + getZeros(endCur.length());
            return endCur.length();
        } else {
            nums[i + 1] = nums[i + 1] + getZeros(endCur.length() + 1);
            return endCur.length() + 1;
        }
    }

    private static String getNext(String s) {
        String ans = Long.parseLong(s) + 1 + "";
        if (ans.length() >= s.length()) {
            return ans;
        }
        return getZeros(s.length() - ans.length()) + ans;
    }

    private static String getZeros(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    private static boolean isNineOnly(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                return false;
            }
        }
        return true;
    }
}
