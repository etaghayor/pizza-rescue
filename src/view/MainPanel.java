package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import media.Images;

public class MainPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public MenuPanel menuPanel;
    private Dimension dim;

    //Call the menuPanel
    public MainPanel(Dimension dim) {
        super();
        this.setLayout(new BorderLayout());
        this.setOpaque(true);
        this.setVisible(true);
        this.dim = dim;
        menuPanel = new MenuPanel(this);
        menuPanel.setVisible(true);
        this.add(menuPanel);

    }

    // Set the background image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
//        int height = g.getClipBounds().height;
//        int width = g.getClipBounds().width;
        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();
        g2.drawImage(Images.getBackgroundImage(), 0, 0, width, height, null);
    }

    public Dimension getDim() {
        return dim;
    }
}
