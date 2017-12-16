package UserInterface;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
		btnHSBack = new JButton("Back to Main Menu");
		add(btnHSBack);
		
		Scanner inFile = new Scanner(new FileReader("C:\\Users\\Mert\\git\\2J-BubblePopper\\src\\HighScores.txt"));
		
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
			
    }

}
