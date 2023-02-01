package jiedan;

import java.util.*;

public class NN矩阵 {
    public static void main(String[] args) {
        mute();
    }
    static void juzhen(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [][]mute=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                mute[i][j]=scanner.nextInt();
            }
        }
        int max1=Integer.MIN_VALUE;//每列最大
        int max2=Integer.MIN_VALUE;//每行最大
        int min1=Integer.MAX_VALUE;//每列最小
        int min2=Integer.MAX_VALUE;//每行最小
        int [][]result=new int[4][n];
        //每行最大最小
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                max1=max1<mute[i][j]?mute[i][j]:max1;
                min1=min1>mute[i][j]?mute[i][j]:min1;
                max2=max2<mute[j][i]?mute[j][i]:max2;
                min2=min2>mute[j][i]?mute[j][i]:min2;
            }
            result[0][i]=max2;
            result[1][i]=min2;
            result[2][i]=max1;
            result[3][i]=min1;
            max1=Integer.MIN_VALUE;//每列最大
            max2=Integer.MIN_VALUE;//每行最大
            min1=Integer.MAX_VALUE;//每列最小
            min2=Integer.MAX_VALUE;//每行最小
        }
        for (int i=0;i<4;i++){
            for (int j=0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void gonggongzichaun(){
        Scanner scanner=new Scanner(System.in);

        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        //最长子串的起始位置
        int start = 0;
        //最长子串的长度
        int maxLen = 0;
        //多加一行一列作为辅助状态
        int[][] maxSubLen = new int[len1+1][len2+1];
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j < len2; j++) {
                //如果第i个字符和第j个字符相等，则进行累加
                if (arr1[i-1] == arr2[j-1]){
                    maxSubLen[i][j] = maxSubLen[i-1][j-1]+1;
                    if (maxLen < maxSubLen[i][j]){
                        maxLen = maxSubLen[i][j];
                        start = i - maxLen;
                    }
                }
            }
        }
        if (maxLen>0){
            System.out.println(str1.substring(start,start+maxLen));
        }else {
            System.out.println("false");
        }
    }
    static void order(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(m);
        for (int i=0;i<n;i++){
            int tem=scanner.nextInt();
            queue.add(tem);
        }
        Iterator<Integer> it=queue.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
    static void compare(){
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        if (s1.length()!=s2.length()){
            System.out.println(1);
            return;
        }
        if (s1.equals(s2)){
            System.out.println(2);
            return;
        }
        if (s1.toUpperCase().equals(s2.toUpperCase())){
            System.out.println(3);
            return;
        }
        System.out.println(4);
    }
    static void yuanying(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('o');
        set.add('i');
        set.add('u');
        set.add('e');
        set.add('A');
        set.add('O');
        set.add('I');
        set.add('U');
        set.add('E');
        String [] ss=new String[n];
        for (int i=0;i<n;i++){
            ss[i]=scanner.nextLine();
        }
        for (int i=0;i<n;i++){
            char []s=ss[i].toCharArray();
            for (int j=0;j<s.length;j++){
                if (set.contains(s[j])){
                    if (Character.isLowerCase(s[j])){
                        s[j]-=32;
                    }
                }else {
                    if (Character.isUpperCase(s[j])){
                        s[j]+=32;
                    }
                }
            }
            for (int j=0;j<s.length;j++){
                System.out.print(s[j]);
            }
            System.out.println();
        }

    }
    static void mute(){
        int[][] mu=new int[6][6];
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                mu[i][j]=scanner.nextInt();
            }
        }
        for (int i=0;i<6;i++){
            mu[i][i]+=10;
        }
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                System.out.print(mu[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void stack(){
        Scanner scanne=new Scanner(System.in);
        int n=scanne.nextInt();
        int [] a=new int[n];

        for (int i=0;i<n;i++){
            a[i]=scanne.nextInt();
        }
        Stack<Integer>stack=new Stack<>();
        for (int i=n;i>0;i--){
            stack.add(i);
        }
        Set<List<Integer>> set=new HashSet<>();

    }
}
