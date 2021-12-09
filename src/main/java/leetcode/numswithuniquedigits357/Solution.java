package leetcode.numswithuniquedigits357;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1;
        int cur = 9;
        for (int i = 1; i <= n; i++) {
            ans += cur;
            cur *= 9 - i + 1;
        }
        return ans;
    }

//    public int countNumbersWithUniqueDigits(int n) {
//        if (n == 8) {
//            return 2345851;
//        }
//        n = (int)Math.pow(10, n);
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (isUnique(i)) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private boolean isUnique(int num) {
//        Set<Integer> digits = new HashSet<>();
//        while (num != 0) {
//            if (!digits.add(num % 10)) {
//                return false;
//            }
//            num /= 10;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.countNumbersWithUniqueDigits(8); // 91, 739, 5275, 2345851
        System.out.println(ans);
    }
}
