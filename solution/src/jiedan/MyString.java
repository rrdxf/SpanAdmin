package jiedan;

public class MyString {
    public static void main(String[] args) {
        LinkStringClass test = new LinkStringClass("sa");
        test.Show();
        test.Seti(1,'f');
        test.Show();
        LinkStringClass test1 = test.StrCopy();
        test1.Show();
        System.out.println(test1==test);
        LinkStringClass test3 = new LinkStringClass("ddd");
        test.Concat(test3);
        test.Show();
        test.FindNode(1);
        LinkStringClass test4 = test.SubStr(0,2);
        System.out.println("test4");
        test4.Show();
        test4.InsStr(1,test3);
        test4.Show();
        test4.DelStr(1,2);
        test4.Show();
        System.out.println(compress("ADddsssdfff"));
    }
    static String compress(String s){
        if (s.length() <= 1){
            return s;
        }
        StringBuilder res = new StringBuilder("");
        int count = 1;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) != s.charAt(i - 1)){
                res.append(count).append(s.charAt(i-1));
                count = 1;
            }else{
                count++;
            }
        }
        res.append(count).append(s.charAt(s.length()-1));
        return res.toString().replaceAll("1","");
    }

}
