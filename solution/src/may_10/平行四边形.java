package may_10;

import java.util.*;

public class 平行四边形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        List<Integer []> list = new ArrayList<>();
        try{
            String [] strings = in.split(":");
            if (strings[0].equals("1")){
                String [] strings1 = strings[1].split(" ");
                if (strings1.length != 4){//如果数量不对
                    System.out.println("wrong number of points");
                    return;
                }
                for (String s : strings1){
                    String [] s1 = s.split(",");
                    list.add(new Integer[]{Integer.valueOf(s1[0]),Integer.valueOf(s1[1])});
                }
                isOne(list);
            } else if (strings[0].equals("2")){
                String [] strings1 = strings[1].split(" ");
                if (strings1.length != 4){//如果数量不对
                    System.out.println("wrong number of points");
                    return;
                }
                for (String s : strings1){
                    String [] s1 = s.split(",");
                    list.add(new Integer[]{Integer.valueOf(s1[0]),Integer.valueOf(s1[1])});
                }
                isTwo(list);
            } else if (strings[0].equals("3")){

            } else if (strings[0].equals("4")){

            } else {
                System.out.println("Wrong Format");
            }
        }catch (Exception e){
            System.out.println("Wrong Format");
            e.printStackTrace();
        }
    }
    static void isOne(List<Integer []> list){
        double k1 = Double.MAX_VALUE,k2 = Double.MAX_VALUE,k3 = Double.MAX_VALUE,k4 = Double.MAX_VALUE;
        if (list.get(1)[0] != list.get(0)[0]){
            k1 = (list.get(1)[1] - list.get(0)[1])/(list.get(1)[0] - list.get(0)[0]);
        }
        if (list.get(2)[0] != list.get(1)[0]){
            k2 = (list.get(2)[1] - list.get(1)[1])/(list.get(2)[0] - list.get(1)[0]);
        }
        if (list.get(3)[0] != list.get(2)[0]){
            k3 = (list.get(3)[1] - list.get(2)[1])/(list.get(3)[0] - list.get(2)[0]);
        }
        if (list.get(3)[0] != list.get(0)[0]){
            k4 = (list.get(3)[1] - list.get(0)[1])/(list.get(3)[0] - list.get(0)[0]);
        }


        if (k1 != k2 && k2 != k3 && k3 != k4 && k4 != k1){
            System.out.print(true);
            if (k1 == k3 && k2 == k4){
                System.out.printf(" " + true);
            } else {
                System.out.printf(" " + false);
            }
        } else {
            System.out.printf(false + " " + false);
        }
    }
    static void isTwo(List<Integer []> list){
        double k1 = Double.MAX_VALUE,k2 = Double.MAX_VALUE,k3 = Double.MAX_VALUE,k4 = Double.MAX_VALUE;
        if (list.get(1)[0] != list.get(0)[0]){
            k1 = (list.get(1)[1] - list.get(0)[1])/(list.get(1)[0] - list.get(0)[0]);
        }
        if (list.get(2)[0] != list.get(1)[0]){
            k2 = (list.get(2)[1] - list.get(1)[1])/(list.get(2)[0] - list.get(1)[0]);
        }
        if (list.get(3)[0] != list.get(2)[0]){
            k3 = (list.get(3)[1] - list.get(2)[1])/(list.get(3)[0] - list.get(2)[0]);
        }
        if (list.get(3)[0] != list.get(0)[0]){
            k4 = (list.get(3)[1] - list.get(0)[1])/(list.get(3)[0] - list.get(0)[0]);
        }


        if (k1 != k2 && k2 != k3 && k3 != k4 && k4 != k1){
            //判断菱形
            boolean a = false;
            double k5 = Double.MAX_VALUE;
            double k6 = Double.MAX_VALUE;
            if (list.get(0)[0] != list.get(2)[0]){
                k5 = (list.get(2)[1] - list.get(0)[1])/(list.get(2)[0] - list.get(0)[0]);
            }
            if (list.get(1)[0] != list.get(3)[0]){
                k6 = (list.get(1)[1] - list.get(3)[1])/(list.get(1)[0] - list.get(3)[0]);
            }
            if (k5 != Double.MAX_VALUE && k6 != Double.MAX_VALUE ){
                if (k5 * k6 == -1) {
                    a = true;
                    System.out.printf("true");
                }
                else System.out.printf("false");
            }else {
                if ((k5 == Double.MAX_VALUE && k6 == 0)
                        ||
                        (k6 == Double.MAX_VALUE && k5 == 0)){
                    System.out.printf("true");
                    a = true;
                }
                else System.out.printf("false");
            }
            //判断矩形
            boolean b = false;
            double s1 = (list.get(0)[1] - list.get(2)[1]) * (list.get(0)[1] - list.get(2)[1])
                    + (list.get(0)[0] - list.get(2)[0]) * (list.get(0)[0] - list.get(2)[0]);
            double s2 = (list.get(1)[1] - list.get(3)[1]) * (list.get(1)[1] - list.get(3)[1])
                    + (list.get(1)[0] - list.get(3)[0]) * (list.get(1)[0] - list.get(3)[0]);
            if (s1 == s2){
                b = true;
                System.out.printf(" true");
            } else System.out.printf(" false");
            //判断正方形
            System.out.println(a && b);

        } else {
            System.out.printf("not a quadrilateral");
        }
    }
}
