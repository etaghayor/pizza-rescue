package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import media.Colors;
import media.Fonts;
import media.Images;

public class MenuPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 440684360807810628L;
    private final MainPanel mainPanel;
    private Dimension dim;
    private boolean entered = false, clicked = false;
    //    private Button playButton, exitButton;
    private JButton playButton, exitButton, aboutUsButton;

    private static final int XMOVE = 10, YMOVE = 10;

    public MenuPanel(MainPanel mainPanel, Dimension dim) {
        super();
        this.mainPanel = mainPanel;
        this.dim = dim;
        init();
    }

    // Initialize the playButton and see if it is clicked, and if the button is clicked
    // display the MainPanel (the game)
    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(dim);
        this.setOpaque(false);

        playButton = makeButton("Play!");

        MenuPanel mp = this;
        playButton.addMouseListener(new MouseListener() {
            private MenuPanel menuPanel;

            {
                menuPanel = mp;
            }

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                playButton.setForeground(Color.BLACK);
                playButton.repaint();
                mainPanel.removeAll();

                mainPanel.add(new LevelsPanel(mainPanel, menuPanel, dim));
                mainPanel.repaint();
                mainPanel.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                playButton.setForeground(Color.BLACK);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                playButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                playButton.setForeground(Colors.B_GRAY);

            }
        });

        aboutUsButton = makeButton("About Us");

        aboutUsButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                aboutUsButton.setForeground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                aboutUsButton.setForeground(Colors.B_GRAY);
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                aboutUsButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                aboutUsButton.setForeground(Colors.B_GRAY);

            }
        });


        exitButton = makeButton("Exit");
        exitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
//                exitButton.setBackground(Colors.TRANSPARENT);
                exitButton.setForeground(Color.BLACK);
                exitButton.repaint();
                System.out.println("why");
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                exitButton.setForeground(Color.BLACK);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                exitButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                exitButton.setForeground(Colors.B_GRAY);

            }
        });

        this.add(Box.createRigidArea(new Dimension(250, 350)));
        this.add(playButton);

        this.add(Box.createRigidArea(new Dimension(250, 50)));
        this.add(aboutUsButton);

        this.add(Box.createRigidArea(new Dimension(250, 200)));
        this.add(exitButton);


        this.validate();

    }

    private JButton makeButton(String text) {
        JButton b = new JButton(text, Images.getWoodImage());
        b.setPreferredSize(new Dimension(Images.getWoodImage().getIconWidth(), Images.getWoodImage().getIconHeight()));
        b.setContentAreaFilled(false);
        b.setForeground(Colors.B_GRAY);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        b.setBorder(emptyBorder);
        b.setHorizontalTextPosition(SwingConstants.CENTER);
        b.setVerticalTextPosition(SwingConstants.CENTER);
        b.setFont(Fonts.getBlueberryFont());
        return b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }

}
