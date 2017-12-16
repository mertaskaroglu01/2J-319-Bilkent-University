package UserInterface;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class InterPanel extends JPanel {
	
	Timer timer;
	JButton btnProceed;
	JButton btnInterBack;
	int[] messages;
	JLabel info;
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
		btnProceed = new JButton("Proceed Next Round");
		this.add(btnProceed);
		btnInterBack = new JButton("Back to Main Menu");
		this.add(btnInterBack);
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
