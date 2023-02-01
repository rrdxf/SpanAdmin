package leetcode;

public class leetcode38_外观数组 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if (n==1){
            return "1";
        }
        if (n==2){
            return "11";
        }
        String s=countAndSay(n-1);
        StringBuilder s1=new StringBuilder("");
        int count=1;
        int i;
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i)==s.charAt(i-1)){//如果后一个等于前一个，count：：
                count++;
            }else {//如果不等于，那么将前一个添加到结果中
                s1.append(count);
                s1.append(s.charAt(i-1));
                count=1;
            }
        }
        s1.append(count);
        s1.append(s.charAt(i-1));
        return s1.toString();
    }
}
