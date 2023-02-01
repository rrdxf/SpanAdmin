package grap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {



//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        Scanner s = new Scanner(System.in);
//        String str = s.next();
//        int x = 1; // 1表示判断第一段 2 表示判断第二段
//        int sum = 0;
////		对输入的字母进行遍历
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (x == 1 || x == 3) {
////				说明要判断辅音
//                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
////					如果不是元音
//                    sum++;
//                } else {
////					如果是元音，则判断sum是否等于0 如果等于0 ，则返回false
//                    if (sum == 0) {
//                        System.out.println("no");
//                        return;
//                    } else {
//                        x++;
//                        i--;
//                        sum = 0;
//                    }
//                }
//            } else if (x == 2 || x == 4) {
////				说明要判断元音
//                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
////					如果是元音
//                    sum++;
//                } else {
////					如果不是元音，则判断sum是否等于0 如果等于0 ，则返回false
//                    if (sum == 0) {
//                        System.out.println("no");
//                        return;
//                    } else {
//                        x++;
//                    }
//                }
//            }
//        }
//        if (x != 4) {
//            System.out.println("no");
//        } else {
//            System.out.println("yes");
//        }
//    }
//    public static void main(String[] args) {
//        BigInteger a = BigInteger.ONE;// 1
//        BigInteger b = BigInteger.ONE;// 1
//        for (int i = 3; i < 500; i++) {
//            BigInteger t = b;
//            b = a.add(b);
//            a = t;
//        }
//        BigDecimal divide = new BigDecimal(a, 110).divide(new BigDecimal(b, 110), RoundingMode.HALF_DOWN);
//        System.out.printf("%.100f", divide);
//    }
public static void main(String[] args) {
    long m;
    long n;
    long s;
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    while (n-- > 0) {

        m = scanner.nextInt();
        s = 471 + 1000 * (m - 1);
        System.out.println(s);
    }
}
    // link是存取所有数的集合，order是标记下一个幸运数的位置，num就是那个幸运数，ass是一个“辅助数”
    private static void findlukcy(LinkedList<Integer> link, int order, int luckynum, int ass) {

        /*
         * ass：辅助作用，比如 1 3 5 7 9 11 13 15 17 19 21 23 .......
         * 题目说，3是第二个幸运数，那么i%3==0的话，那这个i的位置的数就被删除，那么所有数向前移动一位
         * 没有移动之前，i是：3，6，9，12.....的，正因为位置3的（link.remove(3)）被删了，所以，6，9，12...
         * 都变成了5，8，11；当这个时候的位置5被删了，8，11...变成7，10....位置7被删了，10变成9...
         * 在这里不难不发现，原本要被删除的是位置3，6，9，12，15....变成了3,5,7,9,11...
         * 幸运的时候，集合移动都是有规律的，这里的ass是luckynum-1。
         */

        int isfirst = 0;// 用于判断幸运数是否超出了m的范围，是0就超出了
        for (int i = 1; i < link.size(); i++) {
            if (i % luckynum == 0) {
                isfirst++;
                link.remove(i);
                luckynum += ass;
            }
        }

        if (order < link.size()) {
            luckynum = link.get(order);
            if (isfirst != 0)// 如果没有超出范围，那就继续找呀
                findlukcy(link, order + 1, luckynum, luckynum - 1);
                // 超出了，那么数一下有多少个
            else {
            }
        }
    }


    public static int primePalindrome(int k) {
        int count = 0;
        int num = 2;
        while (true) {
            if (isPrime(num))
                count++;
            if (count == k) return num;
            num++;
            if (10_000_000 < num && num < 100_000_000)
                num = 100_000_000;
        }
    }

    public static boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }

    // 素数
    static void f1() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int count = 0;
            int num = 2;
            int k = scanner.nextInt();
            while (true) {
                boolean juge = false;
                if (num < 2) juge = false;
                else {
                    int R = (int) Math.sqrt(num);
                    int d = 2;
                    int s = 0;
                    for (; d <= R; ++d)
                        if (num % d == 0) {
                            juge = false;
                            s = 1;
                            break;
                        }
                    if (s != 1)juge = true;
                }
                if (juge)
                    count++;
                if (count == k)  {
                    System.out.println(num);
                    break;
                }
                num++;
                if (10_000_000 < num && num < 100_000_000)
                    num = 100_000_000;
            }
        }
    }
    // 递增
    static void f2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if (i < 10) {
                count++;
                continue;
            }
            String num = String.valueOf(i);
            int juge = 1;
            for (int j = 1; j < num.length(); ++j) {
                if (num.charAt(j) < num.charAt(j - 1)) {
                    juge = 0;
                    break;
                }
            }
            count += juge;
        }
        System.out.println(count);
    }
    // 上楼梯
    static void f3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[5] = dp[7] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 8;
        for (int i = 6; i <= n; ++i) {
            if (i != 7)dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }
        System.out.println(dp[n]);
    }
    static void f4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        float[] arr = new float[100];//斐波那契数列
        for (int i = 0; i < arr.length; ++i)arr[i] = 1;
        arr[0] = 1;
        arr[1] = 2;
        float sum= 0.500000F;
        int t = 1;
        if (n == 1)
        {
            System.out.println("1.000000");
        }
        else if (n == 2)
        {
            System.out.println("0.500000");

        }
        else
        {
            for (int i = 0; i < n - 2; i++)
            {
                sum = sum + t * arr[i + 1] / (arr[i] + arr[i + 1]);

                arr[i + 2] = arr[i] + arr[i + 1];

                t = -1 * t;

            }
            System.out.println(sum);
        }
    }

    static void f5() {
        while (true){
            int sum = 1;
            Scanner scanner = new Scanner(System.in);
            int flag = 1;
            int n = scanner.nextInt();
            for (int i = 2; i <= n; ++i) {
                flag *= -1;
                double x = ((i - 1) / i);
                sum += flag * x;
            }
            System.out.println(sum);
        }

    }
}
