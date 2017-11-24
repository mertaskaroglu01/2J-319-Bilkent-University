package GameEntities;


import java.awt.Color;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	
	int weaponType;
	boolean isShooting;
	int score;
    final BufferedImage image;
	
	Player( int playerId) throws Exception {
		
		File imageFile = new File("C:\\Users\\serha\\git\\2J-BubblePopper\\pictures\\Paper_Ninja.png");
        this.image = ImageIO.read(imageFile);
        
        y = 255;
        
		if( playerId == 1)
			x = 300;
		else if( playerId == 2 ) 
			x = 350;
		
		isShooting =  false;
		score = 0;
	}
	
	public void shoot() {
		isShooting = true;
	}
	
	public void goRight() {
		if( x <535)
			x = x + 20;
		else  
			x = 535;
	}
	
	public void goLeft() {
		if( x > 19 )
			x = x -20;
		else
			x = 0;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public boolean isShooting() {
		return isShooting;
	}
	
	public void changeShootingState( boolean temp) {
		isShooting = temp;
	}
	public void changeWeaponType( int weaponId) {
		 
	}
	
	public void updateScore( int x) {
		score = score + x;
	}
	
}
