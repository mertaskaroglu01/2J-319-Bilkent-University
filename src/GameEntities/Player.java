package GameEntities;

/*
import java.awt.Color;
import java.awt.Polygon;
*/

public class Player extends GameObject {
	
	int weaponType;
	int pos;
	
	boolean isShooting;
	int score;
	
	Player( int playerId) {
		if( playerId == 1)
			pos = 300;
		else if( playerId == 2 ) 
			pos = 600;
		
		isShooting =  false;
		score = 0;
	}
	
	
	
	public void changeWeaponType( int weaponId) {
		
	}
	
}
