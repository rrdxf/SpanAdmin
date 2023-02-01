package daliystudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
["()","()())",")())))"
,"(","","(()((()","()((","(((","(","(()",")())("
,")((","((()",")((","(((",")",")",")((())(",")))())))","()))"
,"((((","(()(","","))(((((","((",")())(","()))(","))()))"
,"(((","())))","(()((()",")()(())()","(())()","()))()(","","(()())))","()))",")()",")",")(","","(",")(","(","","()",")(((((","(","))()()(","(","()((())","","())","()(()"]
*/
public class Kuohaopipei {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("()");
        arr.add("()())");
        arr.add(")())))");
        System.out.println(count(arr));
    }
    public static int count (ArrayList<String> arr) {
        // write code here
        int count = 0;
        for (String str : arr){
            if (str.length()==0 || str.length() % 2 == 1) continue;//如果是空串或者是奇数那么不匹配
            Stack<Character>stack = new Stack<>();
            int i = 0;
            for (; i < str.length(); i++){
                char c = str.charAt(i);
                if (str.charAt(i)=='('){
                    stack.push(c);
                }else if (!stack.isEmpty()){
                    stack.pop();
                }else {
                    break;
                }
            }
            if (stack.isEmpty()&&i==str.length())count++;
        }
        return count;
    }
}
