package daliystudy;

public class 马鞍点的查找 {
        public static void main (String args[]) {
            int a[][]={{-2,-1,-3,-4},{9,8,7,6},{4,5,6,3}};
            int i,j,temp;
            int maxa[][]=new int [3][4];
            int mina [][]=new int [3][4];
//求出行中最小值并标记
            for(i=0;i<a.length;i++) {
                temp=a[i][0];
                for(j=1;j<a[i].length;j++)
                    if (a[i][j]<temp)
                        temp=a[i][j];
                for (j=1;j<a[i].length;j++)
                    if(a[i][j]==temp)
                        mina[i][j]=1;
            }

//求出列中最大值并标记
            for(j=0;j<a[0].length;j++) {
                    temp=a[0][j];
                for(i=1;i<a.length;i++)
                    if (a[i][j]>temp)
                        temp=a[i][j];
                for (i=1;i<a.length;i++)
                    if(a[i][j]==temp)
                        maxa[i][j]=1;
            }
//打印输出矩阵
            for(i=0;i<a.length;i++) {
                for(j=0;j<a[i].length;j++)
                    System.out.print(" "+a[i][j]+" ");
                System.out.println();
            }

//求马鞍点并打印输出
            for(i=0;i<a.length;i++) {
                for(j=0;j<a[i].length;j++)
                    if(mina[i][j]+maxa[i][j]==2)
                        System.out.println(" "+i+"行"+j+" 列是一个马鞍点值 :"+a[i][j]);
            }
        }
}
