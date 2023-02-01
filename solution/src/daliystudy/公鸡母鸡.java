package daliystudy;

public class 公鸡母鸡 {
    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 300;
        Integer c = new Integer(300);
        Integer d = new Integer(300);

        System.out.println(a == b);
        System.out.println(a == 100);
        System.out.println(b == 300);
        System.out.println(c == 300);
        System.out.println(d == 300);
        System.out.println(d == b);
        System.out.println(c == b);
    }

}
