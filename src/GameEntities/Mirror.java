package GameEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Mirror extends GameObject {
 
	 int direction;
	 public final BufferedImage mirrorImage;
	 public Mirror() throws IOException {
		  Random rand = new Random();
		  height = 49;
		  width  = 45;
		  x = rand.nextInt(1150) + 1;
		  y = rand.nextInt(300) + 50;
		  mirrorImage = ImageIO.read(new File("pictures/mirror.png"));
	 
	 }
	 //sdsadsasadsaas
	 public int getDirection() {
		 return direction;
	 }
	 public BufferedImage getImage() {
		 return  mirrorImage;
	 }
	 public void teleport(Bubble bubble)
	 {
		  Random rand = new Random();
		  int xPos = rand.nextInt(1170) + 1;
		  int yPos = rand.nextInt(300) + 30;
		  int movingDirection = rand.nextInt(12) + 1;
		  while( movingDirection == 1 || movingDirection == 4 || movingDirection == 7 || movingDirection == 10) {
				movingDirection = rand.nextInt(12) + 1;
		 }
		  bubble.changeDirection(movingDirection);
		  bubble.changeXCoordinates(xPos);
		  bubble.changeYCoordinates(yPos);
		  System.out.println("Bubble is teleported");
	 } 

}
