package GameEntities;

import java.awt.Graphics;

public class GameObject {
	
	int x;
	int y;
	
	public void drawObject( Graphics g, int posX, int posY) {
		
	}
	
	public int getWidth() {
		
	}
	
	public int getHeight() {
		
	}
	
	public int getXCoordinates() {
		return x;
	}
	
	public int getYCoordinates() {
		return y;
	}
	
	public void changeXCoordinates( int x) {
		x = this.x;
	}
	public void changeYCoordinates( int y) {
		y = this.y;
	}
	
}
