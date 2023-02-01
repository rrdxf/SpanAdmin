package jianzhioffer;

public class Offer_整数除法 {
    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE, -1));
    }
    public static int divide(int a, int b) {
        //if (a==Integer.MIN_VALUE&&b==-1)return Integer.MAX_VALUE;
        if (a == 0) return 0;
        long c=a;
        long d=b;
        if( a < 0 ){
            c=-c;
        }
        if ( b < 0 ){
            d=-d;
        }
        long count=0;
        for (int i = 31 ; i >= 0 ; i--){
            if (c-(d<<i)>=0){
                c=c-(d<<i);
                count+=1<<i;
            }
        }
        if (count>Integer.MAX_VALUE||count<Integer.MIN_VALUE){
            return 2147483647;
        }
        int res=(int)count;
        return (a>0)^(b>0)?-res:res;
    }
}
