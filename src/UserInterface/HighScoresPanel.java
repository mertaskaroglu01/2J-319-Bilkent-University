package UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameEntities.Bubble;
import GameEntities.User;

public class HighScoresPanel extends JPanel {

	JButton btnHSBack;
	ArrayList<User> users;
	JLabel highScore1;
	JLabel highScore2;
	JLabel highScore3;
	JLabel highScore4;
	JLabel highScore5;
	File file;
	FileReader fileReader;
	BufferedReader bufferedReader;
	StringBuffer stringBuffer;
	String line;
	String name;
	String point;
	String user;

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public HighScoresPanel() throws IOException {
		setVisible(true);
		this.setLayout(new GridLayout(6,1));
		
		highScore1 = new JLabel();
		highScore2 = new JLabel();
		highScore3 = new JLabel();
		highScore4 = new JLabel();
		highScore5 = new JLabel();
		
		users = new ArrayList<User>();
		ImageIcon back = new ImageIcon("pictures/back.png");
		btnHSBack = new JButton(back);
		btnHSBack = new JButton(back);
		btnHSBack.setOpaque(false);
		btnHSBack.setContentAreaFilled(false);
		btnHSBack.setBorderPainted(false);
		

		highScore1.setFont(new Font("Courier New", Font.BOLD, 35));
		highScore2.setFont(new Font("Courier New", Font.BOLD, 35));
		highScore3.setFont(new Font("Courier New", Font.BOLD, 35));
		highScore4.setFont(new Font("Courier New", Font.BOLD, 35));
		highScore5.setFont(new Font("Courier New", Font.BOLD, 35));
		
		highScore1.setHorizontalAlignment(JLabel.CENTER);
		highScore2.setHorizontalAlignment(JLabel.CENTER);
		highScore3.setHorizontalAlignment(JLabel.CENTER);
		highScore4.setHorizontalAlignment(JLabel.CENTER);
		highScore5.setHorizontalAlignment(JLabel.CENTER);
		
		highScore1.setForeground(Color.WHITE);
		highScore2.setForeground(Color.WHITE);
		highScore3.setForeground(Color.WHITE);
		highScore4.setForeground(Color.WHITE);
		highScore5.setForeground(Color.WHITE);
		
		file = new File("src/HighScores.txt");
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		stringBuffer = new StringBuffer();
		line = "";
		name = "";
		point = "0";
		user = "";
		
		while( (line = bufferedReader.readLine()) != null)
		{	
					
			
	    	for(int i = 0; i < line.length(); i++ )
			{
				if((line.charAt(i) >= 'a' && line.charAt(i) <= 'z') || (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z'))
			    {
			    	name = name + line.charAt(i);
			    }
				else 
			    {
			    	point = point + line.charAt(i); 
			    }
			}
			User u = new User();
			u.setName(name);
			u.setScore(Integer.parseInt(point));
			point = "0";
			name = "";
			users.add(u);	
			
		}
		Collections.sort(users, new Comparator<User>() {
	        @Override public int compare(User u1, User u2) {
	            return u2.getScore() - u1.getScore(); // Ascending
	        }

	    });
		highScore1.setText("1. " + users.get(0).getName() + ":" + users.get(0).getScore());
		highScore2.setText("2. " + users.get(1).getName() + ":" + users.get(1).getScore());
		highScore3.setText("3. " + users.get(2).getName() + ":" + users.get(2).getScore());
		highScore4.setText("4. " + users.get(3).getName() + ":" + users.get(3).getScore());
		highScore5.setText("5. " + users.get(4).getName() + ":" + users.get(4).getScore());
		add(highScore1);
		add(highScore2);
		add(highScore3);
		add(highScore4);
		add(highScore5);
		this.add(btnHSBack);
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Add background picture to main menu
        try {
        	line = "";
    		name = "";
    		point = "0";
    		user = "";
        	final BufferedImage background = ImageIO.read(new File("pictures/menubackground.jpg"));
        	while( (line = bufferedReader.readLine()) != null)
    		{	
    					
    			
    	    	for(int i = 0; i < line.length(); i++ )
    			{
    				if((line.charAt(i) >= 'a' && line.charAt(i) <= 'z') || (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z'))
    			    {
    			    	name = name + line.charAt(i);
    			    }
    				else 
    			    {
    			    	point = point + line.charAt(i); 
    			    }
    			}
    			User u = new User();
    			u.setName(name);
    			u.setScore(Integer.parseInt(point));
    			point = "0";
    			name = "";
    			users.add(u);	
    			
    		}
    		Collections.sort(users, new Comparator<User>() {
    	        @Override public int compare(User u1, User u2) {
    	            return u2.getScore() - u1.getScore(); // Ascending
    	        }

    	    });
        	highScore1.setText("1. " + users.get(0).getName() + ":" + users.get(0).getScore());
    		highScore2.setText("2. " + users.get(1).getName() + ":" + users.get(1).getScore());
    		highScore3.setText("3. " + users.get(2).getName() + ":" + users.get(2).getScore());
    		highScore4.setText("4. " + users.get(3).getName() + ":" + users.get(3).getScore());
    		highScore5.setText("5. " + users.get(4).getName() + ":" + users.get(4).getScore());
        	g.drawImage(background, 0, 0, this);
        }
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
