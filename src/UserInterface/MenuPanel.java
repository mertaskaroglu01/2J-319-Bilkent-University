package UserInterface;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import GameManagement.*;
import GameEntities.*;

import java.awt.event.ActionListener;
import java.awt.Graphics;
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
		btnPlay =  new JButton("Play");
		btnCredits = new JButton("Credits");
		btnHelp = new JButton("Help");
		btnSettings = new JButton("Settings");
		btnHighScores = new JButton("HighScores");
		this.add(btnPlay);
		this.add(btnSettings);
		this.add(btnHighScores);
		this.add(btnCredits);
		this.add(btnHelp);
	}
	
	

}
