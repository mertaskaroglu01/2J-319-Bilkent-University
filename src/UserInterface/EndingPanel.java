package UserInterface;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EndingPanel extends JPanel {

	Timer timer;
	JButton btnSaveScore;
	JButton btnEndingBack;
	int[] messages;
	JLabel info;
	/**
	 * Create the panel.
	 */
	public EndingPanel() {
		messages = new int[3];
		if( messages == null) {
			for( int i = 0; i < 3 ; i++) {
				messages[i] = 0;
			}
		}
		
		this.setVisible(true);
		btnSaveScore = new JButton("Save Scores");
		this.add(btnSaveScore);
		btnEndingBack = new JButton("Back to Main Menu");
		this.add(btnEndingBack);
		String temp = "";
		for( int i = 0; i < 3 ; i++) {
			temp = temp + messages[i] + " ";
		}
	info = new JLabel( temp);
		this.add(info);
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        	String temp = "";
			for( int i = 0; i < 3 ; i++) {
				temp = temp + messages[i] + " ";
			}
			info.setText(temp);
    }

}
