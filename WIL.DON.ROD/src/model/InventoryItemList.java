package model;

import java.util.LinkedList;

public class InventoryItemList 
{

	//States
	private static LinkedList<InventoryItem> list;	//List of Inventory Items
	int numItem;									//Number of Items
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Constructor
	public InventoryItemList()
	{
		list = new LinkedList<InventoryItem>();		//Create List of Inventory Items
	}
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Add Inventory Item
	public static void addItem(IInventoryItem item)
	{
		list.add((InventoryItem) item);
		//numItem++;
	}
	
	//Get Inventory Items
	public static LinkedList<InventoryItem> getItems()
	{
		return list;
	}
	
	//Remove Item
	public static void removeItem(InventoryItem item)
	{
		list.remove(item);
	}

	//Remove All Items
	public static void removeAll() 
	{
		list.clear();		
	}

	//Get Item Name / Description
	public static String getItem(int i) 
	{
		InventoryItem item = list.get(i);
		String itemName = item.getItemName();
		String itemDesc = item.getItemDesc();
		return itemName + ": " + itemDesc;
	}
	
	//Get Item Name
	public static String getItemName(int i) 
	{
		InventoryItem item = list.get(i);
		String itemName = item.getItemName();
		return itemName;
	}
	
	//Get Item Type
	public static String getItemType(int i)
	{
		String itemType = "";
	    if (list.get(i) instanceof Weapon) 
		{
	        itemType = "WEAPON";
	    }
	    else if (list.get(i) instanceof Potion)
		{
	        itemType = "POTION";
		}
		return itemType;
	}
	
	//Get Item Stats
	public static int getItemStats(int i)
	{
		InventoryItem item = list.get(i);
		int itemStats = 0;
	    if (list.get(i) instanceof Weapon) 
		{
	    	Weapon w = (Weapon) item;
	        itemStats = w.getDamage();
	    }
	    else if (list.get(i) instanceof Potion)
		{
	    	Potion p = (Potion) item;
	        itemStats = p.getHealing();
		}
		return itemStats;
	}
	
}//End of Class Inventory Item List