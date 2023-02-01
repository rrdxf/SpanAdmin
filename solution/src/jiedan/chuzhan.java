package jiedan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class chuzhan {
    //static char[] in={'a','b','c'};

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Set<String> set=new HashSet<>();
        int n=scanner.nextInt();
        scanner.nextLine();
        String s=scanner.nextLine();
        String[] ss=s.split(",");
        char [] c=new char[n];
        StringBuilder stringBuilder=new StringBuilder("");
        for (int i=0;i<n;i++){
            c[i]=ss[i].charAt(0);
            stringBuilder.append(ss[i].charAt(0));
        }
        fun(c,set,0,new Stack<Character>(),"");
        if (set.contains(stringBuilder.toString())){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    static void fun(char[] in,Set<String> set, int n, Stack <Character> stk, String sout)
    {
        //System.out.println("当前进度"+n+"    "+"当前已出"+sout);

        if(n == in.length && stk.isEmpty()){//如果入栈完毕了，且也栈空了，就输出此出栈顺序          这个是递归的结束条件
            set.add(sout);
        }
        else//以上其中一项未完成
        {
            Stack<Character> s1=(Stack<Character>) stk.clone();
            Stack<Character> s2=(Stack<Character>) stk.clone();
            //选择入栈
            if (n <  in.length)//如果是未全部入栈
            {
                s1.push(in[n]);//      继续入栈
                fun(in,set,n+1, s1, sout+"");//执行下一个操作
            }
            //选择出栈
            if (!s2.isEmpty())//如果栈不空，并且，入栈元素不是最后一个
            {                                   //当到最后一个字符入栈之后，上面已经执行先出栈了
                String temp=sout+ s2.peek();//记录出栈元素
                s2.pop();//出栈
                fun(in,set,n, s2, temp);
            }
        }
    }

}
