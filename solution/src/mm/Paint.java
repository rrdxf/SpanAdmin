package mm;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Paint extends JFrame   {
    public static void main(String[] args) {
        Paint paint=new Paint();
    }

    JPanel jPanel=new JPanel();
    public Paint() {
        setSize(800, 800);
        setVisible(true);
        setTitle("楼");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(jPanel,BorderLayout.SOUTH);
        Cartoon cartoon=new Cartoon();
        add(cartoon);
        validate();
    }
    class Cartoon extends JPanel {
        Cartoon() {
            setSize(800, 850);
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(0, 0, 128));
            g.fillRect(0, 0, 800, 800);

            // 第一幢
            g.setColor(new Color(0,0,0));
            g.fillRect(3,400, 50, 400);
            // 窗户
            for (int i = 0; i < 35; ++i) {
                for (int j = 0; j < 6; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,215,0));
                        g.fillRect(7 + j * 8,750 - i * 10, 5, 5);
                    }
                }
            }

            // 第二幢
            g.setColor(new Color(0,0,0));
            g.fillRect(60,200, 80, 600);
            g.setColor(new Color(0,0,0));
            g.fillRect(160,200, 80, 600);
            g.setColor(new Color(0,0,0));
            g.fillRect(100,300, 80, 30);
            // 窗户
            for (int i = 0; i < 55; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,215,0));
                        g.fillRect(65 + j * 8,750 - i * 10, 5, 5);
                    }
                }
            }
            for (int i = 0; i < 55; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,215,0));
                        g.fillRect(165 + j * 8,750 - i * 10, 5, 5);
                    }
                }
            }

            g.setColor(new Color(0,0,0));
            g.fillRect(300,240, 80, 560);
            for (int i = 0; i < 51; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,215,0));
                        g.fillRect(305 + j * 8,750 - i * 10, 5, 5);
                    }
                }
            }

            g.setColor(new Color(0,0,0));
            g.fillRect(400,270, 80, 530);
            for (int i = 0; i < 48; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,215,0));
                        g.fillRect(405 + j * 8,750 - i * 10, 5, 5);
                    }
                }
            }

            g.setColor(new Color(0,0,0));
            g.fillRect(500,170, 70, 630);
            for (int i = 0; i < 58; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,215,0));
                        g.fillRect(505 + j * 8,750 - i * 10, 5, 5);
                    }
                }
            }

            g.setColor(new Color(0,0,0));
            g.fillRect(600,370, 90, 430);
            for (int i = 0; i < 38; ++i) {
                for (int j = 0; j < 10; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,215,0));
                        g.fillRect(605 + j * 8,750 - i * 10, 5, 5);
                    }
                }
            }

            g.setColor(new Color(0,0,0));
            g.fillRect(700,470, 90, 330);
            for (int i = 0; i < 28; ++i) {
                for (int j = 0; j < 10; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,215,0));
                        g.fillRect(705 + j * 8,750 - i * 10, 5, 5);
                    }
                }
            }

            // 近处房屋
            g.setColor(new Color(0,0,0));
            g.fillRect(400,380, 200, 420);
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 5; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,255,0));
                        g.fillRect(415 + j * 35,720 - i * 35, 20, 20);
                    }
                }
            }


            g.setColor(new Color(0,0,0));
            g.fillRect(180,300, 180, 500);
            for (int i = 0; i < 12; ++i) {
                for (int j = 0; j < 5; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,255,0));
                        g.fillRect(185 + j * 35,720 - i * 35, 20, 20);
                    }
                }
            }

            g.setColor(new Color(0,0,0));
            g.fillRect(680,570, 180, 230);
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    if (new java.util.Random().nextBoolean()){
                        g.setColor(new Color(255,255,0));
                        g.fillRect(685 + j * 35,720 - i * 35, 20, 20);
                    }
                }
            }

            // 月亮
            g.setColor(new Color(255,250,205));
            g.fillOval(650, 40, 100, 100);
            g.setColor(new Color(0, 0, 128));
            g.fillOval(620, 30, 100, 100);

            // 星星
            g.setColor(new Color(255,255,255));
            for (int i = 0; i < 100; ++i){
                g.fillOval(new Random().nextInt(800 + 1), new Random().nextInt(200 + 1), 2, 2);
            }
        }
    }
}