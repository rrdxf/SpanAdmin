package swingtable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddDialog extends JFrame{
    JFrame frame;
    JButton jb1, jb2, jb3;  //按钮
    JPanel jp1,jp2,jp3, jp4;		//面板
    JPanel jpl1,jpl2,jpl3, jpl4;		//面板
    JTextField edit_id,edit_name,edit_sex,edit_age,edit_phone;   //文本框
    JLabel jlb1, jlb2, jlb3,result,j1,j2,j3,j4,j5; //标签
    JPasswordField jpf; //密码框

    public static void main(String[] args) {
        new AddDialog(new JFrame());
    }
    public AddDialog(JFrame frame){
        // TODO Auto-generated constructor stub
        this.frame=frame;
        jb1 = new JButton("添加");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=edit_id.getText();
                String name=edit_name.getText();
                String sex=edit_sex.getText();
                String age=edit_age.getText();
                String phone=edit_phone.getText();
                if (id!=""&&name!=""&&sex!=""&age!=""&&phone!=""){
                    Student student=new Student();
                    student.setAge(Integer.valueOf(age));
                    student.setGender(sex);
                    student.setId(Integer.valueOf(id));
                    student.setPhone_number(phone);
                    student.setName(name);
                    TableSwingData.list.add(student);
                    if (StudentMainFrame.nowfile==null){
                        try {
                            IOUtils.WriteDataToFile();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        try {
                            IOUtils.WriteDataToFile(StudentMainFrame.nowfile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    new StudentMainFrame();
                    frame.setVisible(false);
                   edit_id.setText("");
                   edit_name.setText("");
                   edit_sex.setText("");
                   edit_age.setText("");
                   edit_phone.setText("");
                }

            }
        });
        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jpl1 = new JPanel();  //创建面板
        jpl2 = new JPanel();
        jpl3 = new JPanel();
        jpl4 = new JPanel();


        jlb1 = new JLabel("输入学号");  //添加标签
        j1 = new JLabel("输入姓名");  //添加标签
        j2 = new JLabel("输入性别");  //添加标签
        j3 = new JLabel("输入年龄");  //添加标签
        j4 = new JLabel("输入电话");  //添加标签


        result=new JLabel("点击查询显示结果");

        edit_id = new JTextField(5);	//创建文本框和密码框
        edit_name=new JTextField(5);
        edit_age=new JTextField(5);
        edit_phone=new JTextField(5);
        edit_sex=new JTextField(5);
        //加入面板中
        jp1.add(jlb1);
        jp1.add(edit_id);

        jpl1.add(j1);
        jpl1.add(edit_name);
        jpl2.add(j2);
        jpl2.add(edit_sex);
        jpl3.add(j3);
        jpl3.add(edit_age);
        jpl4.add(j4);
        jpl4.add(edit_phone);


        jp3.add(jb1);


        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jpl1);
        this.add(jpl2);
        this.add(jpl3);
        this.add(jpl4);




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
