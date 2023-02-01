package leetcode;

public class leetcode55_跳跃游戏 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,5,0,0},1));
    }
    public static boolean canJump(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1;j < nums.length && j <= nums[i]+i; j++){
                dp[j]++;
            }
            if (i>=1&&dp[i-1] == 0)return false;
        }
        return dp[nums.length-1] >= 1?true:false;
    }
    public static boolean canJump(int[] nums,int num) {//贪心算法
        int mostright = 0;
        for (int i = 0; i < nums.length; i++){
            if (i <= mostright){
                mostright = Integer.max(nums[i]+i,mostright);
                if (mostright>= nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
