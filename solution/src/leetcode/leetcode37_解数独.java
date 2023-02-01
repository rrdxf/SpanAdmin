package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode37_解数独 {
    List<int []> list=new ArrayList<>();
    boolean [][]row=new boolean [9][9];
    boolean [][]column=new boolean[9][9];
    boolean [][][]box=new boolean[3][3][9];
    boolean success=false;
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0;j < 9;j++){
                if (board[i][j]=='.'){
                    list.add(new int[]{i,j});//存储列
                }else {
                    int num=board[i][j]-'0'-1;
                    row[i][num]=true;
                    column[j][num]=true;
                    box[i/3][j/3][num]=true;
                }

            }

        }
        dfs(board,0);
    }
    void dfs(char[][] board,int num){
        if (num==list.size()){
            success=true;
            return;
        }
        int i=list.get(num)[0];
        int j=list.get(num)[1];
        for (int x = 0;x < 9 && !success;x++){
            if (!row[i][x] && !column[j][x] && !box[i/3][j/3][x]){
                row[i][x]=true;
                column[j][x]=true;
                box[i/3][j/3][x]=true;
                board[i][j]=(char) ('0'+x+1);
                dfs(board,num+1);
                row[i][x]=false;
                column[j][x]=false;
                box[i/3][j/3][x]=false;
            }
        }
    }
}
