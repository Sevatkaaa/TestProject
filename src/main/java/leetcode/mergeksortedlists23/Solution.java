package leetcode.mergeksortedlists23;

import java.util.Arrays;

public class Solution {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        ListNode[] curNodes = new ListNode[n];
        ListNode dummy = new ListNode();
        ListNode realAns = dummy;
        for (int i = 0; i < n; i++) {
            curNodes[i] = lists[i];
        }
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (curNodes[i] != null && curNodes[i].val < min) {
                    min = curNodes[i].val;
                    minIndex = i;
                }
            }
            if (min == Integer.MAX_VALUE) {
                break;
            }
            dummy.next = new ListNode(min);
            dummy = dummy.next;
            curNodes[minIndex] = curNodes[minIndex].next;
        }
        return realAns.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode s1 = s.new ListNode(1);
        ListNode s2 = s.new ListNode(2);
        ListNode s3 = s.new ListNode(3);
        ListNode[] q = new ListNode[3];
        q[0] = s1;
        q[1] = s2;
        q[2] = s3;
        ListNode ans = s.mergeKLists(q);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
