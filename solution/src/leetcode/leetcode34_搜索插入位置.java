package leetcode;

public class leetcode34_搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,2,4,6,7}, 3));
    }
    public static int searchInsert(int[] nums, int target) {
        if (nums.length<2){
            if (target>nums[0]){
                return 1;
            }else {return 0;}
        }
        if (target<nums[0])return 0;
        if (target>nums[nums.length-1])return nums.length;
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        while (target>= nums[left]&&target<=nums[right]){
            mid=(left+right)/2;
            if (target>nums[mid]){
                left=mid+1;
            }else if (target<nums[mid]){
                right=mid-1;
            }else {
                return mid;
            }

        }
        if (target>nums[mid]){
            return mid+1;
        }
        return mid;
    }
}
