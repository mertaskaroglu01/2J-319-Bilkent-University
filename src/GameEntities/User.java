package GameEntities;

public class User {
	String name;
	int score;
	public User()
	{
		name = "";
		score = 0;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int s)
	{
		score = s;
	}

}
