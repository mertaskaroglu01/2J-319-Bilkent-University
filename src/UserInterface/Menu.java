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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

import GameManagement.SoundManager;
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
	public EndingPanel endingPanel;
	public HighScoresPanel hsPanel;
	
	CardLayout card;
	Timer timer = new Timer(17, new TimerListener());
	static boolean alert, end;
	Clip clip = null; //initial value
	/**
	 * Launch the application.
	 */
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
	
	
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Menu() throws Exception {
			
		alert = false;
		end = false;
		
		menuFrame = new JFrame("Menu");
		
		card = new CardLayout();
		cardPanel = new JPanel(card);
		
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(12200, 6400);  
		menuFrame.setBounds(400, 200, 1210, 638);
		menuFrame.setResizable(false);
		menuFrame.setTitle("Bubble Popper");
		
		gamePanel = new GamePanel();
		menuPanel = new MenuPanel();
		interPanel = new InterPanel();
		creditsPanel = new CreditsPanel();
		settingsPanel = new SettingsPanel();
		helpPanel = new HelpPanel();
		endingPanel = new EndingPanel();
		hsPanel = new HighScoresPanel();
		
	
	
		cardPanel.add(creditsPanel, "credits");
		cardPanel.add(interPanel, "inter");
		cardPanel.add(menuPanel, "menu");
		cardPanel.add(gamePanel, "game");
		cardPanel.add(helpPanel, "help");
		cardPanel.add(settingsPanel, "settings");
		cardPanel.add(endingPanel, "ending");
		cardPanel.add(hsPanel, "highscores");
		
		menuFrame.setVisible(true);
		menuFrame.add(cardPanel);
		
		card.show(cardPanel, "menu");
		
		timer.start();
		
		menuPanel.btnPlay.addActionListener(new ButtonListener());
		menuPanel.btnCredits.addActionListener(new ButtonListener());
		menuPanel.btnSettings.addActionListener(new ButtonListener());
		menuPanel.btnHelp.addActionListener(new ButtonListener());
		menuPanel.btnHighScores.addActionListener(new ButtonListener());
		creditsPanel.btnCreditsBack.addActionListener(new ButtonListener());
		settingsPanel.btnSettingsBack.addActionListener(new ButtonListener());
		helpPanel.btnHelpBack.addActionListener(new ButtonListener());
		interPanel.btnProceed.addActionListener(new ButtonListener());
		interPanel.btnInterBack.addActionListener(new ButtonListener());
		endingPanel.btnEndingBack.addActionListener(new ButtonListener());
		endingPanel.btnSaveScore.addActionListener(new ButtonListener());
		hsPanel.btnHSBack.addActionListener(new ButtonListener());
		settingsPanel.on.addActionListener(new ButtonListener());
		settingsPanel.off.addActionListener(new ButtonListener());

		
	}
	 
	 
	 	
	 
	 public static void endOfRound() {
			 alert = true;       
	 }
	 
	 public static void endOfGame() {
		 end = true;
	 }
	 
	 
	 public class ButtonListener implements ActionListener {
		 
		 public void actionPerformed(ActionEvent e) {
			
			 JComponent selectedButton = (JComponent) e.getSource();
		     CardLayout card = (CardLayout)(cardPanel.getLayout());
		      
		     if(selectedButton == menuPanel.btnCredits) {
		    	 card.show(cardPanel, "credits");
		     }
		     else if( selectedButton == menuPanel.btnPlay) {
		    	 if((gamePanel.getCurrentEngine().getSoundManager().getPlaying())) {
		    		 gamePanel.getCurrentEngine().getSoundManager().stopSound(gamePanel.backgroundMusic);
		    	 }
		    	 if(clip != null) {
		    		 gamePanel.getCurrentEngine().getSoundManager().stopSound(clip);
		    	 }
		    	card.show(cardPanel, "game");
		    	gamePanel.startTimer();
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
		    	 gamePanel.startNext();
		    	 gamePanel.startTimer();
		     }
		     else if( selectedButton == interPanel.btnInterBack) {
		    	 card.show(cardPanel, "menu");
		    	 try {
					gamePanel.getCurrentRound().startGameAgain();
					gamePanel.changeAlertState();
					gamePanel.getCurrentEngine().setLives(5);
				} catch (Exception e1) {
					// TODO Auto-generated catch bloc
					e1.printStackTrace();
				}
		    	 //if(!(gamePanel.getCurrentEngine().getSoundManager().getPlaying())) {
		    		 try {
		    			// System.out.println("test_blok1");
		    			 clip = gamePanel.getCurrentEngine().getSoundManager().play(1);
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	 //}
		     }
		     else if( selectedButton == endingPanel.btnEndingBack) {
		    	 card.show(cardPanel, "menu");
		    	 try {
					gamePanel.getCurrentRound().startGameAgain();
					gamePanel.changeAlertState();
					gamePanel.getCurrentEngine().setLives(5);
					hsPanel.repaint();
				} catch (Exception e1) {
					// TODO Auto-generated catch bloc
					e1.printStackTrace();
				}
		    	// if(!(gamePanel.getCurrentEngine().getSoundManager().getPlaying())) {
		    		 try {
		    			 clip = gamePanel.getCurrentEngine().getSoundManager().play(1);
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	// }
		     }
		     else if( selectedButton == hsPanel.btnHSBack) {
		    	 card.show(cardPanel, "menu");
		     }
		     else if( selectedButton == menuPanel.btnHighScores) {
		    	 card.show(cardPanel, "highscores");
		     }
		     else if( selectedButton == endingPanel.btnSaveScore) {
		    	 int count = 0;
		    	 try {
		    		 FileWriter fileWritter = new FileWriter("src/HighScores.txt",true);        
		             BufferedWriter writer = new BufferedWriter(fileWritter);
					//if(gamePanel.getCurrentManager().isHighScore(gamePanel.getCurrentRound().getPlayer(1).getScore() + gamePanel.getCurrentRound().getPlayer(2).getScore()))
					//{
						
						if(count <= 0)
						{	
							writer.newLine();
							writer.write((endingPanel.getName()+(gamePanel.getCurrentRound().getPlayer(1).getScore() + gamePanel.getCurrentRound().getPlayer(2).getScore())));
							
							if ( writer != null)
						        writer.close( );
							
							count++;							
						}
					//}
					
		             fileWritter.close();
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     }
		     
		     else if( selectedButton == settingsPanel.on) {
		    	 if(!(gamePanel.getCurrentEngine().getSoundManager().getPlaying())) {
		    		 try {
		    			 clip = gamePanel.getCurrentEngine().getSoundManager().play(1);
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	 }
		     }
		     else if( selectedButton == settingsPanel.off) {
		    	 if((gamePanel.getCurrentEngine().getSoundManager().getPlaying())) {
		    		 gamePanel.getCurrentEngine().getSoundManager().stopSound(gamePanel.backgroundMusic);
		    	 }
		    	 if(clip != null) {
		    		 gamePanel.getCurrentEngine().getSoundManager().stopSound(clip);
		    	 }
		     }
		 }
	 }
	 
	 public class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(alert) {
				card.show(cardPanel, "inter");
				alert = false;
				gamePanel.stopTimer();
				interPanel.messages = sendMessages();
				interPanel.revalidate();
				interPanel.repaint();
			}
			else if( end) {
				card.show(cardPanel, "ending");
				end = false;
				gamePanel.stopTimer();
				endingPanel.messages = sendMessages();
				endingPanel.revalidate();
				endingPanel.repaint();
			}
				
		}
	
	}
	 
	 public int[] sendMessages() {
		 int[] messages = new int[4];
		 messages[0] = gamePanel.getCurrentRound().getPlayer(1).getScore();
		 messages[1] = gamePanel.getCurrentRound().getPlayer(2).getScore();
		 messages[2] = gamePanel.getCurrentEngine().getRemainingLives();
		 messages[3] = gamePanel.getCurrentRound().getRoundNumber();
		 return messages;
	 }
}
