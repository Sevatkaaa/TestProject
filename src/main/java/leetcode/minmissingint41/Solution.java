package leetcode.minmissingint41;

class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] isPresent = new boolean[301];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 && num < 302) {
                isPresent[num] = true;
            }
        }
        for (int i = 1; i < 301; i++) {
            if (!isPresent[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] n = new int[]{1, 2, 4};
        int a = s.firstMissingPositive(n);
        System.out.println(a);
    }
}
