package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class Offer_12矩阵中的路径 {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'a','b'},{'c','d'}}, "cdba"));
    }
    public static boolean exist(char[][] board, String word) {

        for (int i = 0 ; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
               if (find(board, word, i, j,0))return true;
            }
        }
        return false;
    }

    private static boolean find(char[][] board, String word, int i, int j,int cur) {
        if (i < 0 || j < 0 || j >= board[0].length ||  i >= board.length || word.charAt(cur) != board[i][j])return false;
        if (cur == word.length() - 1)return true;
        board[i][j]='\0';
        boolean res = find(board,word,i - 1,j,cur + 1)|| find(board,word,i,j-1,cur+1)||find(board,word,i + 1,j,cur+1)||find(board, word, i, j + 1, cur+1);
        board[i][j]=word.charAt(cur);
        return res;
    }

}
