package UserInterface;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HelpPanel extends JPanel {
	
	JButton btnHelpBack;
	/**
	 * Create the panel.
	 */
	public HelpPanel() {
		setVisible(true);
		btnHelpBack = new JButton("Back to Main Menu");
		add(btnHelpBack);
		
	}

}
