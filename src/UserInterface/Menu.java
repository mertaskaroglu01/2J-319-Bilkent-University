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
import javax.swing.border.EmptyBorder;

public class Menu {
	JFrame menuFrame; 

	private JPanel contentPane;
	private JPanel buttonPane;
	private JLabel header;
	//public MenuPanel menuPanel;
	public GamePanel gamePanel;
	public InterPanel interPanel;
	public MenuPanel menuPanel;
	public JPanel cardPanel;
	public CreditsPanel creditsPanel;
	public HelpPanel helpPanel;
	public SettingsPanel settingsPanel;
	
	CardLayout card;
	
	static boolean alert;
	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Menu() throws Exception {
		
		menuFrame = new JFrame("Menu");
		
		card = new CardLayout();
		cardPanel = new JPanel(card);
		
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(12200, 6400);  
		menuFrame.setBounds(400, 200, 450, 300);	
		menuFrame.setTitle("Bubble Popper (version β)");
		
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
		
		menuPanel.btnPlay.addActionListener(new ButtonListener());
		menuPanel.btnCredits.addActionListener(new ButtonListener());
		menuPanel.btnPlay.addActionListener(new ButtonListener());
	
		/*
		alert = false
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Arial", Font.BOLD, 18);
		header = new JLabel("Bubble Trouble");
		headr.setFont(new Font("Arial", Font.BOLD, 65));
		header.setBackground(Color.WHITE);
		header.setForeground(Color.white);
		setSize(12200, 6400);  
		setBounds(400, 200, 450, 300);	
		setTitle("Bubble Popper (version β)");
		Box box = Box.createVerticalBox();
	    buttonPane = new JPanel();
		
		buttonPane2 = new JPanel();
		buttonPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		buttonPane2.setLayout(new GridLayout(6,1));
		buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		buttonPane.setLayout(new FlowLayout(6,6,6));
		buttonPane.setBackground(new Color(0,0,0));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(100,200));
		setContentPane(contentPane);
		setResizable(true); 
		JButton btnPlay = new JButton("        Play     ");
		btnPlay.setFont(font);
		btnPlay.setForeground(Color.CYAN);
		btnPlay.setBackground(Color.BLACK);
		JButton btnCredits = new JButton("     Credits  ");
		btnCredits.setFont(font);
		btnCredits.setForeground(Color.CYAN);
		btnCredits.setBackground(Color.BLACK);
		JButton btnHighScores = new JButton(" Highscore");
		btnHighScores.setFont(font);
		btnHighScores.setForeground(Color.CYAN);
		btnHighScores.setBackground(Color.BLACK);
		JButton btnSettings = new JButton("   Settings  ");
		btnSettings.setFont(font);
		btnSettings.setForeground(Color.CYAN);
		btnSettings.setBackground(Color.BLACK);
		box.add(Box.createHorizontalStrut(30));
		box.add(header);
		box.add(Box.createVerticalStrut(30));
		box.add(btnPlay);
		box.add(Box.createVerticalStrut(10));
        box.add(btnCredits);
        box.add(Box.createVerticalStrut(10));
        box.add(btnHighScores);
		box.add(Box.createVerticalStrut(10));
        box.add(btnSettings);
        
        buttonPane.add(box);
		contentPane.add(buttonPane,BorderLayout.CENTER);
		contentPane.setBackground(Color.BLACK);
		buttonPane.setBackground(Color.BLACK);
		gamePanel = new GamePanel();
		interPanel = new InterPanel();
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    try {			    	
				    contentPane.removeAll();
			        contentPane.invalidate();			    	
					contentPane.add(gamePanel);
					contentPane.revalidate();				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		if( alert == true) {
			System.out.println("alerted");
			try {			    	
			    contentPane.removeAll()
		        contentPane.invalidate();			    	
				contentPane.add(interPanel);
				contentPane.revalidate();				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		*/
		
	}
	
	 public void paint( Graphics g ) { 
		    super.paint(g);
		    BufferedImage background;
		/*	try {
				//background = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\pictures\\background.jpg"));
				//g.drawImage(background, 0, 0, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        		
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
	 
	 
	 public static void showInterPanel() {
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
		     else if( selectedButton == creditsPanel.btnHelpBack) {
		    	 card.show(cardPanel, "menu");
		     }
		     else if( selectedButton == creditsPanel.btnSettingsBack) {
		    	 card.show(cardPanel, "menu");
		     }
		 }
	 }
	 
}
