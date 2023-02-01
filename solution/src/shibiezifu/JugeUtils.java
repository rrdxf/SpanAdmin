package shibiezifu;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class JugeUtils  {
    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    private static Set<String> keyword=new HashSet<>();//标识符
    private static Set<String> operator=new HashSet<>();//操作符
    private static Set<String> border=new HashSet<>();//界符
    private static Type type;
    static {
        //界符
        border.add("(");
        border.add(")");
        border.add("}");
        border.add("{");
        border.add("\'");
        border.add("\"");
        border.add("[");
        border.add("]");

        //操作符
        operator.add("+");
        operator.add("-");
        operator.add("=");
        operator.add("==");
        operator.add("&&");
        operator.add("||");
        operator.add("<");
        operator.add(">");
        operator.add(">=");
        operator.add("<=");
        operator.add("||");
        //关键字
        keyword.add("public");
        keyword.add("private");
        keyword.add("import");
        keyword.add("static");
        keyword.add("protected");
        keyword.add("int");
        keyword.add("byte");
        keyword.add("char");
        keyword.add("long");
        keyword.add("short");
        keyword.add("class");
        keyword.add("interface");
        keyword.add("enum");
        keyword.add("extends");
        keyword.add("implements");
        keyword.add("String");
        keyword.add("void");

    }
    private static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    public static int jugeType(String s){
        if (s!=null&&!s.equals(" ")){
            if (s.endsWith(";")){
                String ss=s.substring(0,s.length()-1);
                String [] sss=s.split(";");
                if (isNumeric(ss)||(sss.length>0&&isNumeric(sss[0]))){
                    return 1;
                }
                if (border.contains(ss)){
                    return 5;
                }
            }
            if (isNumeric(s)){
                return 1;
            }
            if (keyword.contains(s)){
                return 2;
            }
            if (operator.contains(s)){
                return 4;
            }
            if (border.contains(s)){
                return 5;
            }
            char c=s.charAt(0);
            if (!(c>='0'&&c<='9')){
                return 3;
            }

            return -1;
        }
        return -1;
    }
}
