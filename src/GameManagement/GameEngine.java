package GameManagement;

import java.awt.image.BufferedImage;

import GameEntities.*;

public class GameEngine {
	
	Round round;
	SoundManager soundManager;
	int lives;
	
	GameEngine() throws Exception {
		round = new Round(1);
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
	
	public void handlePlayerBubbleCollision() {
		
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
		
	}
	
	public void handleBulletBubbleCollision() {
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
	}
	
	public void checkCollision() {
		
	}
	
	public void changeRound() {
		
	}
	
}
