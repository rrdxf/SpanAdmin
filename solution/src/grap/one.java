package grap;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int res;
        for (int i=1;i*i<30;i++){
            for (int j=i;i*j<30;j++){
                res=i*i+j*j;
                if (res>=a&&res<=b&&res%2==1){
                    System.out.println(res+"="+i*i+"+"+j*j);
                }
            }
        }
    }
}
