package view;

import javax.swing.*;
import java.awt.*;

import media.Images;


public class GamePanel extends JPanel {
    public GamePanel() {
        super();
        Dimension dimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimMax);
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(Images.getBackgroundImage(), 0, 0, null);

    }
}
