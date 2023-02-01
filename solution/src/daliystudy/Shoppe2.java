package daliystudy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Shoppe2 {
    private static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(2);
        l1.next.next.next=new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next=new ListNode(8);
        l2.next.next=new ListNode(7);
        l2.next.next.next=new ListNode(6);
        l1=MergeList(null,null);
        while (l1!=null){
            System.out.println(l1.val+" ");
            l1=l1.next;
        }
    }
    public static ListNode MergeList(ListNode l1, ListNode l2) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val- o2.val;
            }
        });
        ListNode next = l1;

        while (next != null){
            queue.add(next);
            next=next.next;
        }
        next = l2;
        while (next != null){
            queue.add(next);
            next=next.next;
        }
        ListNode res = queue.poll();
        next = res;
        while (!queue.isEmpty()){
            next.next= queue.poll();
            next=next.next;
        }
        next.next=null;
        return res;
    }
}
