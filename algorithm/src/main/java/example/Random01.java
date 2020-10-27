package example;

import java.util.Random;

public class Random01 {

    public static int getRandom(ListNode head) {
        Random r = new Random();
        int i = 0, res = 0;
        ListNode p = head;
        while (p != null) {
            if (r.nextInt() == 0) {
                res = p.val;
            }
            p = p.nxt;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
