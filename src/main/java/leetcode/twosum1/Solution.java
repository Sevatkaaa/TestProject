package leetcode.twosum1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int res = target - nums[i];
            Integer index = numbers.get(res);
            if (index != null) {
                return new int[]{index, i};
            }
            numbers.put(nums[i], i);
        }
        return new int[]{0, 1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] data = new int[]{3, 2, 4};
        int[] ints = s.twoSum(data, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
