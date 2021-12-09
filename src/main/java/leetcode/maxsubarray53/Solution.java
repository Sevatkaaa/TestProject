package leetcode.maxsubarray53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int sum = 0;
        int maxSum = 0;
        int min = nums[0];
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] + sum <= 0) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
                sum = 0;
                continue;
            }
            if (nums[i] < 0) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
            sum += nums[i];
            found = true;
        }
        if (!found) {
            return min;
        }
        return Math.max(sum, maxSum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(ans);
    }
}
