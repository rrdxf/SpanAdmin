package leetcode;

public class leetcode64_最小路径和 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
    public static int minPathSum(int[][] grid) {//动规
        int len= grid.length;
        int len1=grid[0].length;
        int[][] dp = new int[len][len1];

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len1; j++){
                if (i==0&&j==0){
                    dp[0][0]=grid[0][0];
                }else if (i==0&&j!=0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }else if (j==0&&i!=0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }else if (j!=0 && i!=0){
                    dp[i][j]=Integer.min(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j]);
                }
            }
        }
        return dp[len-1][len1-1];
    }
}
