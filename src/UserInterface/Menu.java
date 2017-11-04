package UserInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import GameManagement.GameManager;

public class Menu {
	
	SettingsPanel settingsPanel;
	MenuPanel menuPanel;
	CreditsPanel creditsPanel;
	HelpPanel helpPanel;
	HighScoresPanel hsPanel;
	GamePanel gamePanel;
	GameManager gameManager;
	
	Menu() {
		menuPanel = new MenuPanel();
		settingsPanel = new SettingsPanel();
		creditsPanel = new CreditsPanel();
		helpPanel = new HelpPanel();
		hsPanel = new HighScoresPanel();
		gamePanel = new GamePanel();
		
		menuPanel.setVisible(true);
		creditsPanel.setVisible(false);
		settingsPanel.setVisible(false);
		helpPanel.setVisible(false);
		hsPanel.setVisible(false);
		gamePanel.setVisible(false);
	}
	
	public void displayPanel(String visiblePanel, String removedPanel) {
		if( visiblePanel.equals("GamePane") && removedPanel.equals("MenuPanel") ) {
		
			menuPanel.setVisible(false);
			gamePanel.setVisible(true);
		}
				
	}
	
	public void changeSettings() {
		
	}
	
	public void displaySettings() {
		
	}
	
	public void displayHelp() {
		
	}
	
	public void displayHighScores() {
		
	}
	
	public void displayCredits() {
		
	}
	
	public class MenuActionListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

			if(arg0.getSource() == menuPanel.play)
				displayPanel( "GamePanel", "MenuPanel");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	
}
