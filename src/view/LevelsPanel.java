package view;

import controller.Game;
import media.Colors;
import media.Fonts;
import media.Images;
import model.Player;
import model.Time;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LevelsPanel extends JPanel {
    private final Dimension dim;
    private final MainPanel mainPanel;
    private final JButton[] levels = new JButton[11];
    private int index;
    private boolean c;
    private final Player player;

    public LevelsPanel(MainPanel mainPanel, Player player) {
        super();
        this.mainPanel = mainPanel;
        this.dim = mainPanel.getDim();
        this.player = player;
        init();
    }

    private void init() {

        this.setLayout(null);
        this.setSize(dim);
        this.setOpaque(false);
        LevelsPanel lp = this;
        for (int i = 1; i < 11; i++) {
            levels[i] = makeButton((i) + "");
            index = i;
            c = index <= player.getLastLevel();
            levels[i].addMouseListener(new MouseListener() {
                private final int myIndex;
                private final LevelsPanel levelsPanel;
                private final boolean clickable;

                {
                    this.myIndex = index;
                    this.levelsPanel = lp;
                    this.clickable = c;
                }

                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    if (clickable) {
                        levels[myIndex].setForeground(Color.BLACK);
                        Player player = new Player();

                        int playersLastLife = player.getLife();
                        int l = Time.calcAddableLife();
//                        System.out.println(l + " lives should be added");
                        player.updateLife(playersLastLife + l);
                        if (playersLastLife < player.getLife())
                            Time.serializeTime();

                        if (player.getLife() < 1) {
                            JOptionPane.showMessageDialog(null, "You can't play with 0 lives!");
                        } else {
                            mainPanel.removeAll();
                            new Game(mainPanel, myIndex, player);
                            mainPanel.repaint();
                            mainPanel.revalidate();
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
                    if (clickable)
                        levels[myIndex].setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    if (clickable)
                        levels[myIndex].setForeground(Colors.B_GRAY);

                }
            });
            this.add(levels[index]);
        }
        levels[1].setBounds(400, 100, 70, 70);
        levels[2].setBounds(410, 200, 70, 70);
        levels[3].setBounds(430, 300, 70, 70);
        levels[4].setBounds(450, 400, 70, 70);
        levels[5].setBounds(475, 500, 70, 70);
        levels[6].setBounds(465, 600, 70, 70);
        levels[7].setBounds(380, 660, 70, 70);
        levels[8].setBounds(280, 690, 70, 70);
        levels[9].setBounds(180, 740, 70, 70);
        levels[10].setBounds(80, 760, 70, 70);

        initOptionBar();

    }

    private void initOptionBar() {
        OptionPanel op = new OptionPanel();
        op.setBounds(0, 0, 250, 250);
        op.setVisible(true);
        op.getBackButton().addActionListener(actionEvent -> {
            mainPanel.removeAll();
            mainPanel.add(new MenuPanel(mainPanel));
            mainPanel.repaint();
            mainPanel.revalidate();
        });
        this.add(op);
    }


    private JButton makeButton(String text) {
        JButton b;
        if (Integer.parseInt(text) > player.getLastLevel())
            b = new JButton(text, Images.getGreyWoodLevelIcon());
        else
            b = new JButton(text, Images.getWoodLevelIcon());
        b.setContentAreaFilled(false);
        b.setForeground(Colors.B_GRAY);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        b.setBorder(emptyBorder);
        b.setHorizontalTextPosition(SwingConstants.CENTER);
        b.setVerticalTextPosition(SwingConstants.CENTER);
        b.setFont(Fonts.getCevicheFont());
        return b;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

    }
}
