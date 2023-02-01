package may29;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Six {
    private JPanel root;
    private static int count = 0;
    private static int[] xy;
    public Six() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Six");
        frame.setContentPane(new Six().root);
        xy = new int[2];
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {//鼠标点击监听事件
                if (count == 0){
                    xy[0] = e.getX();
                    xy[1] = e.getY();
                    count++;
                }else if (count == 1){
                    count = 0;
                    double distance
                            = Math.sqrt((xy[0]-e.getX())*(xy[0]-e.getX())+(xy[1]-e.getY())*(xy[1]-e.getY()));
                    JOptionPane.showMessageDialog(frame,
                            "两次点击的距离是："+distance,
                            "距离",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
