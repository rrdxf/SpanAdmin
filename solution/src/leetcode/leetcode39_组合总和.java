package leetcode;

import java.util.*;

public class leetcode39_组合总和 {
    public static void main(String[] args) {
        List<List<Integer>> res= combinationSum(new int []{2,3,6,7},7);
        for(List<Integer> list: res){
            for (Integer a: list){
                System.out.printf(a+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0;i < candidates.length&&target>=candidates[i];i++){
            Stack<Integer> res=new Stack<>();
            res.add(i);
            proccess(res,candidates,target-candidates[i],list);
        }
        return list;
    }
    static void proccess(Stack<Integer> j, int[] candidates, int target, List<List<Integer>> res){
       if (target == 0){
           List<Integer> list=new ArrayList<>();
           for (Integer i:j){
               list.add(candidates[i]);
           }
           res.add(list);
       }
       if (target<0)return;
       if (target>0){
           for (int i=j.peek();i<candidates.length&&target>=candidates[i];i++){
               j.add(i);
               proccess(j,candidates,target-candidates[i],res);
               j.pop();
           }
       }
    }
}
