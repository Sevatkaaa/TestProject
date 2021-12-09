package leetcode.climbingstairs70;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.climbStairs(5);
        System.out.println(ans);
    }
    public int climbStairs(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            ans[i] = ans[i - 2] + ans[i - 1];
        }
        return ans[n];
    }
}
