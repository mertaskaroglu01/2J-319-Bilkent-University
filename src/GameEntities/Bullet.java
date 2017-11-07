package GameEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends GameObject {
	public final BufferedImage bullet1Image;
	
	public Bullet() throws IOException
	{
		 bullet1Image = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\bullet.png"));
	}

}
