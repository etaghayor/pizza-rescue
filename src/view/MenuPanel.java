package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;

import media.Colors;
import media.Fonts;
import media.Images;
import model.Player;

public class MenuPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 440684360807810628L;
    private final MainPanel mainPanel;
    private Dimension dim;
    private boolean entered = false, clicked = false;
    //    private Button playButton, exitButton;
    private JButton playButton, exitButton, aboutUsButton, resetButton;

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
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setSize(dim);
        this.setOpaque(false);


        resetButton = makeButton("Reset");
        resetButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                resetButton.setForeground(Color.BLACK);
                // TODO delete user Files
                File userData = new File("user/player_data");
                if (userData.exists()) {
                    if (userData.delete())
                        System.out.println("game has been reset!");
                    else
                        System.out.println("can't reset");
                }

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                resetButton.setForeground(Color.WHITE);

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                resetButton.setForeground(Colors.B_GRAY);

            }
        });

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
                Player player = new Player();
                mainPanel.add(new LevelsPanel(mainPanel, menuPanel, dim, player));
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


//        this.add(Box.createRigidArea(new Dimension(450, 50)));
//        JPanel resetContainer = new JPanel();
//        resetContainer.setOpaque(false);
//        resetContainer.setLayout(new BoxLayout(resetContainer, BoxLayout.X_AXIS));
////        resetButton.setBounds( 120, 120);
//        resetContainer.add(Box.createRigidArea(new Dimension((int) dim.getWidth() - 150, 20)));
//        resetContainer.add(resetButton);
//        resetContainer.setBounds(0, 0, (int) dim.getWidth(), 50);
//        this.add(resetContainer);

        this.add(Box.createRigidArea(new Dimension(300, 200)));
        this.add(resetButton);

        this.add(Box.createRigidArea(new Dimension(250, 50)));
        this.add(playButton);

        this.add(Box.createRigidArea(new Dimension(250, 50)));
        this.add(aboutUsButton);

        this.add(Box.createRigidArea(new Dimension(250, 200)));
        this.add(exitButton);


        this.validate();

    }

    private JButton makeButton(String text) {
        JButton b;
        if (text.equals("Reset"))
            b = new JButton(text, Images.getSmallWoodIcon());
        else
            b = new JButton(text, Images.getWoodIcon());
        b.setPreferredSize(new Dimension(Images.getWoodIcon().getIconWidth(), Images.getWoodIcon().getIconHeight()));
        b.setForeground(Colors.B_GRAY);
        b.setContentAreaFilled(false);
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
