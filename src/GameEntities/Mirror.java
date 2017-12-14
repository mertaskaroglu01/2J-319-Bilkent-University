package GameEntities;

public class Mirror extends GameObject {
	
	int direction;
	
	Mirror( int xPos, int yPos, int length, int d) {
		height = 5;
		width  = length;
		x = xPos;
		y = yPos;
		
		direction = d;
	}
	
	public int getDirection() {
		return direction;
	}
}
