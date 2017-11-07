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
	public int pos;	
	public boolean isShooting;
	int score;
    public final BufferedImage image;
	
	Player( int playerId) throws Exception {
		
		File imageFile = new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\Paper_Ninja.png");
        this.image = ImageIO.read(imageFile);
        
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
