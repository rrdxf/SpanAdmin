package jianzhioffer;

public class Offer_6从尾到头打印链表 {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        int [] res = new int[count];
        count--;
        cur = head;
        for (;count >= 0; count--){
            res[count] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
