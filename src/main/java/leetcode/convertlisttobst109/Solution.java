package leetcode.convertlisttobst109;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return createBst(nums, 0, nums.size() - 1, Integer.MIN_VALUE);
    }

    private TreeNode createBst(List<Integer> nums, int l, int r, int val) {
        if (l == r - 1) {
            TreeNode left = new TreeNode(nums.get(l));
            TreeNode root = new TreeNode(nums.get(r));
            root.left = left;
            return root;
        }
        if (l == r) {
            return new TreeNode(nums.get(l));
        }
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums.get(m));
        TreeNode left = createBst(nums, l, m - 1, root.val);
        TreeNode right = createBst(nums, m + 1, r, root.val);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        TreeNode treeNode = s.sortedListToBST(n1);
        System.out.println(treeNode.val);
    }

}
