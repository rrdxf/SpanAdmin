package swingtable;

import javax.swing.*;
import java.awt.*;

public class DemoDialog extends JDialog {
    DemoDialog(String content){
        this.setTitle("Dialog弹窗");
        this.setVisible(true);
        this.setLocation(200,200);
        this.setSize(200,250);
        //add one label
        Container contentPane = this.getContentPane();
        JLabel jLabel = new JLabel(content);
        contentPane.add(jLabel);
        //center 居中
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
