package jiedan;

import java.util.Scanner;

public class A字串出现次数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("请输入字串：");
        String s1 = scanner.nextLine();
        System.out.printf("亲输入字串:");
        String s2= scanner.nextLine();
        System.out.println("\""+s2+"\""+"在\""+s1+"\"中出现的次数为："+totalSubStringCount(s1, s2)+"次");
    }
    public static int totalSubStringCount(String base,String subString){
        if(subString == null || "".equals(subString)) return 0;
        int count = 0;
        int fromIndex = 0;
        while(true){
            int index = base.indexOf(subString, fromIndex);
            if(index == -1) break;
            fromIndex = index + 1;
            count++;
        }
        return count;
    }
}
