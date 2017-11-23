package GameEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends GameObject {
	public final BufferedImage bulletImage;
	
	public Bullet(int xPos) throws IOException
	{
		x = xPos;
		y = 270;
		bulletImage = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\bullet.png"));
		
	}
	
	public BufferedImage getImage() {
		return bulletImage;
	}
	
	public void moveUp() {
		y = y - 2;
	}
	
}
