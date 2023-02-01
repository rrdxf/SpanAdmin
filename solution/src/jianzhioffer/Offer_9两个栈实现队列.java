package jianzhioffer;

import java.util.Stack;

public class Offer_9两个栈实现队列 {
    private static class CQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        public CQueue() {
        }

        public void appendTail(int value) {
            stack2.push(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty()){
                while (stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            }
            if (stack1.isEmpty() && stack2.isEmpty()){
                return -1;
            }
            return stack1.pop();
        }
    }

    public static void main(String[] args) {
        CQueue queue=new CQueue();
        queue.appendTail(3);
    }
}
