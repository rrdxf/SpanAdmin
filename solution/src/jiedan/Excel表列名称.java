package jiedan;

import java.util.Scanner;

public class Excel表列名称 {
    public static void main(String[] args) {
        int columnNumber ;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.printf("columnNumber = ");
            columnNumber = scanner.nextInt();
            StringBuilder res = new StringBuilder("");

            char c;
            int b;
            int flag = 0;
            while (columnNumber != 0){
                b = columnNumber % 26;
                if (b == 0){
                    res.insert(0,'Z');
                    columnNumber = columnNumber/26;
                    break;
                }
                c = (char) ('@' + b);
                columnNumber = columnNumber/26;
                //for (int i = 0 ; i < columnNumber ; i++)c++;
                res.insert(0,c);
            }
            System.out.println(res);
        }
    }

}
