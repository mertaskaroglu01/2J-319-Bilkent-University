package UserInterface;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import GameManagement.*;
import GameEntities.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
	
	JButton btnPlay;
	JButton btnCredits;
	JButton btnHelp;
	JButton btnSettings;
	JButton btnHighScores;
	//CreditPanel creditPanel;
	/**
	 * Create the panel.
	 */

	
	
	public MenuPanel() {
		this.setVisible(true);
		
		ImageIcon play = new ImageIcon("pictures/play.png");
		ImageIcon credits = new ImageIcon("pictures/credits.png");
		ImageIcon help = new ImageIcon("pictures/help.png");
		ImageIcon settings = new ImageIcon("pictures/settings.png");
		ImageIcon logo = new ImageIcon("pictures/logo.png");
		ImageIcon highscores = new ImageIcon("pictures/highscores.png");
		btnPlay =  new JButton(play);	
		btnCredits = new JButton(credits);
		btnHelp = new JButton(help);
		btnSettings = new JButton(settings);
		btnHighScores = new JButton(highscores);
		
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(false);
		btnCredits.setOpaque(false);
		btnCredits.setContentAreaFilled(false);
		btnCredits.setBorderPainted(false);
		btnSettings.setOpaque(false);
		btnSettings.setContentAreaFilled(false);
		btnSettings.setBorderPainted(false);
		btnHelp.setOpaque(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setBorderPainted(false);
		btnHighScores.setOpaque(false);
		btnHighScores.setContentAreaFilled(false);
		btnHighScores.setBorderPainted(false);

		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(logo);
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		this.setLayout(new GridLayout(6,1));
		this.add(iconLabel);
		this.add(btnPlay);
		this.add(btnCredits);
		this.add(btnSettings);
		this.add(btnHelp);
		this.add(btnHighScores);
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
