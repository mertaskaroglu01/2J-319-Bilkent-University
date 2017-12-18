package UserInterface;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPanel extends JPanel {
	
	JButton btnHelpBack;
	JLabel player1;
	JLabel player2;
	JLabel ctrl1;
	JLabel ctrl2;
	
	/**
	 * Create the panel.
	 */
	public HelpPanel() {
		setVisible(true);
		
		ImageIcon back = new ImageIcon("pictures/back.png");
		ImageIcon controls1 = new ImageIcon("pictures/controls1.png");
		ImageIcon controls2 = new ImageIcon("pictures/controls2.png");
		ImageIcon arrows = new ImageIcon("pictures/arrows.png");
		ImageIcon wasd = new ImageIcon("pictures/wasd.png");
		
		this.setLayout(new GridLayout(3,2) );
		
		player1 = new JLabel();
		player2 = new JLabel();
		ctrl1 = new JLabel();
		ctrl2 = new JLabel();
		
		player1.setIcon(controls1);
		player2.setIcon(controls2);
		ctrl1.setIcon(arrows);
		ctrl2.setIcon(wasd);
		
		player1.setHorizontalAlignment(JLabel.CENTER);
		player2.setHorizontalAlignment(JLabel.CENTER);
		ctrl1.setHorizontalAlignment(JLabel.CENTER);
		ctrl2.setHorizontalAlignment(JLabel.CENTER);
				
		btnHelpBack = new JButton(back);
		btnHelpBack.setOpaque(false);
		btnHelpBack.setContentAreaFilled(false);
		btnHelpBack.setBorderPainted(false);
		
		this.add(player1);
		this.add(player2);
		this.add(ctrl1);
		this.add(ctrl2);
		this.add(btnHelpBack);
		
	}

}
