package GameManagement;

import java.awt.image.BufferedImage;

import GameEntities.*;

public class GameEngine {
	
	public Round round;
	public Bullet bullet;
	SoundManager soundManager;
	public int lives;
	
	GameEngine() throws Exception {
		round = new Round(1);
		bullet = new Bullet();
	}
	
	public void getRoundInfo() {
		
	}
	
	public void drawRound() {
	    
	}
	
	public boolean bubblesLeft() {
		return true;
	}
	
	public int getRemainingLives() {
		return 0;
	}
	
	public int getCurrentRound() {
		return 0;
	}
	
	public void updateP1Score(int score) {
		
	}
	
	public void updateP2Score(int score) {
		
	}
	
	public void updatePlayerLocations(int posP1, int pusP2) {
		
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
