package leetcode.sumtoleafs129;

import java.util.LinkedList;
import java.util.Queue;

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

    public int sumNumbers(TreeNode root) {
        int[] sum = new int[]{0};
        if (root == null) {
            return sum[0];
        }
        bfs(root, 0, sum);
        return sum[0];
    }

    private void bfs(TreeNode root, int num, int[] sum) {
        if (root == null) {
            return;
        }
        int curNum = num * 10 + root.val;
        if (root.left != null || root.right != null) {
            bfs(root.left, curNum, sum);
            bfs(root.right, curNum, sum);
        } else {
            sum[0] += curNum;
        }
    }

    public static void main(String[] args) {
//        TreeNode n3 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n1 = new TreeNode(1);
        Solution s = new Solution();
        int ans = s.sumNumbers(n1);
        System.out.println(ans);
    }
}
