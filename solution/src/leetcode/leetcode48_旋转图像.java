package leetcode;

public class leetcode48_旋转图像 {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{{2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21}, {32, 33, 32, 2, 28, 14}
                , {13, 14, 32, 27, 22, 26}, {33, 1, 20, 7, 21, 7}, {4, 24, 1, 6, 32, 34}};
        for (int [] nu:matrix){
            for (int e: nu){
                System.out.printf(e+" ");
            }
            System.out.println();
        }
        System.out.println();
        rotate(matrix);
        for (int [] nu:matrix){
            for (int e: nu){
                System.out.printf(e+" ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        if (matrix.length == 1){
            return;
        }
        for (int i=0;i<matrix.length/2;i++){
            for (int j=0;j<matrix.length;j++){
                int tem=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j]=tem;
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=i;j<matrix.length;j++){
                int tem=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tem;
            }
        }

    }
    private static void process(int num,int[][] matrix, int length) {
        if ( length-num-num <2 ){
            return;
        }
        int start=num;
        int end=length-num;
        for (int i = start; i < end-1; i++){
            int flag=matrix[start][i];
            matrix[start][i]=matrix[end-i][start];

            int flag1=matrix[start+i][end-1];
            matrix[start+i][end-1]=flag;

            flag=matrix[end-1][end-1-i];
            matrix[end-1][end-1-i]=flag1;

            matrix[end-1-i][start]=flag;
        }
        process(++num,matrix, matrix.length);
    }
    /*
    00-> 0num.len-1 -> num.len-1,num.len-1 ->
     */
}
