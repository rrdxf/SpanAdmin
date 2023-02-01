package robbot;

import java.util.Scanner;

public class Robbot {
    private String name;
    private int age;
    private int strength;
    private String sex;
    private String hobby;

    public void eat(){
        if (this.strength >= 100){
            System.out.println("我现在太撑拉，吃不下东西啦！");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.printf("输入你要喂给机器人的食物：");
        String food = scanner.nextLine();
        if (food.equals("苹果")){
            System.out.println("吃过"+food+"之后，机器人体力增加"+5);
            this.strength+=5;
        } else if (food.equals("面条")){
            System.out.println("吃过"+food+"之后，机器人体力增加"+10);
            this.strength+=10;
        } else if (food.equals("馒头")){
            System.out.println("吃过"+food+"之后，机器人体力增加"+20);
            this.strength+=20;
        }else {
            System.out.println("吃过"+food+"之后，机器人体力增加"+1);
            this.strength+=1;
            System.out.println("我最喜欢吃苹果、面条、馒头，吃这些我会增加很多体力哦");
        }
        System.out.println("机器人现在的体力是"+this.strength);
        System.out.println("您是否要继续喂食呢（请输入是或者否）？");
        String ok = scanner.nextLine();
        if (ok.equals("是")){
            eat();
        }
    }

    public void say(String say){
        if (this.strength < 20){
            System.out.println("我太饿拉，没有力气说话了~");
            eat();
            return;
        }
        if (say.contains("你好")||say.contains("您好")
                ||say.contains("Hi")||say.contains("hi")
                ||say.contains("hello")){
            System.out.println("您好");
        } else if (say.contains("吃")&&say.contains("吗")){
            System.out.println("刚刚吃过");
        } else if ((say.contains("吃")&&say.contains("啥"))||(say.contains("吃")&&say.contains("什么"))){
            System.out.println("我喜欢吃苹果、馒头、面条~");
        }  else if ((say.contains("名字")&&say.contains("啥"))
                ||(say.contains("名字")&&say.contains("什么"))
                ||(say.contains("叫")&&say.contains("什么"))
                ||(say.contains("叫")&&say.contains("啥"))) {
            System.out.println("我的名字叫" + this.name);
        } else if (say.contains("性别")||say.contains("男")||say.contains("女")){
            System.out.println("我是"+this.sex+"生");
        }else if (say.contains("多大")||say.contains("了")||say.contains("年龄")){
            System.out.println("我今年"+this.age+"岁了");
        } else if (say.contains("爱好")&&say.contains("什么")){
            System.out.println("我的爱好是"+this.hobby);
        } else {
            System.out.println("你可以试着问问我其他问题哦，这个问题我不太会~");
        }
        this.strength-=20;
    }
    public void say(){
        System.out.println("你好呀，现在我们可以开始聊天了~");
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Robbot(String name, int age, String sex, String hobby) {
        this.name = name;
        this.age = age;
        this.strength = 100;
        this.sex = sex;
        this.hobby = hobby;
    }

    public Robbot() {
        this.strength = 100;
    }
}
