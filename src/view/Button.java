package view;

import media.Fonts;
import media.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Implementation of the button play, to start the game
public class Button extends JButton implements MouseListener {
    /**
     *
     */
    private static final long serialVersionUID = -3174421930254768959L;
    private Color bc, foregroundColor;
    private boolean clicked, entered;
    private String text;
    private int x, y;

    public Button() {
        super();
        this.bc = Color.WHITE;
    }

    public Button(String text, int x, int y) {

    }

    public Button(String text) {
        super(text, Images.getWoodImage());
//        this.text = text;
//        this.x = x;
//        this.y = y;
//        this.foregroundColor = Color.black;
//        this.setBounds(this.x, this.y, 300, 100);
        this.setBackground(new Color(150, 0, 0, 0));
        this.setContentAreaFilled(false);
        this.setFont(Fonts.getBlueberryFont());
        this.setHorizontalTextPosition(0);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setOpaque(false);
        this.repaint();
        this.setVisible(true);
    }

    public void setBackground(Color bc) {
        this.bc = bc;
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
////        g2.drawImage(Images.getWoodImage(), this.x, this.y, 300, 100, null);
//        g2.setColor(foregroundColor);
//        g2.drawString(this.text, 150 - text.length() / 2, 100);
//    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        clicked = true;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        clicked = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        entered = true;
//        repaint();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        entered = false;
//        repaint();
//        this.paintComponent(this.getGraphics());
//        this.revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0, 0, 0, 0));
//        g2.fillRect(this.x, this.y, Images.getWoodImage().getIconWidth(), Images.getWoodImage().getIconHeight());

    }

    public boolean isClicked() {
        return clicked;
    }
}
