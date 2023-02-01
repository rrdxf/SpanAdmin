package ss;

import java.util.*;

public class Test {

    // 三题
    private static List<Student> getStudents(int count) {
        System.out.println("第三题：");
        List<Student> list = new ArrayList<>();
        for (int i = 1; i < count; ++i) {
            list.add(new Student("姓名" + i, 18, "无", 0, 0, 0));
        }
        list.add(new Student("任亚汝", 18, "本人", 0, 0, 0));
        for (Student e : list) {
            System.out.println(e);
        }
        return list;
    }

    // 四题
    private static void initStudentsScores(List<Student> list) {
        System.out.println("第四题：");
        for (Student e : list) {
            e.setChemistry((int)(Math.random()*100));
            e.setCreature((int)(Math.random()*100));
            e.setPhysics((int)(Math.random()*100));
        }
        for (Student e : list) {
            System.out.println(e);
        }
    }
    // 五题
    private static void getSumAndAvr(List<Student> list) {
        System.out.println("第五题：");
        for (Student e : list) {
            e.allSum();
            e.allAvr();
        }
        for (Student e : list) {
            System.out.println("平均数：" + e.getAvr() + "  总分:" + e.getSum());
        }
    }
    // 六题
    private static void studentSort(List<Student> list) {
        System.out.println("第六题：");
        Collections.sort(list);
        for (int i = 0; i < 10; ++i) {
            System.out.println(list.get(i).toString() + "  功课平均分：" + list.get(i).getAvr());
        }
    }
    // 七题
    private static void cacuAll(List<Student> list) {
        System.out.println("第七题：");
        int sum = 0;
        for (Student e : list) {
            sum += e.getCreature();
        }
        double creaAvr = sum / list.size();
        System.out.println("生物平均：" + creaAvr);
        sum = 0;
        for (Student e : list) {
            sum += e.getChemistry();
        }
        double cheAvr = sum / list.size();
        System.out.println("化学平均：" + cheAvr);
        sum = 0;
        for (Student e : list) {
            sum += e.getPhysics();
        }
        double phyAvr = sum / list.size();
        System.out.println("物理平均：" + phyAvr);

        sum = 0;
        for (Student e : list) {
            sum += (e.getCreature() - creaAvr) * (e.getCreature() - creaAvr);
        }
        System.out.println("生物标准差"+Math.sqrt(sum / list.size()));

        sum = 0;
        for (Student e : list) {
            sum += (e.getChemistry() - creaAvr) * (e.getChemistry() - cheAvr);
        }
        System.out.println("化学标准差"+Math.sqrt(sum / list.size()));

        sum = 0;
        for (Student e : list) {
            sum += (e.getPhysics() - creaAvr) * (e.getPhysics() - phyAvr);
        }
        System.out.println("物理标准差"+Math.sqrt(sum / list.size()));

        System.out.println("生物中位数" + (list.get(14).getCreature() + list.get(15).getCreature()) / 2);
        System.out.println("化学中位数" + (list.get(14).getChemistry() + list.get(15).getChemistry()) / 2);
        System.out.println("物理中位数" + (list.get(14).getPhysics() + list.get(15).getPhysics()) / 2);
    }
    public static void main(String[] args) {
        List<Student> students = getStudents(30);
        initStudentsScores(students);
        getSumAndAvr(students);
        studentSort(students);
        cacuAll(students);
    }

}
