package jiedan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FIFO {
    public static void main(String[] args) {
        //定义队列
        Queue<String> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();//吃回车
        String in = scanner.nextLine();
        String [] ss = in.split(",");//通过“,”分割字符串
        int count = 0;//定义缺页次数初始值为0
        for (int i = 0 ; i < ss.length ; i++){//开始循环
            if (queue.size() == 0){//如果队列为0,直接给队列加入元素，缺页次数加1
                queue.add(ss[i]);
                count++;
            }
            //循环查询队列中的元素，是否需要页面置换
            boolean find = false;//记录是否查询到结果
            for (String e : queue){
                if (e.equals(ss[i])){//如果查询到，定义find为true，表明已经查询到
                    find = true;
                    break;
                }
            }
            if (!find){//如果没找着，造成缺页，缺页次数加一
                count++;
                queue.add(ss[i]);
                if (queue.size() > n)queue.poll();//如果超过定义页面最大数，剔除末尾元素
            }
        }
        System.out.println(count);//输出缺页次数
    }
}
/*
在真正写代码的时候，我才意识到自己先进先出页面置换算法的核心思路并不是特别清晰，
通过此次实验，我真正的学习到了页面置换算法的核心思路，让我受益匪浅。
 */