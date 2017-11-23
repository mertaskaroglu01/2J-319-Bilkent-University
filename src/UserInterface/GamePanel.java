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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//import com.sun.javafx.tk.Toolkit;

import GameManagement.GameManager;

public class GamePanel extends JPanel   {

	GameManager gameManager;
	
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public GamePanel() throws Exception {
		 addKeyListener(new KeyAdapter() {

	            @Override
	            public void keyPressed(KeyEvent e) {
	            	if (e.getKeyCode() == KeyEvent.VK_A) {
	                	int key = e.getKeyCode();	            		
	            			System.out.println("Move Left");
	            			gameManager.gameEngine.round.player1.goLeft();
	            			repaint();            	
	                   
	                }
	                if (e.getKeyCode() == KeyEvent.VK_D) {
	                	int key = e.getKeyCode();	            		
	            			System.out.println("Move Right");
	            			gameManager.gameEngine.round.player1.goRight();
	            			repaint();     			
	                   
	                }
	                if (e.getKeyCode() == KeyEvent.VK_W)
	                {
	                	System.out.println("Fire"); 
	                	   
	                	//gameManager.gameEngine.round.bullet1.changeXCoordinates( gameManager.gameEngine.round.player1.getXCoordinates() );
	                	if( !gameManager.gameEngine.round.player1.isShooting() ) {
	                		try {
								gameManager.gameEngine.round.createBullet(1);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
	                		gameManager.gameEngine.round.player1.shoot();	
	                	}                	
	                	//gameManager.gameEngine.round.player1.isShooting = false;
	                	 
	                }
	               
	            }
	        });	
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
		this.gameManager = new GameManager();	
		this.setVisible(true);
	}
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void keyTyped(KeyEvent e) {
//		
//		int key = e.getKeyCode();
//		if( key == KeyEvent.VK_A)
//		{
//			System.out.println("ASD");
//			gameManager.gameEngine.round.player1.pos += 50;
//			repaint();
//		}
//	
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	final BufferedImage background = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\background.png"));
        	g.drawImage(background, 0, 0, this);			
        	g.drawImage(gameManager.gameEngine.round.player1.getImage(), gameManager.gameEngine.round.player1.getXCoordinates(), gameManager.gameEngine.round.player1.getYCoordinates(), this);
        	if(gameManager.gameEngine.round.player1.isShooting() )
			{				
				if( gameManager.gameEngine.round.bullet1.getYCoordinates() > 0)
				{
					g.drawImage(gameManager.gameEngine.round.bullet1.getImage(), gameManager.gameEngine.round.bullet1.getXCoordinates(),gameManager.gameEngine.round.bullet1.getYCoordinates(), this);
					gameManager.gameEngine.round.bullet1.moveUp();			
			
				}
				else 
				{
					gameManager.gameEngine.round.player1.changeShootingState(false);
					gameManager.gameEngine.round.bullet1.changeYCoordinates(380);
				}
				 
			}	
        	for( int i = 0; i < gameManager.gameEngine.round.getNoOfBubbles(); i++ ) {
        		g.drawImage(gameManager.gameEngine.round.getBubble(i).getImage(gameManager.gameEngine.round.getBubble(i).getBubbleType()), gameManager.gameEngine.round.getBubble(i).getXCoordinates(), gameManager.gameEngine.round.getBubble(i).getYCoordinates(), this);
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


}
