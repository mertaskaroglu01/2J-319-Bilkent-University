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
	
	GameFrame gameFrame;
	/**
	 * Create the panel.
	 */
	
	
	public MenuPanel() {
		this.setVisible(true);
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    gameFrame = new GameFrame();
				gameFrame.setVisible(true);
			}
			
		});
		add(btnPlay);

	}

}
