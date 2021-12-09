package leetcode.sum3closest16;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int move = 10100000 + target;
        boolean[] isSum = new boolean[target + 5 * move + 1];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    isSum[sum + move] = true;
                }
            }
        }
        if (isSum[target + move]) {
            return target;
        }
        for(int i = 1; i < Math.abs(target + move); i++) {
            if (isSum[target - i + move]) {
                return target - i;
            }
            if (isSum[target + i + move]) {
                return target + i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.threeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(ans);
    }
}
