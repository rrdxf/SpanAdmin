package jianzhioffer;

public class Offer_11旋转数组中的最小数字 {
    public static void main(String[] args) {

    }
    public static int minArray(int[] numbers) {
        int res = Integer.MAX_VALUE;
        for (int i = 0 ; i < numbers.length; i++){
            if (res > numbers[i]){
                res = numbers[i];
            }
        }
        return res;
    }
}
