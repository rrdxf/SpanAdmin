package leetcode;

import java.util.*;

public class leetcode40_组合总和2 {
    public static void main(String[] args) {
        Long d1=(new Date()).getTime();
        List<List<Integer>> re=combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        30);
        Long d2=(new Date()).getTime();
        for (List<Integer> list: re){
            for (Integer a:list){
                System.out.printf(a+" ");
            }
            System.out.println();
        }
        System.out.println("时间为："+(d2-d1)+"ms");
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> re=new ArrayList<>();
        for (int i = 0; i < candidates.length&&candidates[i]<=target; i++) {
            if (i>0&&candidates[i]==candidates[i-1])continue;//大剪枝
            Stack<Integer> res=new Stack<>();
            res.add(i);
            process(re,i,target-candidates[i],candidates,res);
        }
        return re;
    }
    static void  process(List<List<Integer>> re,int i,int target, int[] caniddates, Stack<Integer> res){
        if (target==0){
            List<Integer> list=new ArrayList<>();
            for (Integer a:res){
                list.add(caniddates[a]);
            }
            re.add(list);
        }
        if (target > 0){
            for (int j=res.peek()+1;j<caniddates.length&&caniddates[j]<=target;j++){
                if (res.peek()+1<j&&caniddates[j]==caniddates[j-1])continue;//大剪枝
                res.add(j);
                process(re,j,target-caniddates[j],caniddates,res);
                res.pop();
            }
        }
        if (target<0){
            return;
        }
    }
}
