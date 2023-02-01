package jianzhioffer;

public class Offer_4二维数组中的查找 {
    public static void main(String[] args) {

    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0 ; j < matrix[0].length; j++){
                if (target == matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
