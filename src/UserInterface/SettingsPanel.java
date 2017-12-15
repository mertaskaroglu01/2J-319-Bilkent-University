package UserInterface;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel {

	JButton btnSettingsBack;
	/**
	 * Create the panel.
	 */
	public SettingsPanel() {


		
		setVisible(true);
		btnSettingsBack = new JButton("Back to Main Menu");
		add(btnSettingsBack);
		
	}

}
