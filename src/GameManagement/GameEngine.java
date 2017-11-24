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
			if( temp.getXCoordinates() > 560) {
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
			if( temp.getYCoordinates() > 290) {
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
	
	public void handleBulletMirrorCollision() {
		
	}
	
	public void checkCollision() {
		
	}
	
	public void changeRound() {
		
	}
	
}
