package swingtable;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


public class StudentMainFrame extends JFrame{
    protected static File nowfile=null;
    private JFrame frame;
    protected static JTable table;
    private JScrollPane jsp;
    private DefaultTableModel dtm;
    private DefaultTableCellRenderer dtr;
    private JTextField textField_sno;
    private JTextField textField_sname;
    private JTextField textField_sex;
    private JTextField textField_age;
    private JTextField textField_phone;
    private Vector v;
    private JButton save;
    private JButton load;
    private JButton delete;
    private JButton find;
    private JButton add;
    private JPanel contentPane;

    public static void main(String[] args) throws IOException {
        TableSwingData.list=IOUtils.GetDataFromFile();
        new StudentMainFrame();
    }

    //创建学生表格
    public StudentMainFrame(){
        frame = new JFrame();
        dtm = new DefaultTableModel();
        dtr = new DefaultTableCellRenderer();
        dtr.setHorizontalAlignment(JLabel.CENTER);
        table = new JTable(stuTableModel(dtm));
        table.setDefaultRenderer(Object.class,dtr);
        table.setBounds(10,10,500,500);
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println("数据改变");
                System.out.println("==>"+e.getFirstRow()+"-->"+e.getLastRow());
                int editrow=e.getLastRow();
                int editcol=e.getColumn();
                String newvalue = table.getModel().getValueAt(e.getLastRow(),e.getColumn()).toString();
                System.out.println(newvalue);
                if (editrow==1)TableSwingData.list.get(editcol).setId(Integer.valueOf(newvalue));
                else if (editrow==2)TableSwingData.list.get(editcol).setName(newvalue);
                else if (editrow==3)TableSwingData.list.get(editcol).setGender(newvalue);
                else if (editrow==4)TableSwingData.list.get(editcol).setAge(Integer.valueOf(newvalue));
                else if (editrow==5)TableSwingData.list.get(editcol).setPhone_number(newvalue);
                if (nowfile==null){
                    try {
                        IOUtils.WriteDataToFile();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    try {
                        IOUtils.WriteDataToFile(nowfile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        //保存按钮
        save=new JButton("保存");
        save.setBounds(150, 200, 97, 23);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //弹出文件选择框
                JFileChooser chooser = new JFileChooser();

                //下面的方法将阻塞，直到【用户按下保存按钮且“文件名”文本框不为空】或【用户按下取消按钮】
                int option = chooser.showSaveDialog(null);
                if(option==JFileChooser.APPROVE_OPTION){	//假如用户选择了保存
                    File file = chooser.getSelectedFile();
                    try {
                        IOUtils.WriteDataToFile(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    new DemoDialog("保存成功");
                }


            }
        });


        //加载文件按钮
        load=new JButton("加载文件");
        load.setBounds(300,200,97,23);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();             //设置选择器
                chooser.setMultiSelectionEnabled(true);             //设为多选
                int returnVal = chooser.showOpenDialog(load);        //是否打开文件选择框
                System.out.println("returnVal="+returnVal);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //如果符合文件类型
                    String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
                    nowfile=new File(filepath);
                    System.out.println(filepath);
                    System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());  //输出相对路径
                    try {
                        TableSwingData.list=IOUtils.GetDataFromFile(filepath);
                        frame.setVisible(false);
                        new StudentMainFrame();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        //删除按钮
        delete=new JButton("删除选中行");
        delete.setBounds(300,200,97,23);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectRows = table.getSelectedRows();
                TableModel tableModel=table.getModel();
                int removeNum = 0;
                for(int index=0;index<selectRows.length;index++) {
                    TableSwingData.list.remove(selectRows[index]);
                }
                new StudentMainFrame();
                frame.setVisible(false);
                if (nowfile==null){
                    try {
                        IOUtils.WriteDataToFile();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    try {
                        IOUtils.WriteDataToFile(nowfile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        //修改按钮
        find=new JButton("查找");
        find.setBounds(300,200,97,23);
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindDialog();
            }
        });
        //修改按钮
        add=new JButton("添加一个学生");
        add.setBounds(300,200,97,23);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(frame);
            }
        });
        //新加代码
        JPanel panel=new JPanel();
        panel.add(save);
        panel.add(load);
        panel.add(delete);
        panel.add(find);
        panel.add(add);

        jsp = new JScrollPane();
        jsp.setViewportView(table);
        frame.add(jsp,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.SOUTH);
        //frame.getContentPane().add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    //使用DefaultTableModel导入表中数据
    private DefaultTableModel stuTableModel(DefaultTableModel dtm){
        String[] stu ={"学号", "姓名", "性别", "年龄", "电话"};
        dtm.setColumnIdentifiers(stu);
        for (Student student:TableSwingData.list){
            v=new Vector();
            v.add(student.getId());
            v.add(student.getName());
            v.add(student.getGender());
            v.add(student.getAge());
            v.add(student.getPhone_number());
            System.out.println(student);
            dtm.addRow(v);
        }
        return dtm;
    }

    //学生信息操作界面
    public void stuManager(){
        JLabel lblNewLabel = new JLabel("学号");
        lblNewLabel.setBounds(24, 28, 58, 15);
        getContentPane().add(lblNewLabel);

        textField_sno = new JTextField();
        textField_sno.setBounds(109, 25, 103, 21);
        getContentPane().add(textField_sno);
        textField_sno.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("姓名");
        lblNewLabel_1.setBounds(24, 86, 58, 15);
        getContentPane().add(lblNewLabel_1);

        textField_sname = new JTextField();
        textField_sname.setBounds(109, 83, 103, 21);
        getContentPane().add(textField_sname);
        textField_sname.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("性别");
        lblNewLabel_2.setBounds(24, 151, 58, 15);
        getContentPane().add(lblNewLabel_2);

        textField_sex = new JTextField();
        textField_sex.setBounds(109, 148, 103, 21);
        getContentPane().add(textField_sex);
        textField_sex.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("年龄");
        lblNewLabel_3.setBounds(24, 210, 58, 15);
        getContentPane().add(lblNewLabel_3);

        textField_age = new JTextField();
        textField_age.setBounds(109, 207, 103, 21);
        getContentPane().add(textField_age);
        textField_age.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("电话");
        lblNewLabel_4.setBounds(24, 280, 58, 15);
        getContentPane().add(lblNewLabel_4);

        textField_phone = new JTextField();
        textField_phone.setBounds(109, 277, 103, 21);
        getContentPane().add(textField_phone);
        textField_phone.setColumns(10);

        JButton btnNewButton_add = new JButton("添加");
        btnNewButton_add.setBounds(306, 24, 97, 23);
//        btnNewButton_add.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                add(textField_sno,textField_sname,textField_sex,textField_birthday,textField_phone,textField_address);
//            }
//        });
        getContentPane().add(btnNewButton_add);

        JButton btnNewButton_delete = new JButton("删除");
        btnNewButton_delete.setBounds(306, 110, 97, 23);

        getContentPane().add(btnNewButton_delete);

        JButton btnNewButton_alter = new JButton("修改");
        btnNewButton_alter.setBounds(306, 178, 97, 23);

        getContentPane().add(btnNewButton_alter);

        JButton btnNewButton_query = new JButton("查询");
        btnNewButton_query.setBounds(306, 240, 97, 23);

        getContentPane().add(btnNewButton_query);

        JButton btnNewButton_reset = new JButton("重置");
        btnNewButton_reset.setBounds(306, 323, 97, 23);

        getContentPane().add(btnNewButton_reset);
        setTitle("\u5B66\u751F\u4FE1\u606F\u64CD\u4F5C");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 473, 467);
        this.setSize(540,500);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setVisible(true);
    }
//
//    //添加学生数据
//    private void add(JTextField textField_sno,JTextField textField_sname,JTextField textField_sex,JTextField textField_birthday,JTextField textField_phone,JTextField textField_address){
//        String sno = textField_sno.getText();
//        String sname =textField_sname.getText();
//        String sex = textField_sex.getText();
//        String birthday = textField_birthday.getText();
//        String phone = textField_phone.getText();
//        String address = textField_address.getText();
//        v = new Vector();
//        v.add(sno);
//        v.add(sname);
//        v.add(sex);
//        v.add(birthday);
//        v.add(phone);
//        v.add(address);
//        dtm.addRow(v);
//        dtm.setColumnIdentifiers(v);
//        try {
//            conn = Utils.getConnection();
//            conn.setAutoCommit(false);
//            Statement st =null;
//            String sql = "insert into stu(学号,姓名,性别,生日,电话,地址) value(?,?,?,?,?,?)";
//            pstm = conn.prepareStatement(sql);
//            pstm.setString(1,sno);
//            pstm.setString(2,sname);
//            pstm.setString(3,sex);
//            pstm.setString(4,birthday);
//            pstm.setString(5,phone);
//            pstm.setString(6,address);
//            pstm.executeUpdate();
//            conn.commit();
//            JOptionPane.showMessageDialog(null,"添加成功");
//        } catch (SQLException throwables) {
//            JOptionPane.showMessageDialog(null,"添加失败");
//
//            throwables.printStackTrace();
//        }
//    }
//
//    //删除学生数据
//    private void delete(JTextField textField_sno){
//        String sno = textField_sno.getText();
//        try {
//            conn = Utils.getConnection();
//            String sql = "delete from stu where 学号 =?";
//            pstm = conn.prepareStatement(sql);
//            pstm.setString(1,sno);
//            pstm.execute();
//            JOptionPane.showMessageDialog(null,"删除成功");
//        } catch (SQLException throwables) {
//            JOptionPane.showMessageDialog(null,"删除失败");
//            throwables.printStackTrace();
//        } finally {
//            Utils.close(pstm,conn);
//        }
//    }
//
//    //修改学生数据
//    private void alter(JTextField textField_sno,JTextField textField_sname,JTextField textField_sex,JTextField textField_birthday,JTextField textField_phone,JTextField textField_address) {
//        String sno = textField_sno.getText();
//        String sname =textField_sname.getText();
//        String sex = textField_sex.getText();
//        String birthday = textField_birthday.getText();
//        String phone = textField_phone.getText();
//        String address = textField_address.getText();
//        try {
//            conn = Utils.getConnection();
//            conn.setAutoCommit(false);
//            String sql = "update stu set 学号=?,姓名=?,性别=?,生日=?,电话=?,地址=? where 学号=?";
//            pstm = conn.prepareStatement(sql);
//            pstm.setString(1,sno);
//            pstm.setString(2,sname);
//            pstm.setString(3,sex);
//            pstm.setString(4,birthday);
//            pstm.setString(5,phone);
//            pstm.setString(6,address);
//            pstm.setString(7,sno);
//            pstm.executeUpdate();
//            JOptionPane.showMessageDialog(null,"修改成功");
//        } catch (SQLException throwables) {
//            JOptionPane.showMessageDialog(null,"修改失败");
//            throwables.printStackTrace();
//        } finally {
//            Utils.close(pstm,conn);
//        }
//    }
//
//    //查询学生数据
//    private void query(JTextField textField_sno,JTextField textField_sname,JTextField textField_sex,JTextField textField_birthday,JTextField textField_phone,JTextField textField_address){
//        String sno = textField_sno.getText();
//        try {
//            conn = Utils.getConnection();
//            conn.setAutoCommit(false);
//            String sql = "select * from stu where 学号=?";
//            pstm = conn.prepareStatement(sql);
//            pstm.setString(1,sno);
//            rs = pstm.executeQuery();
//            while(rs.next()){
//                String ssno = rs.getString("学号");
//                if(sno.equals(ssno)){
//                    textField_sno.setText(rs.getString("学号"));
//                    textField_sname.setText( rs.getString("姓名"));
//                    textField_sex.setText(rs.getString("性别"));
//                    textField_birthday.setText(rs.getString("生日"));
//                    textField_phone.setText(rs.getString("电话"));
//                    textField_address.setText(rs.getString("地址"));
//                }
//            }
//            JOptionPane.showMessageDialog(null,"查询成功");
//        } catch (SQLException throwables) {
//            JOptionPane.showMessageDialog(null,"查询失败");
//            throwables.printStackTrace();
//            Utils.close(pstm,conn,rs);
//        }
//    }
//
//    //重置
//    private void reset(JTextField textField_sno,JTextField textField_sname,JTextField textField_sex,JTextField textField_birthday,JTextField textField_phone,JTextField textField_address){
//        textField_sno.setText("");
//        textField_sname.setText("");
//        textField_sex.setText("");
//        textField_birthday.setText("");
//        textField_phone.setText("");
//        textField_address.setText("");
//    }
}
