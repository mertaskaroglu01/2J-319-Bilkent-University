package GameManagement;

public class GameManager {
	
	private boolean paused;
	public GameEngine gameEngine;
	
	public GameManager() throws Exception {
		this.gameEngine = new GameEngine();
	}
	
	public void gameLoop() {
		
	}
	
	public boolean livesRemaining() {
		return true;
	}
	
	public boolean endRound() {
		return true;
	}
	
	public void startGame() {
	}
	
	public void resumeGame() {
		
	}
	
	public boolean isHighScore(int score) {
		return true;
	}
	
	public void isGameEnd() {
		
	}
	
}
