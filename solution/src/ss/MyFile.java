package ss;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
循环从键盘输入若干个正整数（当输入-1时，结束循环），程序输出这些数的总个数、最大值、最小值和平均值。
 */
public class MyFile {
    public static void main(String[] args){
        f1();
    }

    static void f1(){
        // 初始化文件
        File file = new File("C:\\Users\\XF\\Desktop\\新建文本文档 (2).txt");
        // 获取文件输入流
        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream(file);
            // 转化为字符输入流
            InputStreamReader inReader = new InputStreamReader(fileStream,"UTF-8");
            // 初始化缓冲读入器
            BufferedReader bfReader = new BufferedReader(inReader);



            String content = "";
            // 先读取一行
            content = bfReader.readLine();
            // 根据空格分割为String数组
            String [] numbers = content.split(" ");
            // 得到接下来的行数
            int linenumber = Integer.valueOf(numbers[0]);
            // 得到每行数字的个数
            int numberCount = Integer.valueOf(numbers[1]);



            // 初始化结果
            int sum = 0;
            // 循环读取每一行
            for (int i = 0; i < linenumber && content != null; ++i) {
                content = bfReader.readLine();  // 读取一行
                numbers = content.split(" "); // 根据空格分割
                for (int j = 0; j < numberCount; ++j) { // 将上面分割的数字加起来
                    sum += Integer.valueOf(numbers[j]);
                }
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void f2(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int num = scanner.nextInt();
        double count = 0;
        int sum = 0;
        while (num != -1) {
            ++count;
            sum += num;
            list.add(num);
            num = scanner.nextInt();
        }
        Collections.sort(list); // 排序
        System.out.println("最小值：" + list.get(0));
        System.out.println("最大值：" + list.get(list.size() - 1));
        System.out.println("和：" + sum);
        System.out.println("平均数：" + sum / count);
    }
}
