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
