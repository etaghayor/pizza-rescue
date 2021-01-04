package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Timer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

import media.Colors;
import media.Fonts;
import media.Images;
import model.Player;
import model.Player.Life;

public class MenuPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 440684360807810628L;
    private final MainPanel mainPanel;
    private final Dimension dim;
    private final boolean entered = false;
    private final boolean clicked = false;
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
//        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setLayout(null);
        this.setSize(dim);
        this.setOpaque(false);


        resetButton = makeButton("Reset");
        resetButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                resetButton.setForeground(Color.BLACK);
                String[] options = {"Yes!", "Cancel"};
                int option = JOptionPane.showOptionDialog(null, "Are you sure you want to reset? You will lose all your data.",
                        "Reset Data", 0, JOptionPane.PLAIN_MESSAGE, Images.getAvocadoImage(), options, options[0]);
                if (option == 0) {

                    File userData = new File("user/player_data");
                    if (userData.exists()) {
                        if (userData.delete())
                            System.out.println("game has been reset!");
                        else
                            System.out.println("can't reset");
                    }
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
            private final MenuPanel menuPanel;

            {
                menuPanel = mp;
            }

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                playButton.setForeground(Color.BLACK);
                playButton.repaint();
                mainPanel.removeAll();
                Player player = new Player();
                	if (new File("user/player_data").exists()) 
                		player = Player.deserialize();
                	 else
                	player = new Player(); 
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
            MenuPanel menuPanel;

            {
                this.menuPanel = mp;
            }

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
//                aboutUsButton.setForeground(Color.BLACK);
                mainPanel.removeAll();
                mainPanel.add(new AboutUsWindow(mainPanel, menuPanel));
                mainPanel.revalidate();
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


        resetButton.setBounds((int) dim.getWidth() - 140, 20, 120, 120);
        this.add(resetButton);

        playButton.setBounds((int) dim.getWidth() / 2 - 150, 400, 300, 100);
        this.add(playButton);

        aboutUsButton.setBounds((int) dim.getWidth() / 2 - 150, 550, 300, 100);
        this.add(aboutUsButton);

        exitButton.setBounds((int) dim.getWidth() / 2 - 150, 870, 300, 100);
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
