package view;

import media.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.ImageObserver;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuPanel menuPanel;
	private Dimension dim;

	public MainPanel(Dimension dim) {
		super();
		this.setLayout(null);
		menuPanel = new MenuPanel(this, dim);
		menuPanel.setVisible(true);
		this.dim = dim;
		this.add(menuPanel);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int height = g.getClipBounds().height;
		int width = g.getClipBounds().width;
		g2.drawImage(Images.getBackgroundImage(), 0, 0, width, height, null);
	}
}
