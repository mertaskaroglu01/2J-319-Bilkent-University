package GameEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends GameObject {
	public final BufferedImage bulletImage;
	public final BufferedImage rocketImage;
	int bulletType;
	
	public Bullet(int xPos, int bType) throws IOException
	{
		x = xPos;
		y = 480;
		bulletImage = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\pictures\\bullet.png"));
		rocketImage = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\pictures\\rocket.png"));
		
		bulletType = bType;
		
		width = 15;
		if( bulletType == 1)
			height = 15;
		if( bulletType == 2)
			height = 30;
	}
	
	public BufferedImage getImage(int bulletType) {
		if(bulletType == 1)
			return bulletImage;
		else if(bulletType == 2)
			return rocketImage; 
		return null;
	}
	
	public void moveUp() {
		if(bulletType == 1)
		y = y - 15;
		if(bulletType == 2)
		y = y - 25;	
	}
	
	public int getBulletType() {
		return bulletType;
	}
	
	public void changeBulletType( int bType) {
		bulletType = bType;
	}
	
}
