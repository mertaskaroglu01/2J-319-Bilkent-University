package GameManagement;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

import GameEntities.*;
import UserInterface.GamePanel.TimerListener;

public class GameEngine {

	Round round;
	SoundManager soundManager;
	int lives;
	int p1Time, p2Time;
	private Timer timer = new Timer(17, new TimerListener());
	
	GameEngine() throws Exception {	
		soundManager = new SoundManager();
		round = new Round();
		lives = 5;
		p1Time = 0;
		p2Time = 0;
		timer.start();
	}
	
	public SoundManager getSoundManager() {
		return this.soundManager;
	}
	public Round getCurrentRound() {
		return round;
	}
	
	public boolean bubblesLeft() {
		return( !(round.getBubbles().size() == 0));
	}
	
	public int getRemainingLives() {
		return lives;
	}
	
	public void setLives( int l) {
		lives = l;
	}
	/*
	public void decrementLives() {
		lives--;
	}
	*/
	
	public void updateScore(int playerId, int bubbleType) {
		if(playerId == 1) {
			if( bubbleType == 0)
				round.getPlayer(1).updateScore(10);
			else if( bubbleType == 1)
				round.getPlayer(1).updateScore(20);
			else
				round.getPlayer(1).updateScore(50);
		}
		else {
			if( bubbleType == 0)
				round.getPlayer(2).updateScore(10);
			else if( bubbleType == 1)
				round.getPlayer(2).updateScore(20);
			else
				round.getPlayer(2).updateScore(50);
		}
			
	}
	
	public void updatePlayerLocations(int posP1, int posP2) {
		round.getPlayer(1).changeXCoordinates(posP1);
		round.getPlayer(2).changeXCoordinates(posP2);
	}
	
	public int getPlayerLocation( int playerId) {
		if( playerId == 1)
			return round.getPlayer(1).getXCoordinates();
		else
			return round.getPlayer(2).getXCoordinates();
	}
	
	public void handlePlayerBubbleCollision() throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		/*
		if(getCurrentRound().getPlayer(1) != null && getCurrentRound().getPlayer(2) != null)
		{
			int p1xPos = getCurrentRound().getPlayer(1).getXCoordinates();
			int p1yPos = getCurrentRound().getPlayer(1).getYCoordinates();
			int p2xPos = getCurrentRound().getPlayer(2).getXCoordinates();
			int p2yPos = getCurrentRound().getPlayer(2).getYCoordinates();
			for(int i = 0; i < getCurrentRound().getNoOfBubbles();i++)
			{
				Bubble checker = getCurrentRound().getBubble(i);
				if((p1xPos < checker.getXCoordinates() && p1xPos + 30 > checker.getXCoordinates()) &&( p1yPos > checker.getYCoordinates() && p1yPos - 30 < checker.getYCoordinates()))
				{
					getCurrentRound().getPlayer(1).setLives(-1); 
					System.out.println("Vurldum");
					if(getCurrentRound().getPlayer(1).getLives() <= 0)
						return -1;
					return 1;
				}
				if((p2xPos  < checker.getXCoordinates() && p2xPos + 30 > checker.getXCoordinates()) &&( p2yPos  > checker.getYCoordinates() && p2yPos - 30 < checker.getYCoordinates()))
				{
					getCurrentRound().getPlayer(2).setLives(-1);
					System.out.println("Vuruldum");
						
					if(getCurrentRound().getPlayer(2).getLives() <= 0)
						return -1;
					return 1;
				}
				
			}
			
		}
		*/
		
		Rectangle p1Rect = getCurrentRound().getPlayer(1).getBounds();
		Rectangle p2Rect = getCurrentRound().getPlayer(2).getBounds();
		
