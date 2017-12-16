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
	/**
	 * Create the panel.
	 */
	public InterPanel() {
		messages = new int[3];
		if( messages == null) {
			for( int i = 0; i < 3 ; i++) {
				messages[i] = 0;
			}
		}
		
		this.setVisible(true);
		this.setLayout(new GridLayout(5,0));
		
		ImageIcon nextlevel = new ImageIcon("C:\\Users\\Faaiz\\git\\2J-BubblePopper\\pictures\\nextlevel.png");
		ImageIcon back = new ImageIcon("C:\\Users\\Faaiz\\git\\2J-BubblePopper\\pictures\\back.png");
		btnProceed = new JButton(nextlevel);
		btnInterBack = new JButton(back);
		
		
		btnProceed.setOpaque(false);
		btnProceed.setContentAreaFilled(false);
		btnProceed.setBorderPainted(false);
		btnInterBack.setOpaque(false);
		btnInterBack.setContentAreaFilled(false);
		btnInterBack.setBorderPainted(false);

		info1 = new JLabel( "Player 1 Score: " + messages[0] );
		info2 = new JLabel( "Player 2 Score: " + messages[1] );
		info3 = new JLabel( "Lives Remaining:" + messages[2] );
		info1.setHorizontalAlignment(JLabel.CENTER);
		info2.setHorizontalAlignment(JLabel.CENTER);
		info3.setHorizontalAlignment(JLabel.CENTER);
		info1.setForeground(Color.WHITE);
		info2.setForeground(Color.WHITE);
		info3.setForeground(Color.WHITE);
		
		info1.setFont(new Font("Courier New", Font.BOLD, 35));
		info2.setFont(new Font("Courier New", Font.BOLD, 35));
		info3.setFont(new Font("Courier New", Font.BOLD, 35));
		
		this.add(btnProceed);
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
			info1.setText("Player 1 Score: " + messages[0]);
			info2.setText("Player 2 Score: " + messages[1]);
			info3.setText("Lives Remaining: " + messages[2]);
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
