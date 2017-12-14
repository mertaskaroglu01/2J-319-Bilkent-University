package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InterPanel extends JPanel {
	
	JButton btnNextRound;
	boolean proceed;
	/**
	 * Create the panel.
	 */
	public InterPanel() {
		this.setVisible(true);
		btnNextRound = new JButton("       Proceed Next Round     ");
		proceed = false;
		btnNextRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    try {			    	
				    proceed = true;		
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
	}


	public boolean getProceed() {
		return proceed;
	}
	
	
}
