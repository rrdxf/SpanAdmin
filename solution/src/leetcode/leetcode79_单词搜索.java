package leetcode;

public class leetcode79_单词搜索 {
    public static void main(String[] args) {

    }
    public static boolean exist(char[][] board, String word) {
        int len = word.length();
        boolean [][] juge=new boolean[board.length][board[0].length];
        for (int i = 0;i< board.length;){
            for (int j=0;j<board[0].length;){
                if (word.charAt(0)==board[i][j]){
                   // if (find(i,j,board,word,juge))
                    return true;
                } else {

                }
            }
        }
        return false;
    }


    private static boolean inArea(char[][] board, int[] ints,int i ,int j) {
        return i+ints[0]>=0&&i+ints[0]<=board.length-1&&j+ints[1]>=0&&j+ints[1]<=board[0].length;
    }
}
