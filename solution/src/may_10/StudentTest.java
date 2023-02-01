package may_10;

import java.util.Arrays;


public class StudentTest {
    public static void main(String[] args) {
        Student []  students = {new Student("tom"),new Student("jerry"),
                new Student("daniel"),new Student("liang"),new Student("liu")
        ,new Student("lin")};
        Arrays.sort(students);
        for (int i = 0 ; i < students.length; i++){
            System.out.println(students[i].getName());
        }
    }
}
