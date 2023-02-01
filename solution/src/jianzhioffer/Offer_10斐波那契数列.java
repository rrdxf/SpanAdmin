package jianzhioffer;

public class Offer_10斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }
    public static int fib(int n) {
        if (n < 2){
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = 1;
        for(int i = 3;i <= n; i++){
            a = b;
            b = sum;
            sum = ( a + b )%1000000007;
        }
        return sum;
    }
}
