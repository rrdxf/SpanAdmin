package swingtable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindDialog extends JFrame{

    JButton jb1, jb2, jb3;  //按钮
    JPanel jp1,jp2,jp3, jp4;		//面板
    JTextField edit_id;   //文本框
    JLabel jlb1, jlb2, jlb3,result; //标签
    JPasswordField jpf; //密码框

    public static void main(String[] args) {
        new FindDialog();
    }

    public FindDialog(){
        // TODO Auto-generated constructor stub
        jb1 = new JButton("查询");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id=Integer.valueOf(edit_id.getText());
                int count=0;
                for(Student s:TableSwingData.list){
                    if (s.getId()==id){
                        count=1;
                        result.setText("学号："+s.getId()+" 姓名:"+s.getName()+" 性别："+
                                s.getGender()+" 年龄："+s.getAge()+" 电话:"+s.getPhone_number());
                        break;
                    }
                }
                if (count==0){
                    result.setText("未查找到此人");
                }

            }
        });
        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();


        jlb1 = new JLabel("输入学号");  //添加标签
        result=new JLabel("点击查询显示结果");

        edit_id = new JTextField(10);	//创建文本框和密码框

        //加入面板中
        jp1.add(jlb1);
        jp1.add(edit_id);

        jp2.add(result);

        jp3.add(jb1);


        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);



        //设置布局
        this.setTitle("用户登录");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小


    }

}
