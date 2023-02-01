package jianzhioffer;

public class Offer_4只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));
    }
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < 32 ; i++){
            int sum=0;
            for (int num:nums){
                sum+=(num>>i)&1;
            }
            if (sum%3!=0){
                result|=1<<i;
            }
        }
        return result;
    }
}
