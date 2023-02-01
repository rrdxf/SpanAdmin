package caculator;

import swingtable.Student;
import swingtable.TableSwingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 提示框类
 */
public class SignDialog extends JFrame{

    JButton jb1;  //按钮
    JPanel jp1,jp2,jp3;		//面板
    JLabel result; //标签
    JFrame jFrame;

    public SignDialog(String log){
        jFrame=this;
        // TODO Auto-generated constructor stub
        jb1 = new JButton("确定");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
            }
        });
        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();
        result=new JLabel(log);
        jp2.add(result);

        jp3.add(jb1);


        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        //设置布局
        this.setTitle("提示");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小
    }

}
