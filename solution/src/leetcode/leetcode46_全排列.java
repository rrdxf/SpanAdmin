package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode46_全排列 {
    public static void main(String[] args) {
        List<List<Integer>> list=permute(new int[] {1});
        for(List<Integer> list1: list){
            for (Integer e: list1){
                System.out.printf(e + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean [] juge = new boolean[len];
        dfs(juge,len,nums,stack,res);
        return res;
    }

    private static void dfs(boolean [] juge,
                     int num,int[] nums,
                     Stack<Integer> stack,
                     List<List<Integer>> res) {
        if (num == 0){
            List<Integer> list = new ArrayList<>();
            for (Integer e: stack) {
                list.add(e);
            }
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++){
            if (!juge[i]) {
                stack.add(nums[i]);
                juge[i]=true;
                dfs(juge, num - 1, nums, stack, res);
                stack.pop();
                juge[i]=false;
            }
        }
    }
}
