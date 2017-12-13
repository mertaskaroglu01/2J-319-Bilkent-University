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
	public Player player2;
	int roundNumber;
	
	public Round(int roundNumber) throws Exception {
		this.roundNumber = roundNumber;
		createCharacter(1);
		createCharacter(2);
		//createBullet(1);
		//createBullet(2);
		bubbles = new ArrayList<Bubble>();
		if( roundNumber == 1) {
			for(int i = 0; i < 2; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
		}
		if( roundNumber == 2) {
			for(int i = 0; i < 3; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
		}
		if( roundNumber == 3) {
			for(int i = 0; i < 4; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
		}
		
	}
	public int getRoundNumner() {
		return roundNumber;
	}
	public void createBullet( int playerId, int bulletType) throws IOException{
		if( playerId == 1)
			bullet1 = new Bullet( player1.getXCoordinates(), bulletType );
		else if (playerId == 2)
			bullet2 = new Bullet( player2.getXCoordinates(), bulletType);
	}
	
	public void removeBullet(Bullet bullet) {
		
	}
	
	public void createRedBubble() throws IOException {
		bubbles.add( new RedBubble() );
	}
	
	public void createGreenBubble() throws IOException {
		bubbles.add( new GreenBubble() );
	}
	
	public void createBlueBubble( ) throws IOException {
		bubbles.add( new BlueBubble() ); 
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
	
	public int getNoOfBubbles() {
		return bubbles.size();
	}
	
	public Bubble getBubble( int index) {
		return bubbles.get(index);
	  
	}
	
	public ArrayList<Bubble> getBubbles() {
		return bubbles; 
	}
	
	public Player getPlayer( int playerId) {
		if( playerId == 1)
			return player1;
		else
			return player2;
	}
	
	public Bullet getBullet( int playerId) {
		if( playerId == 1)
			return bullet1;
		else
			return bullet2;
	}
}