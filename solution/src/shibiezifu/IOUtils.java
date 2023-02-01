package shibiezifu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {
    public static final String FILE_PATH="student.txt";
    /**
     * 从文件提取数据，格式化到程序中
     * @throws IOException
     */

    public static List<String> GetStrFromFile(String path) throws IOException {
        final String DELIMITER = "\t";
        List<String>list=new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(path);
            if (file.exists()){
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

                String line = null;
                while (null != (line=br.readLine())) {
                    System.out.println(line);
                    String [] ss =line.split(" ");
                    for (String s:ss){
                        if (!s.equals(""))
                        list.add(s);
                    }
                }// while
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                br.close();
            }
        }
        return list;
    }
    /**
     * 将格式化的数据写入文件中
     * @throws IOException
     */
    public static void WriteDataToFile() throws IOException {
        File file=new File(FILE_PATH);
        final String DELIMITER = "\t";

        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            String outValue;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                bw.close();
            }
        }
    }
    public static void WriteDataToFile(File file) throws IOException {
        final String DELIMITER = "\t";

        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            String outValue;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                bw.close();
            }
        }
    }

}
