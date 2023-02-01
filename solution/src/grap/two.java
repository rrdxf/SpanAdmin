package grap;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        List<String> ChanelArray=new ArrayList<>();
        ChanelArray.add("CCTV-1");
        ChanelArray.add("CCTV-2");
        ChanelArray.add("CCTV-3");
        ChanelArray.add("CCTV-4");
        ChanelArray.add("ZJTV");
        ChanelArray.add("HZTV");
        ChanelArray.add("JSTV");
        ChanelArray.add("SDTV");
        ChanelArray.add("FJTV");
        ChanelArray.add("SHTV");
        int channl=0;
        List<String> ch=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        int i=0;
        while (true){
            String c=scanner.nextLine();
            if ("O".equals(c)){
                break;
            }else {
                ch.add(c);
            }
        }
        int j=0;
        for (String s: ch){
            char c=s.charAt(0);
            if (c>='0'&&c<='9'){
                j=c-'0';

            }else if (c=='U'){
                j++;
            }else if (c=='D'){
                j--;
            }
            if (j>9)j=0;
            if (j<0)j=9;
            System.out.println(ChanelArray.get(j));
        }
        System.out.println("TV OFF");
    }
}
