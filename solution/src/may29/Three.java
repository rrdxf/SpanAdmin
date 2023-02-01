package may29;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Three  {
    private static int count = 1;
    private JPanel root;
    private JButton actbutton;
    private JButton outbutton;
    private JTextArea textArea1;
    private JTextField textField3;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel sign;

    public Three() {
        textField1.setEditable(false);
        textField2.setEditable(false);
        //确认按钮监听时间
        actbutton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int a = Integer.valueOf(textField1.getText());
                int b = Integer.valueOf(textField2.getText());
                int c = Integer.valueOf(textField3.getText());
                StringBuilder res = new StringBuilder();
                res.append(textArea1.getText());
                if (c == (a+b)){
                    sign.setText("恭喜你答对了！");
                    res.append("("+count+") "+a+"+"+b+"="+(a+b)+" √\n");
                }else {
                    sign.setText("很遗憾你答错了~");
                    res.append("("+count+")"+a+"+"+b+"="+c+" ×\n");
                }
                count++;
                textArea1.setText(res.toString());
            }
        });

        //出题按钮监听事件
        outbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int a=random.nextInt(100+1);
                int b= random.nextInt(100+1);
                textField1.setText(String.valueOf(a));
                textField2.setText(String.valueOf(b));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Three");
        frame.setContentPane(new Three().root);
        frame.addWindowListener(new WindowAdapter() {//设置窗口关闭事件


            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null,
                        "是否关闭?",
                        "提示",JOptionPane.YES_NO_OPTION);//返回的是按钮的index  i=0或者1
                if (n == 0){
                    super.windowClosing(e);
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

    }
}
