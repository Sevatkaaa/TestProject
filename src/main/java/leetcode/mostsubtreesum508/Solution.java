package leetcode.mostsubtreesum508;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> sums = new ArrayList<>();
        addSum(root, sums);
        Map<Integer, Integer> values = new HashMap<>();
        sums.forEach(s -> values.merge(s, 1, Integer::sum));
        List<Integer> max = new ArrayList<>();
        sums = new ArrayList<>(values.keySet());
        max.add(sums.get(0));
        int maxCount = values.get(sums.get(0));
        for (int i = 1; i < sums.size(); i++) {
            int sum = sums.get(i);
            Integer count = values.get(sum);
            if (count > maxCount) {
                maxCount = count;
                max = new ArrayList<>();
                max.add(sum);
            } else if (count == maxCount) {
                max.add(sum);
            }
        }
        int[] ans = new int[max.size()];
        for (int i = 0; i < max.size(); i++) {
            ans[i] = max.get(i);
        }
        return ans;
    }

    private int addSum(TreeNode root, List<Integer> sums) {
        if (root != null) {
            int leftSum = addSum(root.left, sums);
            int rightSum = addSum(root.right, sums);
            int sum = leftSum + rightSum + root.val;
            sums.add(sum);
            return sum;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(-5);
        TreeNode n1 = new TreeNode(5, n2, n3);
        int[] ans = s.findFrequentTreeSum(n1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
