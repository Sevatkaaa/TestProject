package leetcode.reverseint7;

public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        long value = Long.parseLong(new StringBuilder(String.valueOf(x)).reverse().toString());
        if (value > Integer.MAX_VALUE) {
            return 0;
        }
        return isNegative ? -(int)value : (int)value;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.reverse(-1534236469);
        System.out.println(result);
    }
}
