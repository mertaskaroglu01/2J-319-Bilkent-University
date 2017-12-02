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
	
	GamePanel gamePanel;
	String menuOption;
	//CreditPanel creditPanel;
	/**
	 * Create the panel.
	 */
	
	
	public MenuPanel() {
		this.setVisible(true);
		
	}
	public String getOption()
	{
		return menuOption;
	}
	

}
