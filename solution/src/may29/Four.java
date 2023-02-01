package may29;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Four {
    private JPanel root;
    private JButton lastButton;
    private JButton nextButton;
    private JPanel imglabel;
    private JLabel label;
    private static int count = 0;
    public Four() {
        ImageIcon []icon =new ImageIcon[10];
        for (int i = 1; i <= 10; i++){
            icon[i-1] = new ImageIcon("img/"+i+".png");
        }
        label.setIcon(icon[0]);
        lastButton.setEnabled(false);
        //上一张
        lastButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                count--;
                label.setIcon(icon[count]);
                if (count == 0){
                    lastButton.setEnabled(false);
                }else {
                    nextButton.setEnabled(true);
                }
            }
        });
        //下一张
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                label.setIcon(icon[count]);
                if (count == 9){
                    nextButton.setEnabled(false);
                }else {
                    lastButton.setEnabled(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Four");
        frame.setContentPane(new Four().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,500);
        frame.setVisible(true);
    }
}
