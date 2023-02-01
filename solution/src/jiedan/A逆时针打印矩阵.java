package jiedan;

import java.util.ArrayList;
import java.util.Scanner;

public class A逆时针打印矩阵 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        System.out.printf("请输入行列数：");
        int n = scanner.nextInt();
        //int arr[][]= {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr =new int[n][n];
        for (int i = 0 ; i < n ;i++){
            for (int j = 0; j < n ;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        ArrayList<Integer> a=printMatrix( arr);
        for (int i =0;i<a.size();i++) {
            System.out.print(a.get(i)+" ");
        }
    }

    public static ArrayList<Integer> printMatrix(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int n = array.length,m = array[0].length;
        if(m==0) return result;
        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
        for(int i=0;i<layers;i++){
            for(int k = m-i-1;k>=i;k--) result.add(array[i][k]);//右上到左上
            for(int j=i+1;j<n-i;j++) result.add(array[j][i]);//左上到左下
            for(int k = i+1;k<m-i;k++) result.add(array[n-i-1][k]);//左下到右下
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--)	result.add(array[j][m-i-1]);//右下至右上
        }
        return result;
    }
}
