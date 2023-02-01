package may29;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) throws Exception {
        File file = new File("two.txt");
        FileOutputStream fos = new FileOutputStream(file.getName());
        PrintWriter printWriter = new PrintWriter(fos);
        printWriter.println("A001\t2500\t1");
        printWriter.println("A001\t5000\t2");
        printWriter.println("A001\t3000\t3");
        printWriter.println("A002\t1200\t2");
        printWriter.println("A002\t5000\t3");
        printWriter.println("A003\t600\t1");
        printWriter.println("A003\t800\t3");
        printWriter.flush();
        printWriter.close();


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String lineTxt = null;
        System.out.println("请输入商品型号：");
        Scanner scanner  = new Scanner(System.in);
        String select = scanner.nextLine();
        List<String[]> list = new ArrayList<>();
        // 逐行读取
        while ((lineTxt = br.readLine()) != null) {
            // 输出内容到控制台
            String [] ss = lineTxt.split("\t");
            list.add(ss);
        }
        int res = 0;//要输出的结果，初始化为0
        for (String[] strings : list) {
            if (strings[0].equals(select)){
                res+=Integer.valueOf(strings[1]);
            }
        }
        System.out.println(select+"型号总销售额为："+res);
        br.close();

    }
}
