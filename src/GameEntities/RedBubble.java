package GameEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RedBubble extends Bubble {

	public final BufferedImage RedBubbleImage;
	
	RedBubble() throws IOException {
		points = 10;
		bubbleType  = 0;
		
		RedBubbleImage = ImageIO.read(new File("C:\\Users\\serha\\git\\2J-BubblePopper\\RedBubble.png"));
		
	}
	
	public BufferedImage getImage() {
		return RedBubbleImage;
	}

}
