package robbot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Robbot robbot = new Robbot();
        robbot.setAge(18);
        robbot.setName("小i");
        robbot.setHobby("吃饭");
        robbot.setSex("女");

        Robbot robbot1 = new Robbot();
        robbot1.setAge(21);
        robbot1.setName("小H");
        robbot1.setHobby("打篮球");
        robbot1.setSex("男");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择你要聊天的机器人编号（输入01或者02）");
        String select = scanner.nextLine();
        if (select.equals("01")){
            robbot.say();
            String say = scanner.nextLine();

            while (true){
                robbot.say(say);
                say = scanner.nextLine();
            }
        }else if (select.equals("02")){
            robbot1.say();
            String say = scanner.nextLine();
            while (true){
                robbot1.say(say);
                say = scanner.nextLine();
            }
        }

    }
}
