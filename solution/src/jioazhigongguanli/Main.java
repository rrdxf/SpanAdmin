package jioazhigongguanli;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("========教职工管理系统========");
        System.out.println("========1、添加教职工=========");
        System.out.println("========2、职工号查找=========");
        System.out.println("========3、科室查找===========");
        System.out.println("========4、姓名查找======-====");
        System.out.println("========5、查找各部门人数======");
        System.out.println("========6、职称排序查看信息=====");
        System.out.println("========7、修改职工信息=====");
        System.out.println("========8、删除职工信息=====");
        System.out.println("===========================");
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();//输入选他
        scanner.nextLine();
        List<Employee> list = new ArrayList<>();//系统主list
        File file = new File("out.txt");//out.txt文档
        if (file.exists()){//如果文件存在，那么将文件中的信息读入到list中
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("out.txt"));
            list = (List<Employee>) is.readObject();
        }
        while (true){
            if (select == 1){//添加教职工
                //输入信息
                Employee person = new Employee();
                System.out.printf("请输入工号：");
                person.setEmid(scanner.nextLine());
                System.out.printf("请输姓名：");
                person.setName(scanner.nextLine());
                System.out.printf("请输入身份证号：");
                person.setPerid(scanner.nextLine());
                System.out.printf("请输入电话：");
                person.setPhone(scanner.nextLine());
                System.out.printf("请输入性别（1为男，0为女）:");
                person.setSex(scanner.nextInt());
                scanner.nextLine();
                System.out.printf("请输入生日(格式：年/月/日)：");
                String s = scanner.nextLine();
                person.setDate1(new Date(s));
                System.out.printf("请输入职称(1为助教，2为讲师，3为副教授，4为教授)：");
                person.setCompetent(scanner.nextInt());
                scanner.nextLine();
                System.out.printf("请输入部门：");
                person.setBranch(scanner.nextLine());


                //根据输入的工号查找，不可重复添加
                boolean find = false;
                for (Employee employee : list){//利用循环查找
                    if (employee.getEmid().equals(person.getEmid())){
                        find = true;
                    }
                }


                if (!find){//如果没有找到就添加
                    list.add(person);
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("out.txt"));
                        os.writeObject(list);
                        os.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("添加成功");
                }else {
                    System.out.println("该员工已存在，无需重复添加");
                }


            }else if (select == 2 ){
                System.out.printf("输入查找职工号:");
                String number = scanner.nextLine();
                //查找
                for (Employee employee : list){
                    if (number.equals(employee.getEmid())){
                        System.out.printf(employee.toString());
                        break;
                    }
                }
            } else if (select == 3){
                System.out.printf("输入查找科室:");
                String number = scanner.nextLine();
                for (Employee employee : list){
                    if (number.equals(employee.getBranch())){
                        System.out.println(employee.toString());
                    }
                }
            }else if (select == 4 ){
                System.out.printf("输入查找姓名:");
                String number = scanner.nextLine();
                for (Employee employee : list){
                    if (number.equals(employee.getName())){
                        System.out.println(employee.toString());
                    }
                }
            }else if (select == 5){
                Map<String , Integer> map = new HashMap<>();
                for (Employee employee : list){
                    if (map.containsKey(employee.getBranch())){
                        map.put(employee.getBranch(),map.get(employee.getBranch()) + 1);
                    }else {
                        map.put(employee.getBranch(),1);
                    }
                }
                for (Map.Entry<String,Integer> entry : map.entrySet()){
                    System.out.println("部门："+entry.getKey() + " 人数："+entry.getValue());
                }
            }else if (select == 6){

                //Arrays.sort(list.toArray());
                Collections.sort(list);
                for (Employee employee : list){
                    System.out.println(employee.toString());
                }
            }else if (select == 7){
                System.out.printf("输入修改职工号:");
                String number = scanner.nextLine();
                for (Employee employee : list){
                    if (number.equals(employee.getEmid())){
                        System.out.println("请重新录入该员工信息：");
                        System.out.printf("请输入电话：");
                        employee.setPhone(scanner.nextLine());
                        System.out.printf("请输入生日(格式：年/月/日)：");
                        String s = scanner.nextLine();
                        employee.setDate1(new Date(s));
                        System.out.printf("请输入职称(1为助教，2为讲师，3为副教授，4为教授)：");
                        employee.setCompetent(scanner.nextInt());
                        scanner.nextLine();
                        System.out.printf("请输入部门：");
                        employee.setBranch(scanner.nextLine());
                        try {
                            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("out.txt"));
                            os.writeObject(list);
                            os.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("修改成功");
                    }
                }
            }else if (select == 8){
                System.out.printf("输入删除的职工号:");
                String number = scanner.nextLine();
                for (int i = 0; i < list.size() ; i++){
                    if (number.equals(list.get(i).getEmid())){
                        list.remove(i);
                        System.out.println("删除成功");
                        break;
                    }
                }
                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("out.txt"));
                    os.writeObject(list);
                    os.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("没有该功能，请重新输入");
            }
            System.out.println("========教职工管理系统========");
            System.out.println("========1、添加教职工=========");
            System.out.println("========2、职工号查找=========");
            System.out.println("========3、科室查找===========");
            System.out.println("========4、姓名查找======-====");
            System.out.println("========5、查找各部门人数======");
            System.out.println("========6、职称排序查看信息=====");
            System.out.println("========7、修改职工信息=====");
            System.out.println("========8、删除职工信息=====");
            System.out.println("===========================");
            select = scanner.nextInt();
            scanner.nextLine();
        }

        //System.out.flush();
    }
}
