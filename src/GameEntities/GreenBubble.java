package GameEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GreenBubble extends Bubble {

	
	public final BufferedImage greenBubbleImage;

	GreenBubble() throws IOException {
		bubbleType = 2;
		points = 50;
		
		greenBubbleImage = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\GreenBubble.png"));
	}
	
	public BufferedImage getImage() {
		return greenBubbleImage;
	}
}
