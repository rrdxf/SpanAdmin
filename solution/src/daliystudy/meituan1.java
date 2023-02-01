package daliystudy;

import java.util.Scanner;

public class meituan1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0;i < n ;i++){
            int num=scanner.nextInt();
            if (num % 11 == 0){
                System.out.println("yes");
                continue;
            }
            int count=0;
            while (num!=0){
                int flag=num%10;
                num=num/10;
                if (flag==1){
                    count++;
                }
            }
            if (count>=2){
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }
    }
}
