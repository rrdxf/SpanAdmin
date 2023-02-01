package swingtable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class IOUtils {
    public static final String FILE_PATH="student.txt";
    /**
     * 从文件提取数据，格式化到程序中
     * @throws IOException
     */
    public static List<Student> GetDataFromFile() throws IOException {
        final String DELIMITER = "\t";
        List<Student> list=new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(FILE_PATH);
            if (file.exists()){
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

                String line = null;
                while (null != (line=br.readLine())) {
                    String [] ss=line.split(" ");
                    Student student=new Student();
                    student.setId(Integer.valueOf(ss[3]));
                    student.setAge(Integer.valueOf(ss[2]));
                    student.setGender(ss[1]);
                    student.setName(ss[0]);
                    student.setPhone_number(ss[4]);
                    list.add(student);

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
    public static List<Student> GetDataFromFile(String path) throws IOException {
        final String DELIMITER = "\t";
        List<Student> list=new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(path);
            if (file.exists()){
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

                String line = null;
                while (null != (line=br.readLine())) {
                    String [] ss=line.split(" ");
                    Student student=new Student();
                    student.setId(Integer.valueOf(ss[3]));
                    student.setAge(Integer.valueOf(ss[2]));
                    student.setGender(ss[1]);
                    student.setName(ss[0]);
                    student.setPhone_number(ss[4]);
                    list.add(student);

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
            for (Student student:TableSwingData.list) {
                outValue=student.getName()+" "+student.getGender()+" "+
                        student.getAge()+" "+student.getId()+" "+
                        student.getPhone_number();
                bw.write(outValue);  // 将数据写入文件中
                bw.newLine();        // 新建一个换行符
                bw.flush();
            }
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
            for (Student student:TableSwingData.list) {
                outValue=student.getName()+" "+student.getGender()+" "+
                        student.getAge()+" "+student.getId()+" "+
                        student.getPhone_number();
                bw.write(outValue);  // 将数据写入文件中
                bw.newLine();        // 新建一个换行符
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bw) {
                bw.close();
            }
        }
    }

}
