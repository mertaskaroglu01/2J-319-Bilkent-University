package GameEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends GameObject {
	public final BufferedImage bulletImage;
	public final BufferedImage rocketImage;
	
	public Bullet(int xPos) throws IOException
	{
		x = xPos;
		y = 480;
		bulletImage = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\pictures\\bullet.png"));
		rocketImage = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\pictures\\rocket.png"));
		
	}
	
	public BufferedImage getImage(int bulletType) {
		if(bulletType == 0)
			return bulletImage;
		else if(bulletType == 1)
			return rocketImage; 
		return null;
	}
	
	public void moveUp(int bulletType) {
		if(bulletType == 0)
		y = y - 15;
		if(bulletType == 1)
		y = y - 25;	
	}
	
}
