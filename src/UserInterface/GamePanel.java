package UserInterface;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import GameEntities.Round;
import GameManagement.GameEngine;

//import com.sun.javafx.tk.Toolkit;

import GameManagement.GameManager;

public class GamePanel extends JPanel implements KeyListener  {

	GameManager gameManager;
	private Timer timer = new Timer(50, new TimerListener());
	int time;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public GamePanel() throws Exception {
		addKeyListener(this);
		
		time = 0;
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
		this.gameManager = new GameManager();	
		this.setVisible(true);
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	final BufferedImage background = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\pictures\\background.jpg"));
        	g.drawImage(background, 0, 0, this);	
        	//Player1 draw
        	g.drawImage(getCurrentRound().getPlayer(1).getImage(1), getCurrentRound().getPlayer(1).getXCoordinates(), getCurrentRound().getPlayer(1).getYCoordinates(), this);
        	//Player2 draw
        	g.drawImage(getCurrentRound().getPlayer(2).getImage(2), getCurrentRound().getPlayer(2).getXCoordinates(), getCurrentRound().getPlayer(2).getYCoordinates(), this);
        	//Plyaer1 bullet
        	if(getCurrentRound().getPlayer(1).isShooting() )
			{				
				if( getCurrentRound().getBullet(1).getYCoordinates() > 0)
				{
					g.drawImage(getCurrentRound().getBullet(1).getImage(), getCurrentRound().getBullet(1).getXCoordinates(),getCurrentRound().getBullet(1).getYCoordinates(), this);
					getCurrentRound().getBullet(1).moveUp();			
			
				}
				else 
				{
					getCurrentRound().getPlayer(1).changeShootingState(false);
					getCurrentRound().getPlayer(1).changeYCoordinates(380);
				}
				 
			}
        	//Player2 bullet
        	if(getCurrentRound().getPlayer(2).isShooting() )
			{				
				if( getCurrentRound().getBullet(2).getYCoordinates() > 0)
				{
					g.drawImage(getCurrentRound().getBullet(2).getImage(), getCurrentRound().getBullet(2).getXCoordinates(),getCurrentRound().getBullet(2).getYCoordinates(), this);
					getCurrentRound().getBullet(2).moveUp();			
			
				}
				else 
				{
					getCurrentRound().getPlayer(2).changeShootingState(false);
					getCurrentRound().getPlayer(2).changeYCoordinates(380);
				}
				 
			}
        	//Bubbles
        	for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) {
        		g.drawImage(getCurrentRound().getBubble(i).getImage(getCurrentRound().getBubble(i).getBubbleType()), getCurrentRound().getBubble(i).getXCoordinates(), getCurrentRound().getBubble(i).getYCoordinates(), this);
        	}
        	  
        	repaint();
			//gameManager.gameEngine.round.player1.pos += 50;
			//System.out.println(gameManager.gameEngine.round.player1.pos);
			
            
           
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       // if(gameManager.gameEngine.round.player1.image != null){
      //  }
    }
	
	public Round getCurrentRound() {
		return gameManager.gameEngine.getCurrentRound();
	}
	
	public GameEngine getCurrentEngine() {
		return gameManager.gameEngine;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {      
    		getCurrentRound().getPlayer(1).goLeft();
    		repaint();            	
           
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {      
    		getCurrentRound().getPlayer(1).goRight();
    		repaint();     			
           
        }
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
        	//gameManager.gameEngine.round.bullet1.changeXCoordinates( gameManager.gameEngine.round.player1.getXCoordinates() );
        	if( !getCurrentRound().getPlayer(1).isShooting() ) {
        		try {
        			getCurrentRound().createBullet(1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
        		getCurrentRound().getPlayer(1).shoot();	
        	}                	
        	//gameManager.gameEngine.round.player1.isShooting = false;
        	 
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			getCurrentRound().getPlayer(2).goLeft();
			repaint();  
        }
        if ( e.getKeyCode() == KeyEvent.VK_RIGHT) {
			getCurrentRound().getPlayer(2).goRight();
			repaint();  
        }
        if ( e.getKeyCode() == KeyEvent.VK_UP) {
        	if( !getCurrentRound().getPlayer(2).isShooting() ) {
        		try {
        			getCurrentRound().createBullet(2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
        		getCurrentRound().getPlayer(2).shoot();	
        	}
        }
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			time++;
			if( time > 20) {
				getCurrentEngine().handleBubbleWallCollision();
				for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) {
	        		getCurrentRound().getBubble(i).move();
	        	}
				getCurrentEngine().handleBulletBubbleCollision();
			}
		}
		
	}

}
