package leetcode.relranks506;

import java.util.*;

public class Solution {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < n; i++) {
            values.put(score[i], i);
        }
        String[] ans = new String[n];
        Arrays.sort(score);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                ans[values.get(score[i])] = "Gold Medal";
            } else if (i == n - 2) {
                ans[values.get(score[i])] = "Silver Medal";
            } else if (i == n - 3) {
                ans[values.get(score[i])] = "Bronze Medal";
            } else {
                ans[values.get(score[i])] = n - i + "";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ans = s.findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        for (String a : ans) {
            System.out.println(a + " ");
        }
    }

}
