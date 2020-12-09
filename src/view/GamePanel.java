package view;

import javax.swing.*;
import java.awt.*;

import media.Images;


public class GamePanel extends JPanel {

    private MainPanel mainPanel;
    private Dimension dim;

    public GamePanel(MainPanel mainPanel, Dimension dim) {
        super();
        this.mainPanel = mainPanel;
        this.dim = dim;
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setLayout(null);
        this.setSize(dim);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

    }
}
