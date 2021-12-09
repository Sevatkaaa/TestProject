package leetcode.targetsum494;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target || nums[0] == -target ? 1 : 0;
        }
        List<Integer> firstNums = countSum(nums, 0, (n - 1) / 2);
        List<Integer> secondNums = countSum(nums, (n + 1) / 2, n - 1);
        Map<Integer, List<Integer>> numValues = firstNums.stream().collect(Collectors.groupingBy(Function.identity()));
        int ans = 0;
        for (int i = 0; i < secondNums.size(); i++) {
            int curSum = secondNums.get(i);
            List<Integer> integers = numValues.get(target - curSum);
            if (integers != null) {
                ans += integers.size();
            }
        }
        return ans;
    }

    private List<Integer> countSum(int[] nums, int start, int finish) {
        if (start == finish) {
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[start]);
            ans.add(-nums[start]);
            return ans;
        }
        int cur = nums[finish];
        List<Integer> allSums = countSum(nums, start, finish - 1);
        List<Integer> ans = new ArrayList<>();
        allSums.stream().forEach(s -> {
            ans.add(s + cur);
            ans.add(s - cur);
        });
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int targetSumWays = s.findTargetSumWays(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}
