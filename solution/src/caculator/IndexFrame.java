package caculator;

import shibiezifu.IOUtils;
import shibiezifu.JugeUtils;
import shibiezifu.MainFrame;
import shibiezifu.OutDialog;
import swingtable.FindDialog;
import swingtable.Student;
import swingtable.TableSwingData;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 首页
 */
public class IndexFrame extends JFrame{

    JButton btn_caculator;  //按钮
    JButton btn_add;  //添加按钮

    //布局控件，将窗口分为三部分
    JPanel jp1;
    JPanel jp2;
    JPanel jp3;		//面板
    JPanel jp4;		//面板
    JTextField edit;   //输入文本框
    JLabel sginlabel;
    JLabel result; //显示后缀表达式
    JLabel sufixresult; //显示结果标签
    public IndexFrame(){
        btn_add=new JButton("添加运算符");
        btn_caculator = new JButton("计算");
        //计算按钮监听函数
        btn_caculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expr=edit.getText();//得到输入表达式
                List<String>list=CaculatorUtil.exprToList(expr);//将字符串转为list
                list=CaculatorUtil.midToSufix(list);//将list再转为后缀表达式

                //这里和下头的循环是将后缀表达式转为string，然后显示到界面上
                StringBuilder s=new StringBuilder("");//
                for (String ss:list){
                    s.append(ss);
                }
                //显示后缀表达式
                sufixresult.setText("后缀表达式："+s);
                //显示并计算结果
                result.setText("结果为："+CaculatorUtil.calculate(list)+"");
            }
        });
        btn_add.addActionListener(new ActionListener() {//添加操作符按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog();//弹窗
            }
        });

        /* 以下为界面布局代码 */
        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4=new JPanel();

        sginlabel = new JLabel("输入表达式");  //添加标签
        result=new JLabel("计算结果");
        sufixresult=new JLabel("后缀表达式");
        edit = new JTextField(20);	//创建文本框和密码框

        //加入面板中
        jp1.add(sginlabel);
        jp1.add(edit);

        jp2.add(result);

        jp3.add(btn_caculator);
        jp3.add(btn_add);

        jp4.add(sufixresult);

        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        //设置布局
        this.setTitle(" 表达式求值器");
        this.setLayout(new GridLayout(3,1));
        this.setSize(new Dimension(550, 200));   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        this.setVisible(true);  //设置可见

    }

}
