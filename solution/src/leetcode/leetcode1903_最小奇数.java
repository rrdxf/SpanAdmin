package leetcode;

public class leetcode1903_最小奇数 {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("35427"));
    }
    public static String largestOddNumber(String num) {
        int n;
        for (int i = num.length() - 1; i >= 0; --i) {
            n = num.charAt(i) - '0';
            if (n % 2 != 0){
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
