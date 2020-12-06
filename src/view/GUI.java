package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;

import controleur.PetRescue;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private PetRescue controleur;
	JButton restart = new JButton("restart");
	JToolBar northComponent = new JToolBar();
	JScrollPane westComponent = new JScrollPane(new JTree());
	JToolBar southComponent = new JToolBar();
	JLabel score = new JLabel("Score ");
	JLabel realScore = new JLabel("0");
	JLabel pets = new JLabel("Pets");
	JLabel realPets = new JLabel("0/5");
	JLabel etoiles = new JLabel("Etoiles");
	JLabel realEtoiles = new JLabel("0/3");
	
	

		public GUI(PetRescue c) {
			controleur = c;
			setTitle("Pet Rescue Saga Game");
			setSize(900,600);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
			
			JPanel contentPane = (JPanel) getContentPane();
			
			contentPane.add(southComponent, BorderLayout.SOUTH);
			contentPane.add(westComponent, BorderLayout.WEST);		
			contentPane.add(northComponent, BorderLayout.NORTH);
			
			southComponent.add(restart, BorderLayout.NORTH);
			southComponent.setPreferredSize(new Dimension(0, 60));
			
			JLabel imgJLabel = new JLabel();
			imgJLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			//imgJLabel.setIcon(new ImageIcon(View.class.getResource("/media/tomate.jpg")));
			contentPane.add(imgJLabel, BorderLayout.CENTER);
			
			northComponent.add(pets, BorderLayout.NORTH);
			northComponent.add(realPets, BorderLayout.NORTH);
			northComponent.add(score, BorderLayout.NORTH);
			northComponent.add(realScore, BorderLayout.NORTH);
			northComponent.add(etoiles, BorderLayout.NORTH);
			northComponent.add(realEtoiles, BorderLayout.NORTH);
			northComponent.setPreferredSize(new Dimension(0, 100));
			
			

		}
}

