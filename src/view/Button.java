package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JLabel implements MouseListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3174421930254768959L;
	private Color bc, foregroundColor;
    private boolean clicked;
    private String text;
    private int x, y;

    public Button() {
        super();
        this.bc = Color.WHITE;
    }

    public Button(int x, int y, String text) {
        super();
        this.text = text;
        this.x = x;
        this.y = y;
        this.bc = Color.white;
        this.foregroundColor = Color.black;
        this.setLocation(x, y);
        this.setBounds(x, y, 200, 100);
        this.enableInputMethods(true);
        this.addMouseListener(this);
        this.setFocusable(true);
    }


    public Button(Color bc) {
        this.bc = bc;
    }

    public Button(String text, Color bc) {
        this(text);
        this.bc = bc;
    }

    public Button(String text) {
        this.text = text;
        this.bc = Color.white;
    }

    public void setBackground(Color bc) {
        this.bc = bc;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(bc);
        g2.fillRoundRect(x, y, 200, 100, 100, 100);
        Color tmp = new Color(bc.getRed(), bc.getGreen(), bc.getBlue(), 150);
        g2.setColor(tmp);
        g2.fillRoundRect(x - 5, y - 5, 210, 110, 100, 100);
        g2.setColor(foregroundColor);
        Font font = new Font("Serif", Font.PLAIN, 35);
        g2.setFont(font);
        g2.drawString(text, x + 55, y + 60);
		System.out.println("resized");
    }


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

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public boolean isClicked() {
        return clicked;
    }
}
