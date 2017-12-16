package GameManagement;

import GameEntities.Round;

public class GameManager {
	
	private final int MAX_ROUND_NUMBER = 10;
	private boolean paused;
	public GameEngine gameEngine;
	
	public GameManager() throws Exception {
		this.gameEngine = new GameEngine();
	}
	
	public void gameLoop() {
		
	}

	public boolean livesRemaining() {
		return gameEngine.getCurrentRound().getLives() == 0;
	}
	
	public void endRound() {
		
	}
	
	public void startNewRound() throws Exception {
		gameEngine.getCurrentRound().getPlayer(1).upgrade();
		gameEngine.getCurrentRound().getPlayer(2).upgrade();
		gameEngine.getCurrentRound().moveToNextRound();
	}
	
	public void resumeGame() {
		
	}
	
	public void pauseGame() {
		
	}
	
	public boolean isHighScore(int score) {
		return true;
	}
	
	public boolean isRoundEnd() {
		if(gameEngine.getCurrentRound().getNoOfBubbles() == 0 ) {
			return true;
		}
		else
			return false;
	}
	
	public boolean isGameEnd() {
		return !livesRemaining() || gameEngine.getCurrentRound().getRoundNumber() != MAX_ROUND_NUMBER;
	}
	
}
