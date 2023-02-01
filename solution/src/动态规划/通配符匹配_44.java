package 动态规划;

public class 通配符匹配_44 {
    public static void main(String[] args) {

    }
    public boolean isMatch(String s, String p) {
        boolean [] res = new boolean[s.length() + 1];
        res[0] = false;
        for (int i = 1 , j = 0 ; i < s.length() ; i++){
            if (res[i - 1]){

            } else {
                res[i] = false;
            }
        }
        return res[s.length()];
    }
}
