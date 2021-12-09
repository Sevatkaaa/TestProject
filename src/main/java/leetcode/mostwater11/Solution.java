package leetcode.mostwater11;

public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int val = Math.min(height[left], height[right]) * (right - left);
            if (val > max) {
                max = val;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.maxArea(new int[]{1, 2, 1});
        System.out.println(ans);
    }
}
