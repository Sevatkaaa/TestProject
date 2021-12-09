package leetcode.usglynumber264;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n < 7) {
            return n;
        }
        List<Long> ugly = new ArrayList<>();
        ugly.add(1L);
        ugly.add(2L);
        ugly.add(3L);
        ugly.add(4L);
        ugly.add(5L);
        ugly.add(6L);
        int count = 6;
        long num = 6;
        while (count < n) {
            long minUgly = Long.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                Long u = ugly.get(i);
                if (u * 2 > num && u * 2 < minUgly) {
                    minUgly = u * 2;
                }
                if (u * 3 > num && u * 3 < minUgly) {
                    minUgly = u * 3;
                }
                if (u * 5 > num && u * 5 < minUgly) {
                    minUgly = u * 5;
                }
            }
            num = minUgly;
            ugly.add(minUgly);
            count++;
        }
        return (int)(long)ugly.get(n - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.nthUglyNumber(1690);
        System.out.println(ans);
    }
}
