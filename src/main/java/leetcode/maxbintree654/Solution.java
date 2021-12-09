package leetcode.maxbintree654;

import leetcode.common.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        if (left == right + 1) {
            return new TreeNode(nums[left]);
        }
        int maxIndex = left;
        for(int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, left, maxIndex);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, right);
        return root;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode ans = s.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(ans.val);
    }

}
