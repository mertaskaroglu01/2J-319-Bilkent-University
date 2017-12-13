package GameEntities;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	
	int x;
	int y;
	int width;
	int height;
	
	/*
	public void drawObject( Graphics g, int posX, int posY) {
		
	}
	*/
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void changeWidhth( int w) {
		width = w;
	}
	
	public void changeHeight( int h) {
		height = h;
	}
	
	public int getXCoordinates() {
		return x;
	}
	
	public int getYCoordinates() {
		return y;
	}
	
	public void changeXCoordinates( int xPos) {
		x = xPos;
	}
	public void changeYCoordinates( int yPos) {
		y = yPos;
	}
	
	public Rectangle getBounds() {
		return new Rectangle( x, y, width, height);
	}
	
}
