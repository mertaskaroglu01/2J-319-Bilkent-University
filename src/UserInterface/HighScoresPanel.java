package UserInterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HighScoresPanel extends JPanel {

	JButton btnHSBack;
	/**
	 * Create the panel.
	 * @throws FileNotFoundException 
	 */
	public HighScoresPanel() throws FileNotFoundException {
		setVisible(true);
		ImageIcon back = new ImageIcon("C:\\Users\\Faaiz\\git\\2J-BubblePopper\\pictures\\back.png");
		btnHSBack = new JButton(back);
		btnHSBack = new JButton(back);
		btnHSBack.setOpaque(false);
		btnHSBack.setContentAreaFilled(false);
		btnHSBack.setBorderPainted(false);
		this.add(btnHSBack);
		
		Scanner inFile = new Scanner(new FileReader("C:\\Users\\Faaiz\\git\\2J-BubblePopper\\src\\HighScores.txt"));
		
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Add background picture to main menu
        try {
        	final BufferedImage background = ImageIO.read(new File("C:\\Users\\Faaiz\\git\\2J-BubblePopper\\pictures\\menubackground.jpg"));
        	g.drawImage(background, 0, 0, this);	
        }
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
