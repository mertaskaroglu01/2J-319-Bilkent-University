package GameEntities;

import java.util.ArrayList;

public class Round {
	ArrayList<GameObject>[] gameObjects;
	ArrayList<Bubble> bubbles;
	ArrayList<Mirror> mirrors;
	ArrayList<Bullet> bullets;
	public Player player1;
	Player player2;
	int roundNumber;
	
	public Round(int roundNumber) throws Exception {
		this.roundNumber = roundNumber;
		player1 = new Player(1);
	}
	
	public void createBullet( int playerId) {
		
	}
	
	public void removeBullet(Bullet bullet) {
		
	}
	
	public Bubble createRedBubble() {
		
	}
	
	public Bubble createGreenBubble() {
		
	}
	
	public Bubble createBlueBubble( ) {
		
	}
	
	public void popBubble( Bubble bubble) {
		
	}
	
	public Player createCharacter( int playerId) {
		
	}
	
	public void reflectBubble( Bubble bubble, Mirror mirror) {
		
	}
	
	public void reflectBubble( Bubble bubble) {
		
	}
	
	public void updateWeapon( Player player) {
		
	}
	
}
