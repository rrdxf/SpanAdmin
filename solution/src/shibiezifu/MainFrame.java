package shibiezifu;


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



public class MainFrame extends JFrame{
    protected static File nowfile=null;
    private JFrame frame;
    private JScrollPane jsp;
    private DefaultTableModel dtm;
    private DefaultTableCellRenderer dtr;
    private JTextField input;

    private Vector v;
    private JButton save;
    private JButton load;
    private JButton delete;
    private JButton find;
    private JButton add;
    private JPanel contentPane;

    public static void main(String[] args) throws IOException {

        new MainFrame();
    }

    //创建学生表格
    public MainFrame(){
        frame = new JFrame();
        frame.setTitle("语法分析器");
        frame.setPreferredSize(new Dimension(500, 500));
        dtm = new DefaultTableModel();
        dtr = new DefaultTableCellRenderer();
        dtr.setHorizontalAlignment(JLabel.CENTER);
        input = new JTextField(10);
        JTextArea jta = new JTextArea(10,10);
        input.setBounds(10,10,10,10);

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
                List<String>list;
                int[] type=new int[6];
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //如果符合文件类型
                    String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
                    nowfile=new File(filepath);
                    System.out.println(filepath);
                    System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());  //输出相对路径
                    try {
                        list= IOUtils.GetStrFromFile(filepath);
                        for (String s:list){
                            if (!s.equals(""))
                            switch (JugeUtils.jugeType(s)){
                                case shibiezifu.Type.NUM:type[1]++;break;
                                case shibiezifu.Type.KEYWORD:type[2]++;break;
                                case shibiezifu.Type.IDENTIFIER:type[3]++;break;
                                case shibiezifu.Type.OPERATOR:type[4]++;break;
                                case shibiezifu.Type.BORDER:type[5]++;break;
                            }
                        }
                        new OutDialog(type).setVisible(true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        //删除按钮

        //修改按钮
        find=new JButton("识别字符");
        find.setBounds(300,200,97,23);
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cenet=jta.getText();
                System.out.println(cenet);
                List<String> list=new ArrayList<>();
                int[] type=new int[6];
                String [] ss=cenet.split("\n");
                for (String s1:ss){
                    String [] ss1 =s1.split(" ");
                    for (String s:ss1){
                        if (!s.equals(""))
                            list.add(s);
                    }
                }
                for (String s:list){
                    if (!s.equals(""))
                        switch (JugeUtils.jugeType(s)){
                            case shibiezifu.Type.NUM:type[1]++;break;
                            case shibiezifu.Type.KEYWORD:type[2]++;break;
                            case shibiezifu.Type.IDENTIFIER:type[3]++;break;
                            case shibiezifu.Type.OPERATOR:type[4]++;break;
                            case shibiezifu.Type.BORDER:type[5]++;break;
                        }
                }
                new OutDialog(type).setVisible(true);
            }
        });
        //修改按钮

        //新加代码
        JPanel panel=new JPanel();
        panel.add(load);
        panel.add(find);
        jsp = new JScrollPane();
        //jsp.setViewportView(input);

        frame.add(panel,BorderLayout.SOUTH);

        frame.add(jta);
        //frame.getContentPane().add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

}
