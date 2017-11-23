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

import GameEntities.Round;

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
	            			getCurrentRound().player1.goLeft();
	            			repaint();            	
	                   
	                }
	                if (e.getKeyCode() == KeyEvent.VK_D) {
	                	int key = e.getKeyCode();	            		
	            			System.out.println("Move Right");
	            			getCurrentRound().player1.goRight();
	            			repaint();     			
	                   
	                }
	                if (e.getKeyCode() == KeyEvent.VK_W)
	                {
	                	System.out.println("Fire"); 
	                	   
	                	//gameManager.gameEngine.round.bullet1.changeXCoordinates( gameManager.gameEngine.round.player1.getXCoordinates() );
	                	if( !getCurrentRound().player1.isShooting() ) {
	                		try {
	                			getCurrentRound().createBullet(1);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
	                		getCurrentRound().player1.shoot();	
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
        	final BufferedImage background = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\pictures\\background.png"));
        	g.drawImage(background, 0, 0, this);			
        	g.drawImage(getCurrentRound().player1.getImage(), getCurrentRound().player1.getXCoordinates(), getCurrentRound().player1.getYCoordinates(), this);
        	if(getCurrentRound().player1.isShooting() )
			{				
				if( getCurrentRound().bullet1.getYCoordinates() > 0)
				{
					g.drawImage(getCurrentRound().bullet1.getImage(), getCurrentRound().bullet1.getXCoordinates(),getCurrentRound().bullet1.getYCoordinates(), this);
					getCurrentRound().bullet1.moveUp();			
			
				}
				else 
				{
					getCurrentRound().player1.changeShootingState(false);
					getCurrentRound().bullet1.changeYCoordinates(380);
				}
				 
			}	
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

}
