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
    final BufferedImage image1, image2;
    int vel;
	
	Player( int playerId) throws Exception {
		weaponType = 1;
		File imageFile = new File("pictures/Paper_Ninja.png");
        this.image1 = ImageIO.read(imageFile);
        File imageFile2 = new File("pictures/Paper_Ninja_2.png");
        this.image2 = ImageIO.read(imageFile2);
        
        y = 480;
        
		if( playerId == 1)
			x = 500;
		else if( playerId == 2 ) 
			x = 800;
		
		isShooting =  false;
		score = 0;
		width = 60;
		height = 73;
	}
	
	public void shoot() {
		isShooting = true;
	}
	
	public void goRight() {
		if( x < 1137)
			x = x + 10;
		else  
			x = 1137;
	}
	
	public void goLeft() {
		if( x > 9 )
			x = x - 10;
		else
			x = 0;
	}
	
	public BufferedImage getImage(int playerId) {
		if( playerId == 1)
			return image1;
		else
			return image2;
	}
	
	public boolean isShooting() {
		return isShooting;
	}
	
	public void changeShootingState( boolean temp) {
		isShooting = temp;
	}
	public void changeWeaponType( int weaponId) {
		 weaponType = weaponId;
	}
	public int getWeaponType() {
		return weaponType;
	}
	public void updateScore( int x) {
		score = score + x;
	}
	
	public int getScore() {
		return score;
	}
	
	public void upgrade() {
		if( score > 150) {
			changeWeaponType( 2);
			if( score > 300)
				changeWeaponType(3);
		}
		
	}
	
	/*
	public int getLives() {
		return lives;
	}
	public void setLives(int change) {
		lives = lives + change;
	}
	*/
	
	public void setVel( int vel) {
		this.vel = vel;
	}
	
	public int getVel() {
		return vel;
	}
	
}
