package leetcode.linkednumsum2;

class ListNode {
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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean aNext = true;
        boolean bNext = true;
        int a, b, inc = 0;
        ListNode ans = new ListNode();
        ListNode cur = ans;
        do {
            if (aNext) {
                a = l1.val;
                l1 = l1.next;
            } else {
                a = 0;
            }
            if (bNext) {
                b = l2.val;
                l2 = l2.next;
            } else {
                b = 0;
            }
            aNext = l1 != null;
            bNext = l2 != null;
            int temp = a + b + inc;
            if (temp < 10) {
                cur.val = temp;
                inc = 0;
            } else {
                cur.val = temp - 10;
                inc = 1;
            }
            if (aNext || bNext) {
                cur.next = new ListNode();
                cur = cur.next;
            } else if (inc != 0) {
                cur.next = new ListNode(inc);
            }
        } while (aNext || bNext);
        return ans;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(5, l11);
        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(5, l21);
        Solution s = new Solution();
        ListNode listNode = s.addTwoNumbers(l12, l22);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
