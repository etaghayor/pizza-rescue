package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import media.Images;

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 440684360807810628L;
	Button playButton;
	MainPanel mainPanel;
	private Dimension dim;

	public MenuPanel(MainPanel mainPanel, Dimension dim) {
		super();
		this.mainPanel = mainPanel;
		this.dim = dim;
		init();
	}

	private void init() {
		this.setLayout(null);
		this.setSize(dim);
		this.setOpaque(false);
		playButton = new Button(270,500,"Play!");
		playButton.setAlignmentX(RIGHT_ALIGNMENT);
		
		Color bc = Color.white;
		Color tmp = new Color(bc.getRed(), bc.getGreen(), bc.getBlue(), 150);
		playButton.setBackground(tmp);
         

		playButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				mainPanel.removeAll();
				mainPanel.revalidate();

				mainPanel.add(new GamePanel(dim));
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

			}

			@Override
			public void mouseExited(MouseEvent mouseEvent) {

			}
		});
		this.add(playButton);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		playButton.paintComponent(g);
		

	}
////        playButton.paint(g);
//        playButton.addActionListener(event -> {
//            System.out.println("clicked");
//            mainPanel.removeAll();
//            mainPanel.repaint();
//            mainPanel.revalidate();
//        });
////        playButton.paintComponent(g);
////        playButton.addActionListener(e -> {
////            System.out.println("clicked");
////            mainPanel.remove(this);
////            mainPanel.repaint();
////            mainPanel.revalidate();
////        });
//    }

}
