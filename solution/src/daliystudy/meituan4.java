package daliystudy;

import java.util.Scanner;
import java.util.Stack;

public class meituan4 {


    static class Result{
        static Integer min=Integer.MAX_VALUE;
        static Integer count=0;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int m=scanner.nextInt();
        int [] a=new int[n+1];
        int [] b=new int[m];
        for (int i=0;i<m;i++){
            b[i]=scanner.nextInt();
        }
        int now=1;

        process(1,1,a,b,n,m);
        System.out.println(Result.min);
    }

    private static void process(int nowsite,int nowtime, int[] a, int[] b, int n, int m) {
        if (nowtime==m){
            if (Result.count<Result.min){
                Result.min=Result.count;
                //Result.count=0;
            }
            return;
        }
        for (int i=1;i<=m;i++){
            if (nowsite==i)continue;
            if (nowsite==b[nowtime]){
                Result.count++;
                process(i+1,nowtime+1,a,b,n,m);
                continue;
            }
            process(i,nowtime+1,a,b,n,m);
        }
    }
}
