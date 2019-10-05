package controller;

import model.IInventoryItem;
import model.IPlayer;
import model.InventoryItem;
import model.InventoryItemList;
import model.Monster;
import model.Player;
import model.Potion;
import model.PotionChest;
import model.Weapon;
import model.WeaponChest;

public class StoryController implements IStoryController
{

	//States
	public String question = "0";												//Which Question Is Current
	public String displayNext = " ";											//Tell View What To Display Next To The User
	public static IPlayer player = new Player("");								//Player Object
	public Monster monster;														//Monster Object
	public static InventoryItemList inventoryList = new InventoryItemList();	//Keeps List of All Inventory
	boolean playerDeath = false;												//Player Death
	boolean monsterDeath = false;												//Monster Death
	PotionChest potionChest1;													//Chests In Game
	PotionChest potionChest2;
	WeaponChest weaponChest1;
	WeaponChest weaponChest2;

	
	//---------------------------------------------------------------------------------------
	
	
	//Figures Out What To Tell MainWindow To Display Next To The User
	@Override
	public String handleUserInput (String userInput)
	{
		
			//Story
			switch (question)
			{
				case "0":
					displayNext = "\nHey there stranger! What's your Name?";
					question = "1";
					InventoryItemList.removeAll();
					IInventoryItem startingWeapon = new Weapon("Stick", "2 Damage", 2);
					InventoryItemList.addItem(startingWeapon);
					monster = new Monster();
					player.setPlayerHealth(100);
					monster.setHealth(100);
					monsterDeath = false;
					playerDeath = false;
					break;
				case "1":
					player.setPlayerName(userInput);
					displayNext = "\nYour name's " + player.getPlayerName() + "?\n"
									+ "[YES] [NO]";
					question = "2";
					break;
				case "2":
					if (userInput.equals("YES")) {
						displayNext = "\nHello " + player.getPlayerName() + "."
								+ "\n[SAY HELLO]";
						question = "3";	
						break;
					} else if (userInput.equals("NO"))
					{
						displayNext = "\nThen what's your name?";
						question = "1";
						break;
					} else
					{
						displayNext = "\nWhat was that?";
						question = "2";
						break;
					}
				case "3":
					displayNext = "\nI could use your help with something. "
							+ "Someone has taken our flashlight."
							+ "\nWill you please retrieve it?"
							+ "\n[YES] [NO]";
					question = "4";
					break;
				case "4":
					if (userInput.equals("YES")) {
						displayNext = "\nOh, thank you! I believe it was taken down one of those paths "
								+ "there behind you."
								+ "\n[LEFT] [RIGHT]";
						question = "5";	
						break;
					} else if (userInput.equals("NO"))
					{
						displayNext = "\nYou have failed to retrieve the flashlight."
								+ "\n[GAME OVER: ENTER AND CLICK FOR MAIN MENU]";
						InventoryItemList.removeAll();
						question = "GAME OVER";
						break;
					} else
					{
						displayNext = "\nWhat was that?";
						question = "4";
						break;
					}
				case "5":
					if (userInput.equals("LEFT")) {
						displayNext = "\nYou travel down the left path."
								+ " You find a chest up ahead."
								+ "\n[OPEN]";
						potionChest1 = new PotionChest();
						question = "6";	
						break;
					} else if (userInput.equals("RIGHT"))
					{
						displayNext = "\nYou travel down the right path."
								+ " You find a chest up ahead."
								+ "\n[OPEN]";
						weaponChest1 = new WeaponChest();
						question = "7";
						break;
					} else
					{
						displayNext = "\nWhich way do you want to go?";
						question = "5";
						break;
					}
				case "6":
					Potion potionInside = potionChest1.getPotionInside();
					displayNext = "\nInside the chest you find a "
							+ potionInside.getItemName() + "."
							+ " It is now in your inventory."
							+ "\n[ENTER]";
					InventoryItemList.addItem(potionInside);
					question = "8";
					break;
				case "7":
					Weapon weaponInside = weaponChest1.getWeaponInside();
					displayNext = "\nInside the chest you find a "
							+ weaponInside.getItemName() + "."
							+ " It is now in your inventory."
							+ "\n[ENTER]";
					InventoryItemList.addItem(weaponInside);
					question = "8";
					break;
				case "8":
					displayNext = "\nYou continue walking and come"
							+ " upon another fork in the road."
							+ "\nWhich way will you go?"
							+ "\n[LEFT] [RIGHT]";
					question = "9";
					break;
				case "9":
					if (userInput.equals("LEFT")) {
						displayNext = "\nYou travel down the left path."
								+ " You find a chest up ahead."
								+ "\n[OPEN]";
						potionChest2 = new PotionChest();
						question = "10";	
						break;
					} else if (userInput.equals("RIGHT"))
					{
						displayNext = "\nYou travel down the right path."
								+ " You find a chest up ahead."
								+ "\n[OPEN]";
						weaponChest2 = new WeaponChest();
						question = "11";
						break;
					} else
					{
						displayNext = "\nWhich way do you want to go?";
						question = "9";
						break;
					}
				case "10":
					Potion potionInside2 = potionChest2.getPotionInside();
					displayNext = "\nInside the chest you find a "
							+ potionInside2.getItemName() + "."
							+ " It is now in your inventory."
							+ "\n[ENTER]";
					InventoryItemList.addItem(potionInside2);
					question = "12";
					break;
				case "11":
					Weapon weaponInside2 = weaponChest2.getWeaponInside();
					displayNext = "\nInside the chest you find a "
							+ weaponInside2.getItemName() + "."
							+ " It is now in your inventory."
							+ "\n[ENTER]";
					InventoryItemList.addItem(weaponInside2);
					question = "12";
					break;
				case "12":
					displayNext = "\nYou continue walking and see a light up ahead."
							+ "\nIt must be the flashlight."
							+ "\n[ENTER]";
					question = "13";
					break;
				case "13":
					displayNext = "\nYou see a monster up ahead with the flashlight."
							+ "\nWhat do you do?"
							+ "\n[FIGHT] [RUN AWAY]";
					question = "14";
					break;
				case "14":
					if (userInput.equals("FIGHT")) {
						displayNext = "\nYou have choosen to fight. What do you use?"
								+ "\nYour Inventory: "
								+ "\n[1] Stick: 2 Damage "
								+ "\n[2] " + InventoryItemList.getItem(1)
								+ "\n[3] " + InventoryItemList.getItem(2);
						question = "15";	
						break;
					} else if (userInput.equals("RUN AWAY"))
					{
						displayNext = "\nYou have failed to retrieve the flashlight."
								+ "\n[GAME OVER: ENTER AND CLICK FOR MAIN MENU]";
						InventoryItemList.removeAll();
						question = "GAME OVER";
						break;
					} else
					{
						displayNext = "\nWhat do you want to do?";
						question = "14";
						break;
					}
				case "15":
					if (userInput.equals("1")) 
					{
						displayNext = "\nYou have chosen to use the stick.\n[ENTER]";
						question = "16";	
						break;
					} else if (userInput.equals("2"))
					{
						displayNext = "\nYou have chosen to use the "
								+ InventoryItemList.getItemName(1) + "."
										+ "\n[ENTER]";
						String type = InventoryItemList.getItemType(1);
						if (type.equals("WEAPON"))
						{
							question = "17";
						} else if (type.equals("POTION"))
						{
							question = "18";
						}
						break;
					} else if (userInput.equals("3"))
					{
						displayNext = "\nYou have chosen to use "
								+ InventoryItemList.getItemName(2) + "."
										+ "\n[ENTER]";
						String type = InventoryItemList.getItemType(2);
						if (type.equals("WEAPON"))
						{
							question = "19";
						} else if (type.equals("POTION"))
						{
							question = "20";
						}
						break;
					} else
					{
						displayNext = "\nWhat do you want to use?";
						question = "15";
						break;
					}
				case "16":
					monster.takeDamage(2);
					displayNext = "\nThe monster is dealt 2 damage."
							+ " The monster has "
							+ monster.getHealth() + " health.";
					question = "Monster";
					break;
				case "17":
					monster.takeDamage(InventoryItemList.getItemStats(1));
					displayNext = "\nThe monster is dealt "
							+ InventoryItemList.getItemStats(1)
							+ " damage."
							+ " The monster has "
							+ monster.getHealth() + " health.";
					question = "Monster";
					break;
				case "18":
					int healing = InventoryItemList.getItemStats(1);
					player.Heal(healing);
					displayNext = "\nYou have healed "
							+ healing + " points."
									+ " You have "
									+ player.getPlayerHealth() + " health."
									+ "\n[ENTER]";
					question = "Monster";
					break;
				case "19":
					monster.takeDamage(InventoryItemList.getItemStats(2));
					displayNext = "\nThe monster is dealt "
							+ InventoryItemList.getItemStats(2)
							+ " damage."
							+ " The monster has "
							+ monster.getHealth() + " health."
									+ "\n[ENTER]";
					question = "Monster";
					break;
				case "20":
					int healing2 = InventoryItemList.getItemStats(2);
					player.Heal(healing2);
					displayNext = "\nYou have healed "
							+ healing2 + " points."
									+ " You have "
									+ player.getPlayerHealth() + " health."
									+ "\n[ENTER]";
					question = "Monster";
					break;
				case "Monster":
					int monsterDamage = monster.damagePlayer();
					player.takeDamage(monsterDamage);
					displayNext = "\nThe monster attacks with a " + monster.monWeap.itemName + "."
							+ " You are dealt " + monsterDamage + " damage."
									+ " You have "
									+ player.getPlayerHealth() + " health."
											+ "\n[ENTER]";
					question = "Player Turn";
					break;
				case "Player Turn":
					displayNext = "\nWhat do you use now?"
							+ "\nYour Inventory: "
							+ "\n[1] Stick: 2 Damage "
							+ "\n[2] " + InventoryItemList.getItem(1)
							+ "\n[3] " + InventoryItemList.getItem(2);
					question = "15";	
					break;
				case "GAME OVER":
					displayNext = "GAME OVER";
					question = "0";
					break;
				case "YOU WIN!":
					displayNext = "YOU WIN!";
					question = "0";
					break;
			}
			
			if (player.getPlayerHealth() <= 0 && playerDeath == false) 
			{
				playerDeath = true;
				displayNext = "\nThe monster attacks. You have been defeated."
						+ "\n[GAME OVER: ENTER AND CLICK FOR MAIN MENU]";
				InventoryItemList.removeAll();
				question = "GAME OVER";
			}
			if (monster.getHealth() <= 0 && monsterDeath == false)
			{
				monsterDeath = true;
				displayNext = "\nYou have defeated the monster."
						+ " The flashlight is now in your inventory."
						+ "\n[GAME WON: ENTER AND CLICK FOR MAIN MENU]";
				InventoryItem flashlight = new InventoryItem("Flashlight", "You win!");
				InventoryItemList.addItem(flashlight);
				question = "YOU WIN!";
			}
		
		return displayNext;
		
	}//End of Handle User Input
	
	//For When Player Wants To Know Their Health
	@Override
	public String displayHealth ()
	{
		return "\nYou have " + Integer.toString(player.getPlayerHealth()) + " health.";
	}//End of Display Health
	
}//End of Class Story Controller