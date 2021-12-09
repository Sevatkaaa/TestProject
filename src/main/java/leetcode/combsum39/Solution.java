package leetcode.combsum39;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, 0, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int curIndex, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = curIndex; i < candidates.length; i++) {
            int c = candidates[i];
            if (c == target) {
                List<Integer> e = new ArrayList<>();
                e.add(c);
                ans.add(e);
            } else if (c < target) {
                List<List<Integer>> ansPrev = combinationSum(candidates, i, target - c);
                if (!ansPrev.isEmpty()) {
                    ansPrev.stream().peek(ap -> ap.add(c)).forEach(ans::add);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] c = new int[]{2,3,6,7};
        List<List<Integer>> lists = s.combinationSum(c, 7);
        System.out.println(lists);
    }
}
