package UserInterface;

import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JPanel buttonPane;
	private JLabel header;
	//public MenuPanel menuPanel;
	public GamePanel gamePanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Arial", Font.BOLD, 18);
		header = new JLabel("Bubble Trouble");
		header.setFont(new Font("Arial", Font.BOLD, 65));
		header.setBackground(Color.WHITE);
		header.setForeground(Color.white);
		setSize(12200, 6400);  
		setBounds(400, 200, 450, 300);	
		setTitle("Bubble Popper (version β)");
		Box box = Box.createVerticalBox();
	    buttonPane = new JPanel();
		/*
		buttonPane2 = new JPanel();
		buttonPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		buttonPane2.setLayout(new GridLayout(6,1));
		buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		buttonPane.setLayout(new FlowLayout(6,6,6));
		buttonPane.setBackground(new Color(0,0,0));*/
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
 
}
