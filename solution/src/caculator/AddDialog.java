package caculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 添加操作数界面类
 */
public class AddDialog extends JFrame{
    JButton btn_add;  //按钮
    JPanel jp1;
    JPanel jp2;
    JPanel jp3;
    JPanel  jpl4;		//面板
    JTextField edit_op;
    JTextField edit_rule;
    JTextField edit_proity;   //文本框
    JLabel jlb1;
    JLabel j1;
    JLabel j4;
    JFrame jFrame;
    public AddDialog(){
        jFrame=this;
        btn_add = new JButton("添加符号");
        btn_add.addActionListener(new ActionListener() {//添加符号按钮的点击事件监听函数
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取文本框中的值
                String op=edit_op.getText();
                String rule=edit_rule.getText();
                Integer proity=Integer.valueOf(edit_proity.getText());
                if (!"".equals(op)&&!"".equals(rule)&&!"".equals(proity)){
                    //将获取到文本框中的值放到操作符集合中
                    CaculatorUtil.operator.put(op,proity);//操作符优先级集合
                    CaculatorUtil.newoperator.put(op,proity);//新操作符集合
                    CaculatorUtil.rule.put(op,rule);//操作符规则集合
                    edit_op.setText("");
                    edit_rule.setText("");
                    edit_proity.setText("");
                    new SignDialog("添加成功");
                    jFrame.setVisible(false);
                }else{
                    new SignDialog("添加错误");
                    edit_op.setText("");
                    edit_rule.setText("");
                    edit_proity.setText("");
                }


            }
        });
        /* 此处一下全部为界面布局  */

        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();

        jpl4 = new JPanel();


        jlb1 = new JLabel("输入操作符");  //添加标签
        j1 = new JLabel("输入规则");  //添加标签
        j4 = new JLabel("输入优先级");  //添加标签

        edit_op = new JTextField(5);	//创建文本框和密码框
        edit_rule=new JTextField(5);
        edit_proity=new JTextField(5);
        //加入面板中
        jp1.add(jlb1);
        jp1.add(edit_op);

        jp2.add(j1);
        jp2.add(edit_rule);
        jp3.add(j4);
        jp3.add(edit_proity);
        jpl4.add(btn_add);

        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jpl4);

        //设置布局
        this.setTitle("符号添加");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 150);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小


    }
}
