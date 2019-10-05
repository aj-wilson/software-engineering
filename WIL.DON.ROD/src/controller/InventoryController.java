package controller;

import java.util.LinkedList;
import model.InventoryItem;
import model.InventoryItemList;

public class InventoryController implements IInventoryController
{

	//Sends Items To Be Displayed
	@Override
	public String displayInventory() 
	{
		LinkedList<InventoryItem> items = InventoryItemList.getItems();
		return "CURRENT INVENTORY: \n" + items.toString();
	}
	
}//End of Class Inventory Controller