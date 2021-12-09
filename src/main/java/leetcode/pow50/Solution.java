package leetcode.pow50;

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        boolean isNegative = false;
        boolean isTooLow = false;
        boolean isTooHigh = false;
        if (n == Integer.MAX_VALUE) {
            isTooHigh = true;
            n--;
        }
        if (n < 0) {
            if (n < Integer.MIN_VALUE + 2) {
                isTooLow = true;
                n += 2;
            }
            isNegative = true;
        }
        if (isTooLow) {
            return myPow(x, n) / x / x;
        }
        if (isTooHigh) {
            return myPow(x, n -1) * x;
        }
        if (n % 2 == 0) {
            double pow = myPow(x, n / 2);
            return pow * pow;
        } else {
            double pow = myPow(x, n / 2);
            if (isNegative) {
                return pow * pow / x;
            }
            return pow * pow * x;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        double v = s.myPow(2, Integer.MIN_VALUE);
        System.out.println(v);
    }
}
