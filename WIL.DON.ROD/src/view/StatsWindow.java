package view;

import controller.IStatsController;
import controller.StatsController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StatsWindow 
{

	//States
	static Stage window;
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Display Method: Displays A Stats Window
	public static void display ()
	{
		window = new Stage();										//Create New Window
		
		window.initModality(Modality.APPLICATION_MODAL);			//Can't Click On Game Until Closed
		window.setTitle("Player Stats");							//Set Window Title
		
		
		//Text In Window
		Label statsLabel = new Label();
		statsLabel.setTextFill(Color.rgb(0, 255, 102));
		statsLabel.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 13));
		
		//What's Displayed Is Decided In The Stats Controller
		IStatsController con = new StatsController();
		statsLabel.setText(con.displayStats());
		
		//Layout
		VBox statsLayout = new VBox();
		statsLayout.setBackground(null);									
		statsLayout.getChildren().add(statsLabel);
		statsLayout.setAlignment(Pos.TOP_LEFT);
		
		//Scene
		Scene statsScene = new Scene(statsLayout, 300, 100, Color.BLACK);		
		window.setScene(statsScene);								//Add Scene To Window
		window.showAndWait();										//Waits For Window To Be Closed Before Returning
				
	}//End of Display
	
}//End of Class Stats Window