package UserInterface;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreditsPanel extends JPanel {
	
	
	JButton btnCreditsBack;
	JLabel text1;
	JLabel text2;
	
	/**
	 * Create the panel.
	 */
	public CreditsPanel() {
		setVisible(true);
		
		ImageIcon credits1 = new ImageIcon("C:\\Users\\serha\\git\\2J-BubblePopper\\pictures\\credits1.png");
		ImageIcon credits2 = new ImageIcon("C:\\Users\\serha\\git\\2J-BubblePopper\\pictures\\credits2.png");
		ImageIcon back = new ImageIcon("C:\\Users\\serha\\git\\2J-BubblePopper\\pictures\\back.png");
		
		this.setLayout(new GridLayout(3,1));
		
		text1 = new JLabel();
		text2 = new JLabel();
		text1.setHorizontalAlignment(JLabel.CENTER);
		text2.setHorizontalAlignment(JLabel.CENTER);
		
		text1.setIcon(credits1);
		text2.setIcon(credits2);
	
		btnCreditsBack = new JButton(back);
		btnCreditsBack.setOpaque(false);
		btnCreditsBack.setContentAreaFilled(false);
		btnCreditsBack.setBorderPainted(false);
		
		add(text1);
		add(text2);
		add(btnCreditsBack);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Add background picture to main menu
        try {
        	final BufferedImage background = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\pictures\\menubackground.jpg"));
        	g.drawImage(background, 0, 0, this);	
        }
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
