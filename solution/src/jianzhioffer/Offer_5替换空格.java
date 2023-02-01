package jianzhioffer;

public class Offer_5替换空格 {
    public static void main(String[] args) {

    }
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        return s.replace(" ","%20");
    }
}
