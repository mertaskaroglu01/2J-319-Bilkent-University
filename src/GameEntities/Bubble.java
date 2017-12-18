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
	int movingDirection;
	 
	public Bubble() throws IOException {
		Random rand = new Random();
		
		x = rand.nextInt(1170) + 1;
		y = rand.nextInt(300) + 30;
		blueBubbleImage = ImageIO.read(new File("pictures/BlueBubble.png"));
		greenBubbleImage = ImageIO.read(new File("pictures/GreenBubble.png"));
		redBubbleImage = ImageIO.read(new File("pictures/RedBubble.png"));

		movingDirection = rand.nextInt(12) + 1;
		while( movingDirection == 1 || movingDirection == 4 || movingDirection == 7 || movingDirection == 10) {
			movingDirection = rand.nextInt(12) + 1;
		}
		
		width = 28;
		height = 28;
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
	
	public int getDirection() {
		return movingDirection;
	}
	
	public void changeDirection( int direction) {
		movingDirection = direction;
	}
	
	public void move() {
		switch ( movingDirection) {
			case 1: x = x + 8;
				    break;
			case 2: x = x + 6;
					y = y -3;
					break;
			case 3: x = x + 3;
					y = y - 6;
						break;
			case 4: y = y -8;
						break;
			case 5: x = x - 3;
					y = y - 6;
						break;
			case 6: x = x - 6;
					y = y - 3;
						break;
			case 7: x = x - 8;
						break;
			case 8: x = x - 6;
					y = y + 3;
					break;
			case 9: x = x - 3;
					y = y + 6;
					break;
			case 10:y = y + 8;
					break;
			case 11: x = x + 3;
					y = y + 6;
					break;
			case 12: x = x + 6;
					y = y + 3;
					break;
		}
	}
	
	   
}
    