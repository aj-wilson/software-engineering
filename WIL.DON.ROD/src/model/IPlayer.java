package model;

public interface IPlayer 
{

	void setPlayerName(String playerName);
	String getPlayerName();
	
	void setPlayerHealth(int playerHealth);
	int getPlayerHealth();
	void takeDamage(int monsterDamage);
	void Heal(int heal);
	
}//End of Interface IPlayer