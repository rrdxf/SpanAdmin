package jianzhioffer;

public class Offer_13机器人的运动范围 {
    public static void main(String[] args) {
        System.out.println(movingCount(1, 2, 1));
    }
    public static int movingCount(int m, int n, int k) {
        boolean [][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }

    private static int dfs(int i, int j, int m, int n, int k,boolean [][] visited) {
        int res = sum(i) + sum(j);
        if ( res > k || i < 0 || i >= m || j < 0 || j >= n || visited[i][j])return 0;
        visited[i][j] = true;
        return 1 + dfs(i,j+1,m,n,k,visited)+dfs(i + 1,j,m,n,k,visited);
    }
    static int sum(int n){
        int num1 = 0;
        while (n != 0){
            num1 += n%10;
            n = n/10;
        }
        return num1;
    }
}
