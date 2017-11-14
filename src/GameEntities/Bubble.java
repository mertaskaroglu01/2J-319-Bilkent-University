package GameEntities;

public class Bubble extends GameObject {
	
	int speed;
	int points;
	
	Bubble( int bubbleType) {
		//0 = red
		//1 = yellow
		//2 = green
		if ( bubbleType == 0 )
			points = 10;
		else if ( bubbleType == 1)
			points = 20;
		else 
			points = 50;
	}
	
	public void changeSpeed( int roundId) {
		
	}
}
