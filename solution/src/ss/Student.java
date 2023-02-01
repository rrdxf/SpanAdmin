package ss;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private String office; // 职务
    private int creature; // 生物
    private int chemistry;
    private int physics;
    private int sum;
    private double avr;

    public void allSum() {
        this.sum = creature + chemistry + physics;
    }
    public void allAvr() {
        this.avr = this.sum / 3;
    }
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getAvr() {
        return avr;
    }

    public void setAvr(double avr) {
        this.avr = avr;
    }

    @Override
    public String toString() {
        return  "姓名：'" + name + '\'' +
                ", 年龄：" + age +
                ", 班级职务：'" + office + '\'' +
                ", 生物：" + creature +
                ", 化学：" + chemistry +
                ", 物理：" + physics;
    }

    public Student() {
    }

    public Student(String name, int age, String office, int creature, int chemistry, int physics) {
        this.name = name;
        this.age = age;
        this.office = office;
        this.creature = creature;
        this.chemistry = chemistry;
        this.physics = physics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getCreature() {
        return creature;
    }

    public void setCreature(int creature) {
        this.creature = creature;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }


    @Override
    public int compareTo(Student o) {
        return (int) (o.avr - avr);
    }
}
