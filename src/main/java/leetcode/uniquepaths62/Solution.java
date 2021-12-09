package leetcode.uniquepaths62;

public class Solution {
    public int uniquePaths(int m, int n) {
        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }
        int b = n - 1;
        int a = b + m - 1;
        if (a < 2 * b) {
            b = a - b;
        }
        long x = 1;
        long y = 1;
        for (int i = 0; i < b; i++) {
            x *= a - i;
            y *= i + 1;
        }
        return (int) (x / y);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.uniquePaths(3, 2);
        System.out.println(ans);
    }
}
