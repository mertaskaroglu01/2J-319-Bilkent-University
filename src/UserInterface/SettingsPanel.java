package UserInterface;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel {

	JButton btnSettingsBack;
	JButton on;
	JButton off;
	/**
	 * Create the panel.
	 */
	public SettingsPanel() {
		setVisible(true);
		setLayout(new GridLayout(3,1));
		
		ImageIcon soundon = new ImageIcon("pictures/soundon.png");
		ImageIcon soundoff = new ImageIcon("pictures/soundoff.png");
		ImageIcon back = new ImageIcon("pictures/back.png");
		
		on = new JButton();
		off = new JButton();
		on.setIcon(soundon);
		off.setIcon(soundoff);
		on.setHorizontalAlignment(JLabel.CENTER);
		off.setHorizontalAlignment(JLabel.CENTER);
		
		btnSettingsBack = new JButton(back);
		btnSettingsBack.setOpaque(false);
		btnSettingsBack.setContentAreaFilled(false);
		btnSettingsBack.setBorderPainted(false);
		on.setOpaque(false);
		on.setContentAreaFilled(false);
		on.setBorderPainted(false);
		off.setOpaque(false);
		off.setContentAreaFilled(false);
		off.setBorderPainted(false);
		
		this.add(on);
		this.add(off);
		this.add(btnSettingsBack);
		
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Add background picture to main menu
        try {
        	final BufferedImage background = ImageIO.read(new File("pictures/menubackground.jpg"));
        	g.drawImage(background, 0, 0, this);	
        }
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
