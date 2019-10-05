package model;

public class Weapon extends InventoryItem
{

	//States
	public int damage;		//Weapon's Damage Amount
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Constructor
	public Weapon(String itemName, String itemDesc, int damage) 
	{
		super(itemName, itemDesc);		//Inventory Item
		this.damage = damage;
	}
	
	//Get Damage
	public int getDamage()
	{
		return damage;
	}

}//End of Class Weapon