package jianzhioffer;

public class 剑指offerII_二进制加法 {
    public static void main(String[] args) {
        //System.out.println(addBinary("1","11"));
        a:
        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 6 ; ++j){
                System.out.println(j);
                break a;
            }
            System.out.println(i);
        }
        System.out.println("===========");
    }
    public static String addBinary(String a, String b) {
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        int up = 0;
        StringBuilder res = new StringBuilder();
        while (alen >= 0 || blen >= 0 || up > 0){
            int aa = alen <= -1? 0 : a.charAt(alen) - '0';
            int bb = blen <= -1? 0 : b.charAt(blen) - '0';
            int num = aa + bb + up;
            res.insert(0,num % 2 );
            up = num / 2;
            alen--;blen--;
        }
        return res.toString();
    }
}
