package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InterPanel extends JPanel {
	
	JButton btnProceed;
	/**
	 * Create the panel.
	 */
	public InterPanel() {
		this.setVisible(true);
		btnProceed = new JButton("Proceed Next Round");
		this.add(btnProceed);
	}
	
	
}
