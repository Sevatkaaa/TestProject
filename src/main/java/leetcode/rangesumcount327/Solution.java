package leetcode.rangesumcount327;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int count = 0;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = prefixSum[j + 1] - prefixSum[i];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.countRangeSum(new int[]{-2, 5, -1}, -2, 2);
        System.out.println(ans);
    }
}
