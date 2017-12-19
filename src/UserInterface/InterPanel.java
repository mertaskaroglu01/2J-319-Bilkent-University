package UserInterface;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;

public class InterPanel extends JPanel {
	
	Timer timer;
	JButton btnProceed;
	JButton btnInterBack;
	int[] messages;
	JLabel info1;
	JLabel info2;
	JLabel info3;
	JLabel info4;
	
	String weaponType1, weaponType2;
	/**
	 * Create the panel.
	 */
	public InterPanel() {
		messages = new int[4];
		if( messages == null) {
			for( int i = 0; i < 4 ; i++) {
				messages[i] = 0;
			}
		}
		
		this.setVisible(true);
		this.setLayout(new GridLayout(6,0));
		
		ImageIcon nextlevel = new ImageIcon("pictures/nextlevel.png");
		ImageIcon back = new ImageIcon("pictures/back.png");
		btnProceed = new JButton(nextlevel);
		btnInterBack = new JButton(back);
		
		
		btnProceed.setOpaque(false);
		btnProceed.setContentAreaFilled(false);
		btnProceed.setBorderPainted(false);
		btnInterBack.setOpaque(false);
		btnInterBack.setContentAreaFilled(false);
		btnInterBack.setBorderPainted(false);
		
		
		info1 = new JLabel( "Player 1 Score: " + messages[0] + " Weapon Type: " + weaponType1);
		info2 = new JLabel( "Player 2 Score: " + messages[1] + " Weapon Type: " + weaponType2);
		info3 = new JLabel( "Lives Remaining:" + messages[2] );
		info4 = new JLabel( "You cleared round " + messages[3] + "!");
		
		info1.setHorizontalAlignment(JLabel.CENTER);
		info2.setHorizontalAlignment(JLabel.CENTER);
		info3.setHorizontalAlignment(JLabel.CENTER);
		info4.setHorizontalAlignment(JLabel.CENTER);
		
		info1.setForeground(Color.WHITE);
		info2.setForeground(Color.WHITE);
		info3.setForeground(Color.WHITE);
		info4.setForeground(Color.WHITE);
		
		info1.setFont(new Font("Courier New", Font.BOLD, 35));
		info2.setFont(new Font("Courier New", Font.BOLD, 35));
		info3.setFont(new Font("Courier New", Font.BOLD, 35));
		info4.setFont(new Font("Courier New", Font.BOLD, 35));
		
		this.add(btnProceed);
		this.add(info4);
		this.add(info1);
		this.add(info2);
		this.add(info3);
		this.add(btnInterBack);
	}
	
	public void paintComponent(Graphics g) {
        	super.paintComponent(g);
        	String temp = "";
			for( int i = 0; i < 3 ; i++) {
				temp = temp + messages[i] + " ";
			}
			

			if( messages[0] < 150) {
				weaponType1 = "Pistol";
			}
			else if( messages[0] > 150 && messages[0] < 300) {
				weaponType1 = "Rocket";
			}
			else {
				weaponType1 = "Missile";
			}
			if( messages[1] < 150) {
				weaponType2 = "Pistol";
			}
			else if( messages[1] > 150 && messages[1] < 300) {
				weaponType2 = "Rocket";
			}
			else {
				weaponType2 = "Missile";
			}
			
			info1.setText("Player 1 Score: " + messages[0] + " Weapon Type: " + weaponType1);
			info2.setText("Player 2 Score: " + messages[1] + " Weapon Type: " + weaponType2);
			info3.setText("Lives Remaining: " + messages[2]);
			info4.setText("You cleared round " + messages[3] + "!");
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
