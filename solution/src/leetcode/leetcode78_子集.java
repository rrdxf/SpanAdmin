package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode78_子集 {
    public static void main(String[] args) {
        List<List<Integer>> list=subsets(new int[]{1,2,3});
        for (List<Integer> list1:list){
            for (Integer e:list1){
                System.out.printf(e+" ");
            }
            System.out.println();
        }

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> re=new ArrayList<>();
        getProcess(nums,list,0,re);
        re.add(nums[0]);
        return list;
    }

    private static void getProcess(int [] nums,List<List<Integer>> list, int i,List<Integer>re ) {
        if (i==nums.length){
            List<Integer>list1=new ArrayList<>();
            list.add(re);
            return;
        }
        getProcess(nums,list,i+1,re);
        re.add(nums[i]);
        getProcess(nums,list,i+1,re);
        re.remove(i-1);
    }
}
