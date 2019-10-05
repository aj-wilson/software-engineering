package model;

public class Player implements IPlayer
{

	//States
	public String playerName;		//Player's Name
	public int playerHealth;		//Player's Health
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Constructor
	public Player (String playerName)
	{
		this.playerName = playerName;
		playerHealth = 100;					//Health Automatically Starts At 100
	}//End of Constructor
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Player Name
	//Set Player's Name
	@Override
	public void setPlayerName (String playerName)
	{
		this.playerName = playerName;
	}
	
	//Get Player's Name
	@Override
	public String getPlayerName ()
	{
		return playerName;
	}
	
	
	//Player Health
	//Set Player Health
	@Override
	public void setPlayerHealth (int playerHealth)
	{
		this.playerHealth = playerHealth;
	}
	
	//Get Player's Health
	@Override
	public int getPlayerHealth ()
	{
		return playerHealth;
	}
	
	//Take Damage
	@Override
	public void takeDamage (int damage)
	{
		playerHealth = playerHealth - damage;
	}
	
	//Heal
	@Override
	public void Heal (int heal)
	{
		playerHealth = playerHealth + heal;
	}
	
	
	//---------------------------------------------------------------------------------------
	
}//End of Class Player