package UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EndingPanel extends JPanel {

	Timer timer;
	JButton btnSaveScore;
	JButton btnEndingBack;
	int[] messages;
	JLabel info1;
	JLabel info2;
	JLabel info3;
	JLabel gameOver;
	/**
	 * Create the panel.
	 */
	public EndingPanel() {
		messages = new int[4];
		if( messages == null) {
			for( int i = 0; i < 4 ; i++) {
				messages[i] = 0;
			}
		}
		
		this.setVisible(true);
		this.setLayout(new GridLayout(6,1));
		
		ImageIcon game = new ImageIcon("pictures/gameover.png");
		ImageIcon back = new ImageIcon("pictures/back.png");
		ImageIcon save = new ImageIcon("pictures/savescore.png");
		
		
		btnSaveScore = new JButton(save);
		btnEndingBack = new JButton(back);

		btnSaveScore.setOpaque(false);
		btnSaveScore.setContentAreaFilled(false);
		btnSaveScore.setBorderPainted(false);
		btnEndingBack.setOpaque(false);
		btnEndingBack.setContentAreaFilled(false);
		btnEndingBack.setBorderPainted(false);

		info1 = new JLabel( "Player 1 Score: " + messages[0] );
		info2 = new JLabel( "Player 2 Score: " + messages[1] );
		info3 = new JLabel( "You reached to round " + messages[3] + "!");
		if( messages[3] == 10)
			info3.setText("You finished the game! Congratulations ");
		gameOver = new JLabel();
		gameOver.setIcon(game);
		
		info1.setFont(new Font("Courier New", Font.BOLD, 35));
		info2.setFont(new Font("Courier New", Font.BOLD, 35));
		info3.setFont(new Font("Courier New", Font.BOLD, 35));
		
		info1.setHorizontalAlignment(JLabel.CENTER);
		info2.setHorizontalAlignment(JLabel.CENTER);
		info3.setHorizontalAlignment(JLabel.CENTER);
		
		gameOver.setHorizontalAlignment(JLabel.CENTER);
		info1.setForeground(Color.WHITE);
		info2.setForeground(Color.WHITE);
		info3.setForeground(Color.WHITE);
		
		this.add(gameOver);
		this.add(btnSaveScore);
		this.add(info3);
		this.add(info1);
		this.add(info2);
		this.add(btnEndingBack);	
	}
	
	public void paintComponent(Graphics g) {
        	super.paintComponent(g);
			info1.setText("Player 1 Score: " + messages[0]);
			info2.setText("Player 2 Score: " + messages[1]);
			info3.setText("You reached to round " + messages[3] + "!");
			if( messages[3] == 10)
				info3.setText("You finished the game! Congratulations ");
			
			try {
	        	final BufferedImage background = ImageIO.read(new File("pictures/menubackground.jpg"));
	        	g.drawImage(background, 0, 0, this);	
	        }
	        catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	public String getName()
	{
		String name = JOptionPane.showInputDialog("Enter a team name");
		return name;
	}
}
