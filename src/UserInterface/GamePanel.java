package UserInterface;
import java.awt.Font;
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
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import GameEntities.Round;
import GameManagement.GameEngine;

//import com.sun.javafx.tk.Toolkit;

import GameManagement.GameManager;

public class GamePanel extends JPanel   {

	GameManager gameManager;
	private Timer timer = new Timer(17, new TimerListener());
	int time;
	JLabel lives;
	JLabel p1Scores;
	JLabel p2Scores;
	JButton nextLevel;
	Clip backgroundMusic;
	boolean paused, alerted, startNext, startTimer;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public GamePanel() throws Exception {
		startTimer = false;
		alerted = false;
		paused  = false;
		//ended = false;
		startNext = false;
		//addKeyListener(this);
		lives = new JLabel("Lives = 5");
		p1Scores = new JLabel();
		p2Scores = new JLabel();
		nextLevel = new JButton();
		add(lives);
		add(p1Scores);
		add(p2Scores);
		addKeyBindingPressed(this,KeyEvent.VK_A,"P1LeftPressed",(evt) -> {
			//getCurrentRound().getPlayer(1).goLeft();
			if( getCurrentRound().getPlayer(1).getXCoordinates() < 0)
				getCurrentRound().getPlayer(1).setVel(0);
			else
				getCurrentRound().getPlayer(1).setVel(-8);
			//repaint();
		});
		addKeyBindingReleased(this,KeyEvent.VK_A,"P1LeftReleased",(evt) -> {
			//getCurrentRound().getPlayer(1).goLeft();
			getCurrentRound().getPlayer(1).setVel(0);
			//repaint();
		});
		addKeyBindingPressed(this,KeyEvent.VK_D,"P1RightPressed",(evt) -> {
			if(getCurrentRound().getPlayer(1).getXCoordinates() > 1137)
				getCurrentRound().getPlayer(1).setVel(0);
			else
				getCurrentRound().getPlayer(1).setVel(8);
		});
		addKeyBindingReleased(this,KeyEvent.VK_D,"P1RightReleased",(evt) -> {
			//getCurrentRound().getPlayer(1).goRight();
			getCurrentRound().getPlayer(1).setVel(0);
    		//repaint();     
		});
		addKeyBindingPressed(this,KeyEvent.VK_W,"P1Fire",(evt) -> {
			if( !getCurrentRound().getPlayer(1).isShooting() ) {
        		try {
        			getCurrentRound().createBullet(1,  getCurrentRound().getPlayer(1).getWeaponType());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
        		getCurrentRound().getPlayer(1).shoot();	
        	}                	
		});
		
		addKeyBindingPressed(this,KeyEvent.VK_LEFT,"P2LeftPressed",(evt) -> {
			if( getCurrentRound().getPlayer(2).getXCoordinates() < 0)
				getCurrentRound().getPlayer(2).setVel(0);
			else
				getCurrentRound().getPlayer(2).setVel(-8);
			repaint();
		});
		addKeyBindingReleased(this,KeyEvent.VK_LEFT,"P2LeftReleased",(evt) -> {
			getCurrentRound().getPlayer(2).setVel(0);;
			repaint();
		});
		addKeyBindingPressed(this,KeyEvent.VK_RIGHT,"P2RightPressed",(evt) -> {
			if(getCurrentRound().getPlayer(2).getXCoordinates() > 1137)
				getCurrentRound().getPlayer(2).setVel(0);
			else
				getCurrentRound().getPlayer(2).setVel(8);
			repaint();
		});
		addKeyBindingReleased(this,KeyEvent.VK_RIGHT,"P2RightReleased",(evt) -> {
			getCurrentRound().getPlayer(2).setVel(0);
			repaint();
		});
		addKeyBindingPressed(this,KeyEvent.VK_UP,"Fire",(evt) -> {
				if( !getCurrentRound().getPlayer(2).isShooting() ) {
	        		try {
	        			getCurrentRound().createBullet(2, getCurrentRound().getPlayer(2).getWeaponType());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
	        		getCurrentRound().getPlayer(2).shoot();	
	        	}		
		});
		
		addKeyBindingPressed(this,KeyEvent.VK_P,"Pause",(evt) -> {
			if( !paused) {
				timer.stop();
				paused = true;
			}
			else {
				timer.start();
				paused = false;
			}
		});
		time = 0;
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
	    this.gameManager = new GameManager();	
		this.setVisible(true);
		
		lives.setFont(new Font("Courier New", Font.BOLD, 22));
		p1Scores.setFont(new Font("Courier New", Font.BOLD, 22));
		p2Scores.setFont(new Font("Courier New", Font.BOLD, 22));
		
		timer.start();
		backgroundMusic = this.getCurrentEngine().getSoundManager().play(1);
	}
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	final BufferedImage background = ImageIO.read(new File("pictures/background.jpg"));
        	getCurrentRound().getPlayer(1).changeXCoordinates(getCurrentRound().getPlayer(1).getXCoordinates() + getCurrentRound().getPlayer(1).getVel());
        	getCurrentRound().getPlayer(2).changeXCoordinates(getCurrentRound().getPlayer(2).getXCoordinates() + getCurrentRound().getPlayer(2).getVel());
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
					g.drawImage(getCurrentRound().getBullet(1).getImage(getCurrentRound().getPlayer(1).getWeaponType()), getCurrentRound().getBullet(1).getXCoordinates(),getCurrentRound().getBullet(1).getYCoordinates(), this);
					getCurrentRound().getBullet(1).moveUp();			
			
				}
				else 
				{
					getCurrentRound().getPlayer(1).changeShootingState(false);
					//getCurrentRound().getPlayer(1).changeYCoordinates(380);
				}
				 
			}
        	//Player2 bullet
        	if(getCurrentRound().getPlayer(2).isShooting() )
			{				
				if( getCurrentRound().getBullet(2).getYCoordinates() > 0)
				{
					g.drawImage(getCurrentRound().getBullet(2).getImage(getCurrentRound().getPlayer(2).getWeaponType()), getCurrentRound().getBullet(2).getXCoordinates(),getCurrentRound().getBullet(2).getYCoordinates(), this);
					getCurrentRound().getBullet(2).moveUp();			
			
				}
				else 
				{
					getCurrentRound().getPlayer(2).changeShootingState(false);
					//getCurrentRound().getPlayer(2).changeYCoordinates(380);
				}
				 
			}
        	// Lives and Scores
        	//lives.setText("Lives = " + getCurrentRound().getLives());
        	p1Scores.setText("     P1 Scores = " + getCurrentRound().getPlayer(1).getScore());
        	p2Scores.setText("     P2 Scores = " + getCurrentRound().getPlayer(2).getScore());
        	//Weapon Change
        	/*
        	if(getCurrentRound().getPlayer(2).getScore() > 10)
        		getCurrentRound().getPlayer(2).changeWeaponType(1);
        	if(getCurrentRound().getPlayer(1).getScore() > 10)
        		getCurrentRound().getPlayer(1).changeWeaponType(1);
        	*/
        	//Bubbles
        	for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) {
        		g.drawImage(getCurrentRound().getBubble(i).getImage(getCurrentRound().getBubble(i).getBubbleType()), getCurrentRound().getBubble(i).getXCoordinates(), getCurrentRound().getBubble(i).getYCoordinates(), this);
        	}
        	// mirrors
        	for( int i = 0; i < getCurrentRound().getNoOfMirrors(); i++ ) {
                g.drawImage(getCurrentRound().getMirrors().get(i).getImage(), getCurrentRound().getMirrors().get(i).getXCoordinates(), getCurrentRound().getMirrors().get(i).getYCoordinates(), this);
            }
        	/*
        	if(getCurrentRound().getNoOfBubbles() == 0)
        	{
        		gameManager.gameEngine.setRound(getCurrentRound().getRoundNumner());
        		for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) {
            		g.drawImage(getCurrentRound().getBubble(i).getImage(getCurrentRound().getBubble(i).getBubbleType()), getCurrentRound().getBubble(i).getXCoordinates(), getCurrentRound().getBubble(i).getYCoordinates(), this);
            	}
        	}
        	*/
        	  
        	//repaint();
			//gameManager.gameEngine.round.player1.pos += 50
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
	
	public GameManager getCurrentManager() {
		return gameManager;
	}
	
	
	public void startNext() {
		startNext = true;
	}
	
	/*@Override
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
		
	}*/
	@SuppressWarnings("serial")
	public void addKeyBindingPressed(JComponent comp,int keyCode, String id, ActionListener lambda)
	{
		InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW );
		ActionMap ap = comp.getActionMap();
		im.put(KeyStroke.getKeyStroke(keyCode,0,false),id);
		ap.put(id, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lambda.actionPerformed(e);
			}
		});
	}
	
	public void addKeyBindingReleased(JComponent comp,int keyCode, String id, ActionListener lambda)
	{
		InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW );
		ActionMap ap = comp.getActionMap();
		im.put(KeyStroke.getKeyStroke(keyCode,0,true),id);
		ap.put(id, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lambda.actionPerformed(e);
			}
		});
	}
	public class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			time++;
			if( time > 0 && startTimer) {
				getCurrentEngine().handleBubbleWallCollision();
				for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) {
	        		getCurrentRound().getBubble(i).move();
	        	}
				try {
					getCurrentEngine().handleCollisions();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				lives.setText("Live	s: " + getCurrentEngine().getRemainingLives());
				if(gameManager.isRoundEnd() && !alerted && !gameManager.isGameEnd()) {
					
					Menu.endOfRound();
					alerted = true;
					getCurrentRound().getPlayer(1).changeShootingState(false);
					getCurrentRound().getPlayer(2).changeShootingState(false);
					if( getCurrentRound().getRoundNumber() == 3 || getCurrentRound().getRoundNumber() == 6 || getCurrentRound().getRoundNumber() == 9) {
						getCurrentEngine().setLives(getCurrentEngine().getRemainingLives() + 3);
					}
					getCurrentRound().getPlayer(1).setVel(0);
					getCurrentRound().getPlayer(2).setVel(0);
					try {
						Clip round_end_music = getCurrentEngine().getSoundManager().play(4);
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
				}
				if(gameManager.isGameEnd() && !alerted) {
					Menu.endOfGame();
					alerted = true;
				}
				
				if( startNext) {
					try {
						gameManager.startNewRound();
					} catch (Exception e1) {
						// TODO Auto-generated catch blocks
						e1.printStackTrace();
					}
					startNext = false;
					alerted = false;
				}
				
			}
			repaint();
		}
		
	}
	
	public void startTimer() {
		startTimer = true;
	}
	
	public void stopTimer() {
		startTimer = false;
	}
	
	public void changeAlertState() {
		if(!alerted)
			alerted = true;
		else
			alerted = false;
	}

}
