package leetcode.removeNfromend19;

public class Solution {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode realHead = head;
        ListNode mock = new ListNode(-1, head);
        boolean[] found = new boolean[1];
        int len = getLength(mock, head, n, found, realHead);
        if (!found[0]) {
            return head.next;
        }
        return realHead;
    }

    public int getLength(ListNode node, ListNode prev, int n, boolean[] found, ListNode realHead) {
        if (node == null) {
            return 0;
        }
        int len = 1 + getLength(node.next, node, n, found, realHead);
        if (len == n) {
            prev.next = node.next;
            found[0] = true;
            if (node == realHead) {
                found[0] = false;
            }
        }
        return len;
    }
}
