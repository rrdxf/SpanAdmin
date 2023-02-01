package shibiezifu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutDialog extends JFrame{

    JButton jb1, jb2, jb3;  //按钮
    JPanel jp1,jp2,jp3, jp4;		//面板
    JTextField edit_id;   //文本框
    JLabel jlb1, jlb2, jlb3,result; //标签
    JPasswordField jpf; //密码框
    int [] type;

    public OutDialog(int [] type){
        this.type=type;
        // TODO Auto-generated constructor stub
        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();


        result=new JLabel("常数："+type[1]+"\n关键字："+type[2]+
                "\n标识符："+type[3]+"\n运算符:"+type[4]+"\n界符："+type[5]);
        result.setBounds(10,10,100,100);
        edit_id = new JTextField(10);	//创建文本框和密码框


        jp2.add(result);



        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);



        //设置布局
        this.setTitle("结果显示");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小


    }

}
