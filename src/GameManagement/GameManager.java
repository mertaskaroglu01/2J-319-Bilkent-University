package GameManagement;

import java.util.Collections;
import java.util.Comparator;

import GameEntities.Round;

public class GameManager {
	
	private final int MAX_ROUND_NUMBER = 10;
	private boolean paused;
	public GameEngine gameEngine;
	
	public GameManager() throws Exception {
		this.gameEngine = new GameEngine();
	}
	
	public void gameLoop() {
		
	}

	public boolean isDead() {
		return gameEngine.getRemainingLives()<=0;
	}
	
	public void endRound() {
		
	}
	
	public void startNewRound() throws Exception {
		gameEngine.getCurrentRound().getPlayer(1).upgrade();
		gameEngine.getCurrentRound().getPlayer(2).upgrade();
		gameEngine.getCurrentRound().moveToNextRound();
	}
	
	public void resumeGame() {
		
	}
	
	public void pauseGame() {
		
	}
	
	public boolean isHighScore(int score) {
//		File file = new File("src/HighScores.txt");
//		FileReader fileReader = new FileReader(file);
//		BufferedReader bufferedReader = new BufferedReader(fileReader);
//		StringBuffer stringBuffer = new StringBuffer();
//		ArrayList<User> users = new ArrayList<User>();
//		String line = "";
//		String name = "";
//		String point = "0";
//		String user = "";
//		
//		while( (line = bufferedReader.readLine()) != null)
//		{		
//			line = bufferedReader.readLine();
//			if(line != null)
//			{
//	    	for(int i = 0; i < line.length(); i++ )
//			{
//				if((line.charAt(i) >= 'a' && line.charAt(i) <= 'z') || (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z'))
//			    {
//			    	name = name + line.charAt(i);
//			    }
//				else 
//			    {
//			    	point = point + line.charAt(i); 
//			    }
//			}
//			User u = new User();
//			u.setName(name);
//			u.setScore(Integer.parseInt(point));
//			point = "0";
//			name = "";
//			users.add(u);
//			}
//		}
//		Collections.sort(users, new Comparator<User>() {
//	        @Override public int compare(User u1, User u2) {
//	            return u2.getScore() - u2.getScore(); // Ascending
//	        }
//
//	    });
//		for(int i = 4; i >= 0; i++)
//		{
//			if(i < users.size())
//			{
//				if(score > users.get(i).getScore())
//					return true;
//			}
//		}
		return false;	
	}
	
	public boolean isRoundEnd() {
		if(gameEngine.getCurrentRound().getNoOfBubbles() == 0 ) {
			return true;
		}
		else
			return false;
	}
	
	public boolean isGameEnd() {
		boolean temp1, temp2;
		temp1 = isDead();
		temp2 = (gameEngine.getCurrentRound().getRoundNumber() == MAX_ROUND_NUMBER && gameEngine.getCurrentRound().getNoOfBubbles() == 0);
		return  temp1 || temp2 ;
	}
	
}
