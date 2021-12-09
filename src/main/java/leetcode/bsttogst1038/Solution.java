package leetcode.bsttogst1038;

import leetcode.common.TreeNode;

public class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    private int dfs(TreeNode root) {
        if (root != null) {
            int s1 = dfs(root.right);
            sum += s1 + root.val;
            root.val = sum;
            return dfs(root.left);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n0;
        n1.right = n2;
        n2.right = n3;
        n4.left = n1;
        n4.right = n6;
        n6.left = n5;
        n6.right = n7;
        n7.right = n8;
        TreeNode treeNode = s.bstToGst(n4);
        System.out.println(treeNode.val);
    }
}
