package mm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        new Fr();
    }

}
class Fr extends JFrame implements ActionListener {
    JLabel mes1 = new JLabel("输入身高（米）");
    JTextField shengao=new JTextField(10);
    JLabel mes2=new JLabel("输入体重（千克）");
    JTextField tizhong=new JTextField(10);
    JButton jisuan=new JButton("计算");
    JButton chongzhi=new JButton("重置");
    JLabel result=new JLabel("");
    Fr() {
        this.setLayout(new FlowLayout());
        this.setSize(800, 800);
        this.add(mes1);
        this.add(shengao);
        this.add(mes2);
        this.add(tizhong);
        this.add(jisuan);
        this.add(chongzhi);
        this.add(result);


        jisuan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    double sg =  Double.parseDouble(shengao.getText());
                    double tz = Double.parseDouble(tizhong.getText());
                    double bmi = tz / (sg * sg);
                    result.setText("bmi值：" + new DecimalFormat("0.0").format(bmi) + panduan(bmi));
                }catch (Exception exception) {
                    result.setText("输入格式错误");
                }
            }
        });
        chongzhi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shengao.setText("");
                tizhong.setText("");
                result.setText("");
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    String panduan(double bmi) {
        if (bmi <= 18.5) {
            return "过轻";
        }
        if (bmi <= 24) {
            return "正常";
        }
        if (bmi <28) {
            return "过重";
        }
        if (bmi < 32) {
            return "肥胖";
        }
        return "重度肥胖";
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}