package daliystudy;

public class Shoppe1 {
    public static void main(String[] args) {
        System.out.println(Convert(new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4} ));
    }
    public static long Convert(int[] nums) {
        // write code here
        if (nums == null){
            return -1;
        }
        long []numss = new long[nums.length];
        for (int i = 0; i < nums.length; i++){
            numss[i]=nums[i];
        }
        long res = 0;
        int flag = nums.length-1;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < flag; j++){
                numss[i]*=5;
            }
            flag--;
            res+=numss[i];
        }
        return res;
    }
}
