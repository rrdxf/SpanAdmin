package june_22;

public class MainClass {
    int [][] a = {{5,2,2,124,192},
            {9,245,212,110,350},
            {10,156,5,6,7,110},
            {141,73,6,6,135}}   ;
    static void bubbleSort(int [] a){
        for(int i = 0 ; i < a.length ; i++){
            for(int j =  i ; j < a.length ; j++){
                if(a[i] > a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int [][] a = {{5,2,2,124,192},
                {9,245,212,110,350},
                {10,156,5,6,7,110},
                {141,73,6,6,135}}   ;

        for (int i = 1 ; i < a.length-1 ; i++){
            for (int j = 1 ; j < a[0].length-1 ; j++){
                int[] s  = new int[9];
                s[0] = a[i][j];
                s[1] = a[i-1][j];
                s[2] = a[i-1][j-1];
                s[3] = a[i][j-1];
                s[4] = a[i+1][j];
                s[5] = a[i][j+1];
                s[6] = a[i+1][j+1];
                s[7] = a[i-1][j+1];
                s[8] = a[i+1][j-1];
                bubbleSort(s);
                a[i][j] = s[4];
            }
        }
        for(int i = 0 ; i < a.length ; i++){
            for(int j =  0 ; j < a[0].length ; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
