package leetcode;

import java.util.*;

public class leetcode56__合并区间 {
    public static void main(String[] args) {
        int [][] result=merge(new int[][]{{1,4},{2,3}});
        for (int i = 0;i<result.length;i++){
            System.out.println(result[i][0]+" "+result[i][1]);
        }
    }
    public static int[][] merge(int[][] intervals) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0]-o2[0];
            }
        });
        //排序
        for (int i = 0; i < intervals.length; i++){
            Integer[] in = new Integer[2];
            in[0] = intervals[i][0];
            in[1] = intervals[i][1];
            queue.add(in);
        }
        List<Integer[]> list = new ArrayList<>();
        int i = 0;
        Integer [] in= queue.poll();
        intervals[0][0] = in[0];
        intervals[0][1] = in[1];
        while (!queue.isEmpty()){
            in=queue.poll();
            if (in[0]<=intervals[i][1]&&in[1]>intervals[i][1]){
                intervals[i][1]=in[1];
            } else if (in[0]>intervals[i][1]){
                i++;
                intervals[i][0]=in[0];
                intervals[i][1]=in[1];
            }
        }
        int [][] result=new int[i+1][2];
        for (int j=0;j<=i;j++){
            result[j][0]=intervals[j][0];
            result[j][1]=intervals[j][1];
        }
        return result;
    }
}
