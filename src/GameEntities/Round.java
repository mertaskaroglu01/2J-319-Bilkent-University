package GameEntities;

import java.io.IOException;
import java.util.ArrayList;

public class Round {
	ArrayList<GameObject>[] gameObjects;
	ArrayList<Bubble> bubbles;
	ArrayList<Mirror> mirrors;
	public Bullet bullet1;
	public Bullet bullet2;
	public Player player1;
	Player player2;
	int roundNumber;
	
	public Round(int roundNumber) throws Exception {
		this.roundNumber = roundNumber;
		createCharacter(1);
		//createCharacter(2);
		//createBullet(1);
		//createBullet(2);
	}
	
	public void createBullet( int playerId) throws IOException{
		if( playerId == 1)
			bullet1 = new Bullet( player1.getXCoordinates() );
		else if (playerId == 2)
			bullet2 = new Bullet( player2.getXCoordinates() );
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
	
	public void createCharacter( int playerId) throws Exception {

		if( playerId == 1)
			player1 = new Player(1);
		else if (playerId == 2)
			player2 = new Player(2);
		
	}
	
	public void reflectBubble( Bubble bubble, Mirror mirror) {
		
	}
	
	public void reflectBubble( Bubble bubble) {
		
	}
	
	public void updateWeapon( Player player) {
		
	}
	
}
