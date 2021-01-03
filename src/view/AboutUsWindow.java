package view;

import media.Colors;
import media.Fonts;
import media.Images;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AboutUsWindow extends JPanel {
    private MenuPanel menuPanel;
    private MainPanel mainPanel;
    private Dimension dim;

    public AboutUsWindow(MainPanel mainPanel, MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        this.mainPanel = mainPanel;
        this.dim = mainPanel.getDim();
        init();
    }

    private void init() {


        this.setOpaque(false);
        this.setLayout(null);
        repaint();


        JButton ok = new JButton("OK", Images.getSmallWoodIcon());
        ok.setBackground(Colors.TRANSPARENT);
        ok.setFont(Fonts.getBlueberryFont());
        ok.setContentAreaFilled(false);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        ok.setBorder(emptyBorder);
        ok.setHorizontalTextPosition(SwingConstants.CENTER);
        ok.setVerticalTextPosition(SwingConstants.CENTER);
        ok.setForeground(Colors.B_GRAY);
        ok.setBounds((int) dim.getWidth() / 2 - 60, 850, 120, 120);

        ok.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                ok.setForeground(Color.BLACK);
                mainPanel.removeAll();
                mainPanel.add(menuPanel);
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
                ok.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                ok.setForeground(Colors.B_GRAY);
            }
        });

        this.add(ok);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Colors.TRANS_GREEN);
        g2.fillRoundRect((int) dim.getWidth() / 2 - 350, 100, 700, 720, 100, 100);
        g2.drawImage(Images.getAboutUsTextImage(), (int) dim.getWidth() / 2 - 320, 150, null);
    }
}
