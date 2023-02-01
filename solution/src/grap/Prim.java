package grap;

import com.sun.crypto.provider.DHKeyAgreement;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Prim {
    static Map<Integer,String>map;
    private static int[][][] grap=null;//邻接矩阵存图
    private int size=0;
    public static void main(String[] args) {
        initGrap();
        System.out.println("距离为："+findMinPathDAG(grap[0], 11));

    }
    //DAG算法，适用于有向无环图

    /**
     *
     * @param grap  通过邻接矩阵传递图
     * @param pointNum 图的节点数
     * @return 得到最短路线
     * 时间复杂度 o(n*n)
     * 空间复杂度 o(n)
     */
    static int findMinPathDAG(int [][] grap,int pointNum){
        //A->E的最短路径
        //int [] dp=new int[pointNum];//记录从a点到图中任意一点的最短距离
        //改进，可以记录经过路径

        Path [] dp=new Path[pointNum];
        dp[0]=new Path();
        dp[0].value=0;//初始化数组，A->A的距离为0
        dp[0].key="A";
        for (int i=1;i<pointNum;i++){
            dp[i]=new Path(0,"");
        }

        int point=-1;//记录节点代号
        int value=Integer.MAX_VALUE;//记录当前边权值
        for (int i = 1;i < pointNum; i++){
            for (int j = 0; j < pointNum; j++){
                if (i==j)continue;
                if (grap[j][i]!=-1){
                    if (value>grap[j][i]){
                        point=j;
                        value=grap[j][i];
                    }
                }
            }
            if (point!=-1){
                dp[i].value=dp[point].value+value;
                dp[i].key=dp[point].key+"-->"+map.get(i);
            }else {
                dp[i].value=-1;
            }
            point=-1;//记录节点代号
            value=Integer.MAX_VALUE;//记录当前边权值
        }
        System.out.println("最短路径为："+dp[pointNum-1].key);
        return dp[pointNum-1].value;

    }
    static class Path{//记录结果的类
        int value;
        String key="";
        public Path() {
        }
        public Path(int value, String key) {
            this.value = value;
            this.key = key;
        }
    }
    static void initGrap(){
        if (grap==null){
            grap=new int[][][]{
                    {
                              /*a b1 b2 b3 c1 c2 c3 d1 d2 d3 e*/
                        /* a*/{ 0, 4, 5, 3,-1,-1,-1,-1,-1,-1,-1},
                        /*b1*/{-1, 0,-1,-1, 6, 4,-1,-1,-1,-1,-1},
                        /*b2*/{-1,-1, 0,-1, 3,-1, 1,-1,-1,-1,-1},
                        /*b3*/{-1,-1,-1, 0,-1, 8, 4,-1,-1,-1,-1},
                        /*c1*/{-1,-1,-1,-1, 0,-1,-1, 4, 2,-1,-1},
                        /*c2*/{-1,-1,-1,-1,-1, 0,-1,-1, 5, 7,-1},
                        /*c3*/{-1,-1,-1,-1,-1,-1, 0,-1,10, 9,-1},
                        /*d1*/{-1,-1,-1,-1,-1,-1,-1, 0,-1,-1, 7},
                        /*d2*/{-1,-1,-1,-1,-1,-1,-1,-1, 0,-1, 8},
                        /*d3*/{-1,-1,-1,-1,-1,-1,-1,-1,-1, 0, 6},
                        /*e */{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0},
                    }
            };//
        }
        map=new HashMap<>();
        map.put(0,"A");
        map.put(1,"B1");
        map.put(2,"B2");
        map.put(3,"B3");
        map.put(4,"C1");
        map.put(5,"C2");
        map.put(6,"C3");
        map.put(7,"D1");
        map.put(8,"D2");
        map.put(9,"D3");
        map.put(10,"E");
    }
}
