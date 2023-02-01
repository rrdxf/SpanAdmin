package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leetcode41_缺失的第一个正数 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
    }
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0;i < nums.length; i++){
            while (nums[i]>=1 && nums[i]<= nums.length && nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=i + 1){
                return i + 1;
            }
        }
        return nums.length+1;
    }
    static void swap(int []nums,int i,int j){
        int num=nums[i];
        nums[i]=nums[j];
        nums[j]=num;
    }
}
