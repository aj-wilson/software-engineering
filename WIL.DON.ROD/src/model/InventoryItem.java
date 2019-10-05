package model;

public class InventoryItem implements IInventoryItem
{

	//States
	public String itemName;		//Item's Name
	public String itemDesc;		//Item's Description
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Constructor
	public InventoryItem (String itemName, String itemDesc)
	{
		this.itemName = itemName;
		this.itemDesc = itemDesc;
	}
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Item Name
	//Set Item's Name
	@Override
	public void setItemName (String itemName)
	{
		this.itemName = itemName;
	}
		
	//Get Item's Name
	@Override
	public String getItemName ()
	{
		return itemName;
	}
	
	//Item Description
	//Set Item's Name
	@Override
	public void setItemDesc (String itemDesc)
	{
		this.itemDesc = itemDesc;
	}
			
	//Get Item's Description
	@Override
	public String getItemDesc ()
	{
		return itemDesc;
	}
	
	//ToString For Inventory Item
	@Override
	public String toString()
	{
		return "\n" + this.itemName + ": " + this.itemDesc;
	}
	
}//End of Class Inventory Item