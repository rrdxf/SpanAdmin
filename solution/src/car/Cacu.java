package car;

import java.util.Scanner;

public class Cacu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opt;
        double a;
        double b;
        a = scanner.nextDouble();
        scanner.nextLine();
        opt = scanner.nextLine();
        b = scanner.nextDouble();
        scanner.nextLine();
        if (opt.charAt(0) == '*'){
            System.out.println(a*b);
        }else if (opt.charAt(0) == '/'){
            System.out.println(a/b);
        }else if (opt.charAt(0) == '+'){
            System.out.println(a+b);
        }else if (opt.charAt(0) == '-'){
            System.out.println(a-b);
        }

    }
}
