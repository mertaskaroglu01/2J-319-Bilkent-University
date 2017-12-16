package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class GameFrame extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtMert;
	public GamePanel gamePanel;
	public MenuPanel menuPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
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
	public GameFrame() throws Exception {
		
		//JLabel background = new JLabel (new ImageIcon ("C:\\Users\\Mert\\git\\2J-BubblePopper\\background.png"));
		//menuPanel = new MenuPanel();
		gamePanel = new GamePanel();
		//gamePanel.add(background, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 450);   
		setTitle("Bubble Popper (version ?)");
        setSize(1220, 640);   
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);		   
		contentPane.add(gamePanel, BorderLayout.CENTER);	
		
		
		
	}

	
    
}
