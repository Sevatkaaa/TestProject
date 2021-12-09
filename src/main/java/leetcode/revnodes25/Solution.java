package leetcode.revnodes25;

import leetcode.common.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode ans = s.reverseKGroup(n1, 3);
        System.out.println(ans.val);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode r = reverse(head, k, 0);
        return r;
    }

    private ListNode reverse(ListNode cur, int k, int i) {
        ListNode mock = new ListNode();
        ListNode next = cur.next;
        cur.next = mock;
        return null;
    }
}
