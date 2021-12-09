package leetcode.rotateList61;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tempHead = head;
        ListNode last = null;
        while (tempHead != null) {
            len++;
            if (tempHead.next == null) {
                last = tempHead;
            }
            tempHead = tempHead.next;
        }
        k %= len;
        ListNode newHead = getElement(head, k, len);
        last.next = head;
        return newHead;
    }

    private ListNode getElement(ListNode head, int k, int len) {
        while (len != k + 1) {
            head = head.next;
            len--;
        }
        ListNode tempNode = head.next;
        head.next = null;
        return tempNode;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        Solution s = new Solution();
        ListNode listNode = s.rotateRight(n1, 0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
