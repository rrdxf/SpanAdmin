package cacu;

import java.util.Scanner;

public class Cacu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char opt;
        double one;
        double two;
        one = scanner.nextDouble();
        opt = scanner.next().charAt(0);
        two = scanner.nextDouble();
        switch (opt){
            case '*':{System.out.println(one * two);break;}
            case '-':{System.out.println(one - two);break;}
            case '+':{System.out.println(one + two);break;}
            case '/':{System.out.println(one / two);break;}
        }
    }
}
