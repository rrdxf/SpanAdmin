package caculator;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 计算工具类
 */
public class CaculatorUtil {

    public static Map<String,Integer> operator;//存储操作符及其优先级
    public static Map<String,String> rule;//规则map

    public static Map<String,Integer> newoperator;
    static {//静态代码块，初始化计算机基本的操作符集合
        rule=new HashMap<>();

        newoperator=new HashMap<>();

        operator=new HashMap<>();
        operator.put("+",0);
        operator.put("-",0);
        operator.put("x",1);
        operator.put("/",1);
    }
    /**
     *
     */
    /**
     *
     * @param
     * @return 返回后缀表达式
     * 得到后缀表达式函数
     */
    public static List<String> midToSufix(List<String>  expressionList){
        //创建一个栈用于保存操作符
        Stack<String> opStack = new Stack<>();
        //创建一个list用于保存后缀表达式
        List<String> suffixList = new ArrayList<>();
        for(String item : expressionList){
            //得到数或操作符
            if(isOperator(item)){
                //是操作符 判断操作符栈是否为空
                if(opStack.isEmpty() || "(".equals(opStack.peek()) || operator.get(item) > operator.get(opStack.peek())){
                    //为空或者栈顶元素为左括号或者当前操作符大于栈顶操作符直接压栈
                    opStack.push(item);
                }else {
                    //否则将栈中元素出栈如队，直到遇到大于当前操作符或者遇到左括号时
                    while (!opStack.isEmpty() && !"(".equals(opStack.peek())){
                        if(operator.get(item) <= operator.get(opStack.peek())){
                            suffixList.add(opStack.pop());
                        }
                    }
                    //当前操作符压栈
                    opStack.push(item);
                                   }
            }else if(isNum(item)){
                //是数字则直接入队
                suffixList.add(item);
            }else if("(".equals(item)){
                //是左括号，压栈
                opStack.push(item);
            }else if(")".equals(item)){
                //是右括号 ，将栈中元素弹出入队，直到遇到左括号，左括号出栈，但不入队
                while (!opStack.isEmpty()){
                    if("(".equals(opStack.peek())){
                        opStack.pop();
                        break;
                    }else {
                        suffixList.add(opStack.pop());
                    }
                }
            }else {
                new SignDialog("有非法字符！");
                throw new RuntimeException("有非法字符！");
            }
        }
        //循环完毕，如果操作符栈中元素不为空，将栈中元素出栈入队
        while (!opStack.isEmpty()){
            suffixList.add(opStack.pop());
        }
        return suffixList;
    }

    /**
     *
     * @param op
     * @return 是否为操作符
     * 判断是否为操作符
     */
    private static boolean isOperator(String op){
        return operator.containsKey(op);
    }

    /**
     *
     * @param str
     * @return 是否为数字
     * 判断是否为数字
     */
    private static boolean isNum(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     *
     * @param expr
     * @return 将String字符串转为list，方便中缀式转后缀式
     * 将输入的表达式字符串转为list，方便中转后的操作
     */
    public static List<String> exprToList(String expr){
        int index = 0;
        List<String> list = new ArrayList<>();
        do{
            char ch = expr.charAt(index);
            if(ch < 47 || ch > 58){
                //是操作符，直接添加至list中
                index ++ ;
                list.add(ch+"");
            }else if(ch >= 48 && ch <= 58){//‘0’和‘9’的ascii码是48和58
                //是数字,判断多位数的情况
                String str = "";
                //这里是将表达式中的操作数提取出来，作为单个string，存起来
                while (index < expr.length() && expr.charAt(index) >=48 && expr.charAt(index) <= 58){
                    str += expr.charAt(index);
                    index ++;
                }
                list.add(str);
            }
        }while (index < expr.length());
        return list;
    }

     /**
      * 根据后缀表达式list计算结果
      * @param list 后缀表达式lis
      * @return 结果
      * 这里传入后缀表达式list 然后返回int型的计算结果
      */
     public static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<>();//操作数栈
        for(int i=0; i<list.size(); i++){//后缀表达式计算方法
            /*
            遇到数字，就压栈
            如果不是数字，就去除栈中的两个元素进行计算
             */
            String item = list.get(i);
            if(item.matches("\\d+")){//判断是否为数字
                //是数字
                stack.push(Integer.parseInt(item));
            }else {//如果不是数字
                //是操作符，取出栈顶两个元素
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("x")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else if (newoperator.containsKey(item)){//此处判断是否为新的操作符
                    res=caculatNewOper(rule.get(item),num1,num2);

                }else {
                    new SignDialog("运算符错误！");
                    throw new RuntimeException("运算符错误！");
                }
                stack.push(res);//然后将结果推入栈中
            }
        }
        return stack.pop();//栈中结果推出
     }

    /**
     * 计算新的操作符的值，为了防止用户用新的操作符又定义了新的操作符
     * @param item 操作符规则
     * @param num1 第一个参数
     *
     * @param num2 第二个参数
     * @return 返回结果
     */
     private static int caculatNewOper(String item,int num1,int num2){//此处为一个递归
         int res=num1;
         String[] it=item.split("");
         for (int i = 0;i < it.length; i++){
             if(it[i].equals("+")){
                 res = res + num2;
             }else if(it[i].equals("-")){
                 res = res - num2;
             }else if(it[i].equals("x")){
                 res = res * num2;
             }else if(it[i].equals("/")) {
                 res = res / num2;
             }else if (newoperator.containsKey(it[i])){//计算新的操作符
                 res = caculatNewOper(rule.get(item),res,num2);//
             }else {
                 throw new RuntimeException("运算符错误！");
             }
         }
         return res;
     }
}
