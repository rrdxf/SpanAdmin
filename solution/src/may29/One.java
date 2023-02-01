package may29;

import java.io.*;

public class One {
    public static void main(String[] args) throws IOException {
        //写
        File file = new File("one.txt");
        FileOutputStream fos = new FileOutputStream(file.getName());
        PrintWriter printWriter = new PrintWriter(fos);
        printWriter.println("A001\t25\t100");
        printWriter.println("A002\t33\t130");
        printWriter.println("A003\t78\t35");
        printWriter.println("A004\t12.5\t200");
        printWriter.flush();
        printWriter.close();


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String lineTxt = null;
        // 逐行读取
        while ((lineTxt = br.readLine()) != null) {
            // 输出内容到控制台
            String [] ss = lineTxt.split("\t");
            System.out.println(ss[0]+"销售额为："+(Double.valueOf(ss[1])*Double.valueOf(ss[2])));
        }
        br.close();


    }
}
