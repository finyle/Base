package datastruct;

import java.util.List;

public class ReverseParticalLinkedList {
    ListNode reverse(ListNode head) {
        if (head.nxt == null) return head;
        ListNode last = reverse(head.nxt);
        head.nxt.nxt = head;
        head.nxt = null;
        return last;
    }

    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.nxt;
            return head;
        }
        ListNode last = reverseN(head.nxt, n - 1);
        head.nxt.nxt = head;
        head.nxt = successor;
        return last;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.nxt = reverseBetween(head.nxt, m - 1, n - 1);
        return head;
    }
}

class ListNode {

     int val;
     ListNode nxt;
     ListNode() {};
     ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode nxt) {
        this.val = val;
        this.nxt = nxt;
    }
}
