package leetcode.longconsseq128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        int max = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer num : numbers) {
            if (visited.contains(num)) {
                continue;
            }
            int nextNum = num + 1;
            int current = 1;
            while (numbers.contains(nextNum)) {
                visited.add(nextNum++);
                current++;
            }
            nextNum = num - 1;
            while (numbers.contains(nextNum)) {
                visited.add(nextNum--);
                current++;
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.longestConsecutive(new int[]{1, 5, 4, 3, 2});
        System.out.println(ans);
    }
}
