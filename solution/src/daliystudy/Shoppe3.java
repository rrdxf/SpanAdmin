package daliystudy;

import java.util.*;

public class Shoppe3 {
    private static class Res{
        int pro;
        int cap;
        int mon;
        public Res(int pro, int cap, int mon) {
            this.pro = pro;
            this.cap = cap;
            this.mon = mon;
        }
        public Res(){
        }
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // write code here
        PriorityQueue<Res>queue=new PriorityQueue<>(new Comparator<Res>() {
            @Override
            public int compare(Res o1, Res o2) {
                return o2.mon-o1.mon;
            }
        });
        PriorityQueue<Res>queue1=new PriorityQueue<>(new Comparator<Res>() {
            @Override
            public int compare(Res o1, Res o2) {
                return o1.cap-o2.cap;
            }
        });
        for (int i = 0 ; i < profits.length ; i++){
            queue.add(new Res(profits[i],capital[i],profits[i]-capital[i]));
            queue1.add(new Res(profits[i],capital[i],profits[i]-capital[i]));
        }
        int nowmoney=w;
        int now=w;
        while (k>0){
            Res flag=queue.peek();
            if (flag.cap <= nowmoney ) {//如果钱够就投资
                k--;
                nowmoney = nowmoney + flag.mon;
                now = now + flag.pro;
                queue.poll();
                queue1.remove(flag);
            }else {
                Res flag1=queue1.peek();
                if (flag1.cap<=nowmoney){
                    k--;
                    nowmoney = nowmoney + flag.mon;
                    now = now + flag.pro;
                    queue1.poll();
                    queue.remove(flag1);
                }
            }
        }
        return now;
    }

    public static void main(String[] args) {

    }
}
