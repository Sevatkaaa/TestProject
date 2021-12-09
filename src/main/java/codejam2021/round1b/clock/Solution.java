package codejam2021.round1b.clock;

import java.util.*;
import java.io.*;
public class Solution {

    private static final long HOUR_TICKS = 360_000_000_0000L;
    private static final long TOTAL_TICKS = HOUR_TICKS * 12;
    private static final long TOTAL_TICKS_SEC_COUNT = TOTAL_TICKS / 1000_000_000L;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static String solve(Scanner in) {
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        List<Long> ans = checkAll(a, b, c);
        if (ans != null) {
            return ans.get(0) + " " + ans.get(1) + " " + ans.get(2) + " " + ans.get(3);
        }
        ans = checkAll(a, c, b);
        if (ans != null) {
            return ans.get(0) + " " + ans.get(1) + " " + ans.get(2) + " " + ans.get(3);
        }
        ans = checkAll(b, a, c);
        if (ans != null) {
            return ans.get(0) + " " + ans.get(1) + " " + ans.get(2) + " " + ans.get(3);
        }
        ans = checkAll(b, c, a);
        if (ans != null) {
            return ans.get(0) + " " + ans.get(1) + " " + ans.get(2) + " " + ans.get(3);
        }
        ans = checkAll(c, a, b);
        if (ans != null) {
            return ans.get(0) + " " + ans.get(1) + " " + ans.get(2) + " " + ans.get(3);
        }
        ans = checkAll(c, b, a);
        if (ans != null) {
            return ans.get(0) + " " + ans.get(1) + " " + ans.get(2) + " " + ans.get(3);
        }
        return "";
    }

    private static List<Long> checkAll(long a, long b, long c) {
        for (long i = 0; i < TOTAL_TICKS_SEC_COUNT; i++) {
            long aT = (a + i * (TOTAL_TICKS / TOTAL_TICKS_SEC_COUNT)) % TOTAL_TICKS;
            long bT = (b + i * (TOTAL_TICKS / TOTAL_TICKS_SEC_COUNT)) % TOTAL_TICKS;
            long cT = (c + i * (TOTAL_TICKS / TOTAL_TICKS_SEC_COUNT)) % TOTAL_TICKS;
            long atNanos = aT % 1000_000_000L;
            long btNanos = bT % 1000_000_000L;
            long ctNanos = cT % 1000_000_000L;
            if (ctNanos != 0 && ctNanos * 12 != btNanos && ctNanos * 720 != atNanos) {
                continue;
            }
            long hTicks = cT;
            long mTicks = hTicks * 12 % TOTAL_TICKS;
            long sTicks = cT * 720 % TOTAL_TICKS;
            if (mTicks == bT && sTicks == aT) {
                return Arrays.asList(hTicks / HOUR_TICKS, hTicks / (HOUR_TICKS / 60) % 60, sTicks / (TOTAL_TICKS / 60), ctNanos);
            }
        }
        return null;
    }
}
