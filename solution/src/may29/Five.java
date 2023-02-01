package may29;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Five {
    private JPanel panel1;
    private JLabel label;
    private JFrame jFrame;
    private static int count = 0;

    public Five(JFrame jFrame) {

        ImageIcon []icon =new ImageIcon[10];
        for (int i = 1; i <= 10; i++){
            icon[i-1] = new ImageIcon("img/"+i+".png");
        }
        label.setIcon(icon[0]);
        jFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {//键盘按压事件
                int keyboard = e.getKeyCode();
                if (keyboard == 38){//如果按下了上键
                    count++;
                    if (count > 9){
                        count = 0;
                    }
                    label.setIcon(icon[count]);
                }else if (keyboard == 40){//如果按下了下键
                    count--;
                    if (count < 0){
                        count = 9;
                    }
                    label.setIcon(icon[count]);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Five(frame).panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
