package example;


import java.util.List;

public class ReverseKGroup {
    static ListNode reverse (ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        while (cur != b) {
            nxt = cur.nxt;
            cur.nxt = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        a = b =head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.nxt;
        }
        ListNode newHead = reverse(a, b);
        a.nxt = reverseKGroup(b, k);
        return newHead;
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