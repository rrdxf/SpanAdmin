package leetcode;

public class leetcode33_搜索旋转数组 {
    public static void main(String[] args) {
        System.out.println(search(new int[] {3,1},1,0));
    }
    public int search(int[] nums, int target) {//最基本做法
        if (nums==null||nums.length==0){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static int search(int[] nums, int target,int mu) {//不基本的做法
        if (nums==null||nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        while (left<right&&target!=nums[mid]){

            if (nums[mid]>nums[left]){//如果左半数组有序
                if (target>=nums[left]&&target<=nums[mid-1]){//并且target在左半区间中
                    right=mid-1;
                }else {//否则，在右半区间
                    left=mid+1;
                }
            } else {//如果右半数组有序
                if (target>=nums[mid+1]&&target<=nums[right]){//并且target在右半区间中
                    left=mid+1;
                }else {//否则，在右半区间
                    right=mid-1;
                }
            }
            mid=(left+right)/2;
        }
        //判断结果
        if (target==nums[mid]){//
            return mid;
        }
        return -1;
    }

}
