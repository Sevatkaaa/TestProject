package leetcode.reverselist;

import leetcode.common.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode[] headAndPrev = getHeadAndPrev(head);
        headAndPrev[1].next = null;
        return headAndPrev[0];
    }

    private ListNode[] getHeadAndPrev(ListNode node) {
        if (node.next == null) {
            return new ListNode[]{node, node};
        }
        ListNode[] headAndPrev = getHeadAndPrev(node.next);
        headAndPrev[1].next = node;
        headAndPrev[1] = node;
        return headAndPrev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        Solution s = new Solution();
        ListNode ans = s.reverseList(n1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
