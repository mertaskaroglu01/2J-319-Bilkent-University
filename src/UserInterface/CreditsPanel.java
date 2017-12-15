package UserInterface;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreditsPanel extends JPanel {
	
	
	JLabel txt1;
	JButton btnCreditsBack;
	/**
	 * Create the panel.
	 */
	public CreditsPanel() {
		setVisible(true);
		txt1 = new JLabel("haha");
		add(txt1);
		btnCreditsBack = new JButton("Back to Main Menu");
		add(btnCreditsBack);
	}
	
}
