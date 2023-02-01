package leetcode;

public class leetcode72_编辑距离 {
    public static void main(String[] args) {
        System.out.println(minDistance("", "a"));
    }
    public static int minDistance(String word1, String word2) {
        int len1= word1.length();
        int len2=word2.length();
        int [][] dp=new int [len1+1][len2+1];
        for (int i=0;i<=len1;i++){
            dp[i][0]=i;
        }
        for (int i=0;i<=len2;i++){
            dp[0][i]=i;
        }
        for (int i=1; i<=len1;i++){
            for (int j=1; j<=len2;j++){
                dp[i][j]=word1.charAt(i-1)==word2.charAt(j-1)?
                        dp[i-1][j-1]:(Integer.min(Integer.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1);
            }
        }
        return dp[len1][len2];


    }
}
