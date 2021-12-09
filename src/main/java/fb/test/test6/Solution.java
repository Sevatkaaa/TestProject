package fb.test.test6;

public class Solution {
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
        Node(int x, Node next) {
            data = x;
            this.next = next;
        }
    }


    Node reverse(Node head) {
        Node realHead = head;
        if (head.data % 2 == 0 && head.next != null && head.next.data % 2 == 0) {
            Node lastNode = new Node(head.data);
            Node prevNode = lastNode;
            Node cur = head.next;
            while (cur != null && cur.data % 2 == 0) {
                Node prevLastNode = new Node(cur.data);
                prevLastNode.next = prevNode;
                prevNode = prevLastNode;
                cur = cur.next;
            }
            Node next = cur;
            realHead = prevNode;
            lastNode.next = next;
            head = next;
        }
        Node prev = null;
        while (head != null) {
            if (head.data % 2 != 0 || realHead == head) {
                prev = head;
                head = head.next;
            } else {
                Node lastNode = new Node(head.data);
                Node prevNode = lastNode;
                Node cur = head.next;
                while (cur != null && cur.data % 2 == 0) {
                    Node prevLastNode = new Node(cur.data);
                    prevLastNode.next = prevNode;
                    prevNode = prevLastNode;
                    cur = cur.next;
                }
                prev.next = prevNode;
                if (cur != null) {
                    head = lastNode.next = cur;
                } else {
                    return realHead;
                }
            }
        }
        return realHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node n6 = new Node(16);
        Node n5 = new Node(12, n6);
        Node n3 = new Node(8, n5);
        Node n2 = new Node(2, n3);
        Node ans = s.reverse(n2);
        while (ans != null) {
            System.out.println(ans.data + ", ");
            ans = ans.next;
        }
    }
}
