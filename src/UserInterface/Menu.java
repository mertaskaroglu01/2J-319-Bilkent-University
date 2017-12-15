package UserInterface;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import UserInterface.GamePanel.TimerListener;

public class Menu {
	JFrame menuFrame; 

	//public MenuPanel menuPanel;
	public GamePanel gamePanel;
	public InterPanel interPanel;
	public MenuPanel menuPanel;
	public JPanel cardPanel;
	public CreditsPanel creditsPanel;
	public HelpPanel helpPanel;
	public SettingsPanel settingsPanel;
	
	CardLayout card;
	private Timer timer = new Timer(17, new TimerListener());
	static boolean alert;
	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Menu() throws Exception {
			
		alert = false;
		
		menuFrame = new JFrame("Menu");
		
		card = new CardLayout();
		cardPanel = new JPanel(card);
		
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(12200, 6400);  
		menuFrame.setBounds(400, 200, 450, 300);	
		menuFrame.setTitle("Bubble Popper");
		
		gamePanel = new GamePanel();
		menuPanel = new MenuPanel();
		interPanel = new InterPanel();
		creditsPanel = new CreditsPanel();
		settingsPanel = new SettingsPanel();
		helpPanel = new HelpPanel();
		
	
	
		cardPanel.add(creditsPanel, "credits");
		cardPanel.add(interPanel, "inter");
		cardPanel.add(menuPanel, "menu");
		cardPanel.add(gamePanel, "game");
		cardPanel.add(helpPanel, "help");
		cardPanel.add(settingsPanel, "settings");
		
		menuFrame.setVisible(true);
		menuFrame.add(cardPanel);
		
		card.show(cardPanel, "menu");
		
		timer.start();
		
		menuPanel.btnPlay.addActionListener(new ButtonListener());
		menuPanel.btnCredits.addActionListener(new ButtonListener());
		menuPanel.btnSettings.addActionListener(new ButtonListener());
		menuPanel.btnHelp.addActionListener(new ButtonListener());
		creditsPanel.btnCreditsBack.addActionListener(new ButtonListener());
		settingsPanel.btnSettingsBack.addActionListener(new ButtonListener());
		helpPanel.btnHelpBack.addActionListener(new ButtonListener());
		interPanel.btnProceed.addActionListener(new ButtonListener());
		
	}
	 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Menu frame = new Menu();
						//frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	 	
	 
	 public static void endOfRound() {
		 alert = true;        
	 }
	 
	 public class ButtonListener implements ActionListener {
		 
		 public void actionPerformed(ActionEvent e) {
			
			 JComponent selectedButton = (JComponent) e.getSource();
		     CardLayout card = (CardLayout)(cardPanel.getLayout());
		      
		     if(selectedButton == menuPanel.btnCredits) {
		    	 card.show(cardPanel, "credits");
		     }
		     else if( selectedButton == menuPanel.btnPlay) {
		    	card.show(cardPanel, "game");
		     }
		     else if( selectedButton == creditsPanel.btnCreditsBack) {
		    	 card.show(cardPanel, "menu");
		     }
		     else if( selectedButton == helpPanel.btnHelpBack) {
		    	 card.show(cardPanel, "menu");
		     }
		     else if( selectedButton == settingsPanel.btnSettingsBack) {
		    	 card.show(cardPanel, "menu");
		     }
		     else if( selectedButton == menuPanel.btnSettings) {
			    	card.show(cardPanel, "settings");
			 }
		     else if( selectedButton == menuPanel.btnHelp) {
			    	card.show(cardPanel, "help");
			 }
		     else if( selectedButton == interPanel.btnProceed) {
		    	 card.show(cardPanel, "game");
		     }
		 }
	 }
	 
	 public class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(alert) {
				card.show(cardPanel, "inter");
				alert = false;
			}
				
		}
	
	}
	 
}
