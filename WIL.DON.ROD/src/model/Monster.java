package model;

public class Monster 
{
	
	public int health;								//Health Starts At 100
	public int damage;								//Damage The Monster Deals
	public Weapon monWeap;							//Monster Has Weapon
	
	//---------------------------------------------------------------------------------------
	
	public Monster ()
	{
		health = 100;
		
		int n = (int)(Math.random() * 100) + 1;					//Random Number Btwn 1 and 100
		
		if (n >= 1 && n <= 40)									//40% Chance Rock
		{
			monWeap = new Weapon("Rock", "5 Damage", 5);
		}
		else if (n >= 41 && n <= 75)							//35% Chance Hammer
		{
			monWeap = new Weapon("Hammer", "10 Damage", 10);	
		}
		else if (n >= 76 && n <= 100)							//25% Chance Axe
		{
			monWeap = new Weapon("Axe", "30 Damage", 30);
		}
	}
	
	//Set Health
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	//Get Health
	public int getHealth()
	{
		return health;
	}
	
	//Set Weapon
	public void setWeapon (Weapon w) 
	{
		this.monWeap = w;
	}
	
	//Get Weapon
	public Weapon getWeapon() 
	{
		return monWeap;
	}
	
	//Take Damage
	public void takeDamage(int damageTaken)
	{
		health = health - damageTaken;
	}
	
	//Damage Player
	public int damagePlayer ()
	{
		int oneOrTwo = (int)(Math.random() * 2) + 1;
		int n = (int)(Math.random() * 5) + 1;			//Random Number To Add Or Subtract To Damage (1-5)
		
		if (oneOrTwo == 1)
		{
			damage = monWeap.damage + n;				//Monster Does Damage of Weapon Plus Random Damage
		} else
		{
			damage = monWeap.damage - n;				//Monster Does Damage of Weapon Minus Random Damage
		}
		
		return damage;
	}
	
}//End of Class Monster