package view;

import controller.InventoryController;
import controller.IInventoryController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InventoryWindow 
{

	//States
	static Stage window;
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Display Method: Displays An Inventory Window
	public static void display ()
	{
		window = new Stage();										//Create New Window
		
		window.initModality(Modality.APPLICATION_MODAL);			//Can't Click On Game Until Closed
		window.setTitle("Current Inventory");						//Set Window Title
		
		
		//Text In Window
		Label inventoryLabel = new Label();
		inventoryLabel.setTextFill(Color.rgb(0, 255, 102));
		inventoryLabel.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 13));
		
		//What's Displayed Is Decided In The Inventory Controller
		IInventoryController con = new InventoryController();
		inventoryLabel.setText(con.displayInventory());
		
		//Layout
		VBox inventoryLayout = new VBox();
		inventoryLayout.setBackground(null);									
		inventoryLayout.getChildren().add(inventoryLabel);
		inventoryLayout.setAlignment(Pos.TOP_LEFT);
		
		//Scene
		Scene inventoryScene = new Scene(inventoryLayout, 300, 100, Color.BLACK);		
		window.setScene(inventoryScene);							//Add Scene To Window
		window.showAndWait();										//Waits For Window To Be Closed Before Returning
				
	}//End of Display
	
}//End of Class Inventory Window