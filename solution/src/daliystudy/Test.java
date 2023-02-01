package daliystudy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;

public class Test extends Date {
    public int sub() {
        return 0;
    }
    public int sub1() {
        return 1;
    }
    Collection collection=new ArrayList();
    Collection collection1=new TreeSet();
    public static void main(String[] args) throws InterruptedException {
        String s;
        System.out.println(new Test().test(2));

    }
    public static int test(int i){
        int result=0;
        switch (i){
            case 1:result+=1;
            case 2:result=result+2*i;
            case 3:result=result+3*i;

        }
        return result;
    }
}
