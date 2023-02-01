package 动态规划;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class donggui {
    public static void main(String[] args) {
        System.out.println(mincost(new int[]{10, 15, 20}));
    }

    /**
     * licode 509 斐波那契数列
     *斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0)return 0;
        if (n == 1) return 1;
//        return fib(n - 1) + fib(n - 2);
        // 动态规划
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2 ; i <= n ; i++){
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
        int dp1 = 0;
        int dp2 = 1;
        int dp3 = 1;
        for (int i = 0 ; i < n - 1 ; i++){
            dp3 = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp3;
        }
        return dp3;
    }
    /**
     * 749 使用最小花费爬楼梯
     *
     */
    public static int mincost(int[] cost){
        if (cost.length <= 1)return 0;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1  ; i++){
            dp[2] = Math.min(cost[i - 1] + dp[i - 1] , cost[i - 2] + dp[i - 2]);
        }
        Arrays.sort(cost);
        a:
        break a;

        return dp[cost.length - 1];
    }
}
