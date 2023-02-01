package daliystudy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class meituan2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a=new int[n];
        for (int i = 0;i < n; i++){
            a[i]=scanner.nextInt();
        }
        int left=0;
        int right=0;
        int win=0;
        int count=0;
        for (int i=0;i<n;i++){
            right=left+win;
            while(right<n){
                int result=1;
                for (int j= left;j<=right;j++){
                    result=result*a[j];
                }
                if (result>0){
                    count++;
                }
                right++;left++;
            }
            left=0;
            win++;
        }
        System.out.println(count);
    }
}
