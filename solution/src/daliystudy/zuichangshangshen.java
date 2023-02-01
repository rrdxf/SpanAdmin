package daliystudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class zuichangshangshen {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(9);
        list.add(4);
        list.add(8);

        System.out.println(LSubSequence(3, list));
    }
    static class Result{
        static int  max;
    }
    static Integer max=Integer.MIN_VALUE;
    public static int LSubSequence (int N, ArrayList<Integer> sequence) {
        // write code here

        if (N < 2)return 0;
        Result.max=Integer.MIN_VALUE;
        for (int i = 0; i < N-1; i++){
            Integer len = 1;
            Stack<Integer>stack=new Stack<>();
            stack.push(sequence.get(i));
            process(stack,N,sequence,i,len,Result.max);
            stack.pop();
        }
        return Result.max == 1? 0 : Result.max;
    }

    private static void process(Stack<Integer>stack,int n, ArrayList<Integer> sequence, int i, Integer len, int max) {
        if (i==n-1){
            Result.max=Result.max<len?len:Result.max;
        }
        for (int j=i+1;j<n;j++){

            if (stack.peek()<sequence.get(j)){
                len++;
                stack.push(sequence.get(j));
                process(stack,n,sequence,j,len,max);
                stack.pop();
                len--;
            }else {
                process(stack,n,sequence,j,len,max);
            }
        }
    }
}
