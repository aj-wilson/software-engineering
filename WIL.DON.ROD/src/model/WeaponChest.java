package model;

public class WeaponChest 
{

	//This Class Is Used To Gain Weapons From A Chest
	
	int number;				//Number The Chest Holds (Determines Weapon Inside)
	Weapon weaponInside;
	
	//---------------------------------------------------------------------------------------
	
	public WeaponChest ()
	{
		number = (int) (Math.random() * 100) + 1;	//Random Number Between 1 and 100
		
		if (number >= 1 && number <= 30)
		{
			weaponInside = new Weapon("Rock", "5 Damage", 5);					//30% Chance Rock
		} 
		else if (number >= 31 && number <= 60)
		{
			weaponInside = new Weapon("Hammer", "10 Damage", 10);				//30% Chance Hammer
		} 
		else if (number >= 61 && number <= 75)							
		{
			weaponInside = new Weapon("Axe", "30 Damage", 30);					//15% Chance Axe
		}
		else if (number >= 76 && number <= 90)							
		{
			weaponInside = new Weapon("Sword", "60 Damage", 60);				//15% Chance Sword
		}
		else if (number >= 91 && number <= 100)							
		{
			weaponInside = new Weapon("Ultra Sword", "100 Damage", 100);		//10% Chance Ultra Sword
		}
	}
	
	//---------------------------------------------------------------------------------------
	
	//Get Weapon In Chest
	public Weapon getWeaponInside()
	{
		return weaponInside;
	}
	
}//End of Class Weapon Chest