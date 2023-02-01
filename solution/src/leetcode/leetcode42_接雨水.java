package leetcode;

public class leetcode42_接雨水 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5},1));
    }
    public static int trap(int[] height) {//时间复杂度o(n),空间复杂度o(n)
        int len= height.length;
        if (len<3){
            return 0;
        }
        int [] leftmax = new int[len];
        int [] rightmax = new int[len];
        for (int i = 1; i < len-1; i++){
            leftmax[i] = Math.max(leftmax[i - 1],height[i - 1]);
        }
        for (int i = len-2; i >= 0; i--){
            rightmax[i] = Math.max(rightmax[i + 1],height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < len - 1; i++){
            int min = Math.min(rightmax[i],leftmax[i]);
            if (height[i] < min){
                sum+=min-height[i];
            }
        }
        return sum;
    }
    public static int trap(int[] height,int num) {
        int len= height.length;
        if (len<3){
            return 0;
        }
        int maxleft = 0;
        int maxright = 0;
        int left = 1;
        int right = len - 2;
/*
时间复杂度：o（n），空间复杂度：o(1)，牛逼哦
 */
        int sum = 0;
        for (int i = 1; i < len - 1; i++){
            if (height[left - 1] < height[right + 1]) {
                int min = Math.max(height[left - 1],maxleft);
                maxleft = min;
                if (height[left] < min){
                    sum+=min-height[left];
                }
                left++;
            } else {
                int min = Math.max((height[right + 1]),maxright);
                maxright = min;
                if (height[right] < min){
                    sum+=min-height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
