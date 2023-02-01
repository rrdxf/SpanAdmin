package leetcode;

public class leetcode75_颜色分类 {//荷兰国旗问题？

    public static void main(String[] args) {
        sortColors(new int[]{2,1,1,2,0,0});
    }
    public static void sortColors(int[] nums) {
        int left=-1;
        int right= nums.length;
        int cur=0;
        while (cur<right){
            if (nums[cur]<1){
                swap(nums,cur++,left+1);
                left++;
            }else if (nums[cur]>1){
                swap(nums,cur,right-1);
                right--;
            }else {
                cur++;
            }
        }
    }
    static void swap(int [] nums,int i ,int j){
        int tem=nums[i];
        nums[i]=nums[j];
        nums[j]=tem;
    }
}
