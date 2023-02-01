package daliystudy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A360_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int p=scanner.nextInt();
        int q=scanner.nextInt();
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < n; i++){
            queue.add(scanner.nextInt());
        }
        int dx=0;
        for (int i = 0; i < n-1; i++){
            int a=queue.poll();
            if (a > queue.peek()){
                dx++;
            }
            double scoler = (p*(100-dx)+q*a)/100;
            if (scoler>=60)count++;
        }
        double scoler = (p*(100-dx)+q*queue.poll())/100;
        if (scoler>=60)count++;
        System.out.println(count);
    }
}
