package model;

public class PotionChest 
{

	//This Class Is Used To Gain Healing Items From A Chest
	
	int number;					//Number The Chest Holds (Determines Potion Inside)
	Potion potionInside;
	
	//---------------------------------------------------------------------------------------
	
	public PotionChest ()
	{
		number = (int) (Math.random() * 100) + 1;	//Random Number Between 1 and 100
		
		if (number >= 1 && number <= 30)
		{
			potionInside = new Potion("Herbs", "5 Healing", 5);					//30% Chance Herbs
		} 
		else if (number >= 31 && number <= 60)
		{
			potionInside = new Potion("Good Herbs", "10 Healing", 10);			//30% Chance Good Herbs
		}
		else if (number >= 61 && number <= 75)							
		{
			potionInside = new Potion("Potion", "30 Healing", 30);				//15% Chance Potion
		}
		else if (number >= 76 && number <= 90)							
		{
			potionInside = new Potion("Good Potion", "60 Healing", 60);			//15% Chance Good Potion
		}
		else if (number >= 91 && number <= 100)							
		{
			potionInside = new Potion("Ultra Potion", "100 Healing", 100);		//10% Chance Ultra Potion
		}
	}
	
	//---------------------------------------------------------------------------------------
	
	//Get Potion In Chest
	public Potion getPotionInside()
	{
		return potionInside;
	}
	
}//End of Class Potion Chest