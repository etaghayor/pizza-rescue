package view;

import controller.Game;
import media.Colors;
import media.Fonts;
import media.Images;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LevelsPanel extends JPanel {
    private int LastLevel = 0;
    private final Dimension dim;
    private MainPanel mainPanel;
    private MenuPanel menuPanel;
    private final JButton[] levels = new JButton[10];
    private int index;

    public LevelsPanel(MainPanel mainPanel, MenuPanel menuPanel, Dimension dim) {
        super();
        this.mainPanel = mainPanel;
        this.menuPanel = menuPanel;
        this.dim = dim;
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setSize(dim);
        this.setOpaque(false);
        LevelsPanel lp = this;
//        this.add(Box.createRigidArea(new Dimension(200, 100)));
        for (int i = 0; i < 10; i++) {
//            this.add(Box.createRigidArea(new Dimension(250, 30)));
            levels[i] = makeButton((i) + "");
            index = i;
            levels[i].addMouseListener(new MouseListener() {
                private int myIndex;
                private LevelsPanel levelsPanel;

                {
                    this.myIndex = index;
                    this.levelsPanel = lp;
                }

                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    levels[myIndex].setForeground(Color.BLACK);
                    mainPanel.removeAll();
//                    mainPanel.add(new GamePanel(mainPanel, levelsPanel, dim));
                    new Game(mainPanel, levelsPanel, myIndex, null);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    levels[myIndex].setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    levels[myIndex].setForeground(Colors.B_GRAY);

                }
            });
            this.add(levels[index]);
        }
        levels[0].setBounds(400, 100, 70, 70);
        levels[1].setBounds(410, 200, 70, 70);
        levels[2].setBounds(430, 300, 70, 70);
        levels[3].setBounds(450, 400, 70, 70);
        levels[4].setBounds(475, 500, 70, 70);
        levels[5].setBounds(465, 600, 70, 70);
        levels[6].setBounds(380, 660, 70, 70);
        levels[7].setBounds(280, 690, 70, 70);
        levels[8].setBounds(180, 740, 70, 70);
        levels[9].setBounds(80, 760, 70, 70);

        initOptionBar();

    }

    private void initOptionBar() {
        OptionPanel op = new OptionPanel();
        op.setBounds(0, 0, 250, 250);
        op.setVisible(true);
        op.getBackButton().addActionListener(actionEvent -> {
            mainPanel.removeAll();
            mainPanel.add(menuPanel);
            mainPanel.repaint();
            mainPanel.revalidate();
        });
        this.add(op);
    }

    private JButton makeButton(String text) {
        JButton b = new JButton(text, Images.getWoodLevelIcon());
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