		for(int i = 0; i < getCurrentRound().getNoOfBubbles();i++)
		{
			Rectangle bubbleRect = getCurrentRound().getBubble(i).getBounds();
			if( bubbleRect.intersects(p1Rect) && p1Time >40) {
				lives--; 
				System.out.println("P1 Shot");
				p1Time = 0;
				this.getSoundManager().play(2);
				/*
				if(getCurrentRound().getPlayer(1).getLives() <= 0)
					return -1;
				return 1;
				*/
			}
			if( bubbleRect.intersects(p2Rect) && p2Time > 40) {
				lives--;
				System.out.println("P2 Shot");
				p2Time = 0;
				this.getSoundManager().play(2);
				/*
				if(getCurrentRound().getPlayer(2).getLives() <= 0)
					return -1;
				return 1;
				*/
			}
		}
		//return 0;
		//return false;
	}
	
	public void handleBubbleWallCollision() {
		for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) {
			Bubble temp = round.getBubble(i);
			if( temp.getXCoordinates() < 0) {
				switch( temp.getDirection() ) {
					case 5: temp.changeDirection(3);
					break;
					case 6: temp.changeDirection(2);
					break;
					case 7: temp.changeDirection(1);
					break;
					case 8: temp.changeDirection(12);
					break;
					case 9: temp.changeDirection(11);
					break;
				}
			}
			if( temp.getYCoordinates() < 0) {
				switch( temp.getDirection() ) {
					case 2: temp.changeDirection(12);
					break;
					case 3: temp.changeDirection(11);
					break;
					case 4: temp.changeDirection(10);
					break;
					case 5: temp.changeDirection(9);
					break;
					case 6: temp.changeDirection(8);
					break;
				}
			}
			if( temp.getXCoordinates() > 1160) {
				switch( temp.getDirection() ) {
					case 3: temp.changeDirection(5);
					break;
					case 2: temp.changeDirection(6);
					break;
					case 1: temp.changeDirection(7);
					break;
					case 12: temp.changeDirection(8);
					break;
					case 11: temp.changeDirection(9);
					break;
				}
			}
			if( temp.getYCoordinates() > 520) {
				switch( temp.getDirection() ) {
					case 8: temp.changeDirection(6);
					break;
					case 9: temp.changeDirection(5);
					break;
					case 10: temp.changeDirection(4);
					break;
					case 11: temp.changeDirection(3);
					break;
					case 12: temp.changeDirection(2);
					break;
				}
			}
		}
	}
	
	public void handleBubbleMirrorCollision() {
		for(int i = 0; i < getCurrentRound().getMirrors().size(); i++)
		  {
			Rectangle mirrorRect = getCurrentRound().getMirrors().get(i).getBounds();
			for( int j = 0; j < getCurrentRound().getNoOfBubbles(); j++ ) { 
				Rectangle bubbleRect = getCurrentRound().getBubble(j).getBounds();
				if( bubbleRect.intersects(mirrorRect)) {
					getCurrentRound().getMirrors().get(i).teleport(getCurrentRound().getBubble(j));
		    }
		    
		   }
		  }
	}
	
	
	public void handleBulletBubbleCollision() throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		/*
		if( getCurrentRound().getBullet(1) != null && getCurrentRound().getBullet(2) != null) {
			int b1xPos = getCurrentRound().getBullet(1).getXCoordinates();
			int b1yPos = getCurrentRound().getBullet(1).getYCoordinates();
			int b2xPos = getCurrentRound().getBullet(2).getXCoordinates();
			int b2yPos = getCurrentRound().getBullet(2).getYCoordinates();
			for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) { 
				Bubble temp = getCurrentRound().getBubble(i);
				int xPos = temp.getXCoordinates();
				int yPos = temp.getYCoordinates();
				if( b1xPos > (xPos) && b1xPos < (xPos + 30) && b1yPos > (yPos) && b1yPos < (yPos + 30)) {
					int type = temp.getBubbleType();
					updateScore(1, type);
					getCurrentRound().getBubbles().remove(i);
					System.out.println("Score of player 1: " + getCurrentRound().getPlayer(1).getScore() + " Score of Player 2: " + getCurrentRound().getPlayer(2).getScore());
				}
				if( b2xPos > (xPos) && b2xPos < (xPos + 30) && b2yPos > (yPos) && b2yPos < (yPos + 30)) { 
					int type = temp.getBubbleType();
					updateScore(2, type);
					getCurrentRound().getBubbles().remove(i);
					System.out.println("Score of player 1: " + getCurrentRound().getPlayer(1).getScore() + " Score of Player 2: " + getCurrentRound().getPlayer(2).getScore());
				}
			}
		}
		*/
		if( getCurrentRound().getBullet(1) != null && getCurrentRound().getBullet(1).getYCoordinates() < 480) {
			Rectangle b1Rect = getCurrentRound().getBullet(1).getBounds(); 
			for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) { 
				Rectangle bubbleRect = getCurrentRound().getBubble(i).getBounds();
				if( b1Rect.intersects(bubbleRect)) {
					int type = getCurrentRound().getBubble(i).getBubbleType();
					updateScore(1, type);
					this.getSoundManager().play(3);
					getCurrentRound().getBubbles().remove(i);
					System.out.println("Score of player 1: " + getCurrentRound().getPlayer(1).getScore() + " Score of Player 2: " + getCurrentRound().getPlayer(2).getScore());
				}
				
			}
		}
		if( getCurrentRound().getBullet(2) != null && getCurrentRound().getBullet(2).getYCoordinates() < 480) {

			Rectangle b2Rect = getCurrentRound().getBullet(2).getBounds();
			for( int i = 0; i < getCurrentRound().getNoOfBubbles(); i++ ) {
				Rectangle bubbleRect = getCurrentRound().getBubble(i).getBounds();
				if( b2Rect.intersects(bubbleRect)) {
					int type = getCurrentRound().getBubble(i).getBubbleType();
					updateScore(2, type);
					this.getSoundManager().play(3);
					getCurrentRound().getBubbles().remove(i);
					System.out.println("Score of player 1: " + getCurrentRound().getPlayer(1).getScore() + " Score of Player 2: " + getCurrentRound().getPlayer(2).getScore());
				}
			}
		}
		
	//sssssssssssssss
	
	}
	
	public void handleCollisions() throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		handleBulletBubbleCollision();
		handleBubbleWallCollision();
		handlePlayerBubbleCollision();
		handleBubbleMirrorCollision();
	}
	
	public class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			p1Time++;
			p2Time++;
		}
		
	}
}
