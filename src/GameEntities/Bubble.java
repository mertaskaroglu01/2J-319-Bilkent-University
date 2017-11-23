package GameEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Bubble extends GameObject {

	public final BufferedImage blueBubbleImage;
	public final BufferedImage greenBubbleImage;
	public final BufferedImage redBubbleImage;
	int speed;
	int points;
	int bubbleType;
	 
	public Bubble() throws IOException {
		Random rand = new Random();
		 
		x = rand.nextInt(500) + 1;
		y = rand.nextInt(140) + 1;
		blueBubbleImage = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\BlueBubble.png"));
		greenBubbleImage = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\GreenBubble.png"));
		redBubbleImage = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\RedBubble.png"));
	}

	public int getBubbleType() {
		return bubbleType;
	}
	
	public void changeSpeed( int roundId) {
		
	}
    
	public BufferedImage getImage(int bubbleType) {
		if( bubbleType == 0)
			return redBubbleImage;
		else if( bubbleType == 1)
			return blueBubbleImage;
		else
			return greenBubbleImage;
		
	}
	   
}
    