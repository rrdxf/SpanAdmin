package leetcode;

import java.util.HashMap;
import java.util.Map;
/*
....5..1.
.4.3.....
.....3..1
8......2.
..2.7....
.15......
.....2...
.2.9.....
..4......
 */
public class leetcode36_有效的数独 {
    public static void main(String[] args) {
        char [][] box=new char[][]{{'.','5','.'},{'3','.','.'},{'.','.','3'}};
        System.out.println(jugeBox(0,0,box));
       //System.out.println(map.get('1'));
    }
    static public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {//先判断每个小的
            Map<Character, Integer> map=getMap();
            Map<Character, Integer> map1=getMap();
            for (int j = 0;j < 9;j++){
                if (board[i][j]!='.'){
                    if (map.get(board[i][j])>=1){
                        return false;
                    }
                    map.put(board[i][j],1);
                }
                if (board[j][i]!='.'){
                    if (map1.get(board[j][i])>=1){
                        return false;
                    }
                    map1.put(board[j][i],1);
                }
            }
        }
        //判断每个box是否符合条件
        for (int i = 0;i < 9;i=i+3){
            for (int j = 0;j<9;j=j+3){
                if (!jugeBox(i, j,board)){
                    return false;
                }
            }
        }
        return true;

    }
    static boolean jugeBox(int i, int j,char[][] board){
        int x=i+3;
        int y=j+3;
        Map<Character, Integer> map=getMap();
        for (;i < x;i++){
            for (j=y-3;j < y;j++){
                if (board[i][j]!='.'){
                    if (map.get(board[i][j])==1){
                        return false;
                    }
                    map.put(board[i][j],1);
                }
            }
        }
        return true;
    }
   static Map<Character, Integer> getMap(){
        Map<Character,Integer> map=new HashMap<>();
        map.put('1',0);
        map.put('2',0);
        map.put('3',0);
        map.put('4',0);
        map.put('5',0);
        map.put('6',0);
        map.put('7',0);
        map.put('8',0);
        map.put('9',0);
        return map;
    }
}
