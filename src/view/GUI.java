package view;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;

import controleur.PetRescue;
import media.Images;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private PetRescue controleur;
    JButton restart = new JButton("restart");
    JToolBar northComponent = new JToolBar();
    JScrollPane westComponent = new JScrollPane(new JTree());
    JToolBar southComponent = new JToolBar();
    JLabel score = new JLabel("Score ");
    JLabel realScore = new JLabel("0");
    JLabel pets = new JLabel("Pets");
    JLabel realPets = new JLabel("0/5");
    JLabel etoiles = new JLabel("Etoiles");
    JLabel realEtoiles = new JLabel("0/3");


    public GUI(PetRescue c) {

        this.controleur = c;
        init();


    }

    private void init() {
        this.setTitle("Pet Rescue Saga Game");
        Dimension dim = new Dimension(Images.getBackgroundImage().getWidth(null), Images.getBackgroundImage().getHeight(null));
        this.setPreferredSize(dim);
        this.setSize(dim);
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(this.getSize());
        this.setLocation(screenDim.width / 2 - this.getSize().width / 2, screenDim.height / 2 - this.getSize().height / 2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainPanel mainPanel = new MainPanel(dim);
        this.getContentPane().add(mainPanel);
        this.pack();
        this.setVisible(true);
    }
}

