package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import media.Images;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;


    public GUI() {
        init();

    }

    // Initialize the window and add the mainPanel to it
    private void init() {
        this.setTitle("Pizza Rescue Saga Game");
        Dimension dim = new Dimension(Images.getBackgroundImage().getWidth(null), Images.getBackgroundImage().getHeight(null));
        this.setPreferredSize(dim);
        this.setSize(dim);
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenDim.width / 2 - this.getSize().width / 2, screenDim.height / 2 - this.getSize().height / 2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainPanel mainPanel = new MainPanel(dim);
        this.getContentPane().add(mainPanel);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
       
    }
}

