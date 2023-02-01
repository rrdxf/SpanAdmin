package leetcode;

public class leetcode53_最大子数组和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4},1));
    }
    public static int maxSubArray(int[] nums,int num) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (dp[i-1]+nums[i] > nums[i]){
                dp[i]=dp[i-1]+nums[i];
            } else {//加起来的值小于
                dp[i]=nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int e:dp){
            max=e>max?e:max;
        }
        return max;
    }
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
