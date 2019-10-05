package model;

public class Potion extends InventoryItem
{

	//States
	public int healing;		//Potion's Healing Amount
	
	//---------------------------------------------------------------------------------------
	
	public Potion(String itemName, String itemDesc, int healing) 
	{
		super(itemName, itemDesc);		//Inventory Item
		this.healing = healing;
	}

	//Get Healing
	public int getHealing()
	{
		return healing;
	}
	
}//End of Class Potion