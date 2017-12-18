package GameEntities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Round {
	ArrayList<GameObject>[] gameObjects;
	ArrayList<Bubble> bubbles;
	ArrayList<Mirror> mirrors;
	public Bullet bullet1;
	public Bullet bullet2;
	public Player player1;
	public Player player2;
	int roundNumber;
	
	public Round() throws Exception {
		roundNumber = 1;
		createCharacter(1);
		createCharacter(2);
		//createBullet(1);
		//createBullet(2);
		mirrors = new ArrayList<Mirror>();
		bubbles = new ArrayList<Bubble>();
		createRedBubble();
		createMirror();
		//createGreenBubble();
		createBlueBubble();
		
	}
	
	public ArrayList<Mirror> getMirrors()
	{
		return mirrors;
	}
	
	public int getNoOfMirrors()
	{
		return mirrors.size();
	}
	
	public int getRoundNumber() {
		return roundNumber;
	}
	
	/*
	public void changeRound() {
		roundNumber++;
	}
	*/
	
	
	public void createBullet( int playerId, int bulletType) throws IOException{
		if( playerId == 1)
			bullet1 = new Bullet( player1.getXCoordinates(), bulletType );
		else if (playerId == 2)
			bullet2 = new Bullet( player2.getXCoordinates(), bulletType);
	}
	
	public void removeBullet(int bulletId) {
		if( bulletId == 1)
			bullet1 = null;
		else if (bulletId == 2)
			bullet2 = null;
	}
	public void createMirror() throws IOException {
		  mirrors.add(new Mirror());
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
	
	public void removeCharacter( int playerId) {
		if( playerId == 1)
			player1 = null;
		else if (playerId == 2)
			player2 = null;
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
	
	/*
	public int getLives() {
		return lives;
	}
	
	public void addLives() {
		lives = lives + 3;
	}
	
	public void removeLives() {
		lives--;
	}
	*/
	
	public void startGameAgain() throws Exception {
		roundNumber = 1;
			bubbles.clear();
			mirrors.clear();
		
		removeBullet(1);
		removeBullet(2);
		removeCharacter(1);
		removeCharacter(2);
		createCharacter(1);
		createCharacter(2);
		createBullet(1, player1.getWeaponType());
		createBullet(2, player2.getWeaponType());
		createRedBubble();
		createBlueBubble();
		createMirror();
	}
	
	public void moveToNextRound() throws IOException {
		roundNumber++;
		bubbles.clear();
		mirrors.clear();
		
		removeBullet(1);
		removeBullet(2);
		
		createBullet(1, player1.getWeaponType());
		createBullet(2, player2.getWeaponType());
		
		if( roundNumber == 2) {
			for(int i = 0; i < 1; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 1; i++) {
				createMirror();
			}
		}
		if( roundNumber == 3) {
			for(int i = 0; i < 2; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 1; i++) {
				createMirror();
			}
		}
		if( roundNumber == 4) {
			for(int i = 0; i < 2; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 2; i++) {
				createMirror();
			}
		}
		if( roundNumber == 5) {
			for(int i = 0; i < 3; i++)
			{
				createRedBubble();
				//createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 2; i++) {
				createMirror();
			}
		}
		if( roundNumber == 6) {
			for(int i = 0; i < 3; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 2; i++) {
				createMirror();
			}
		}
		if( roundNumber == 7) {
			for(int i = 0; i < 3; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 3; i++) {
				createMirror();
			}
		}
		if( roundNumber == 8) {
			for(int i = 0; i < 4; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 3; i++) {
				createMirror();
			}
		}
		if( roundNumber == 9) {
			for(int i = 0; i < 4; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 4; i++) {
				createMirror();
			}
		}
		if( roundNumber == 10) {
			for(int i = 0; i < 5; i++)
			{
				createRedBubble();
				createGreenBubble();
				createBlueBubble();
			}
			for( int i = 0; i < 4; i++) {
				createMirror();
			}
		}
	}
	
}