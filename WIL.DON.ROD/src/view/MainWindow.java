package view;

//This Class Sets Up The Window The Game Is Played On

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import controller.StoryController;

import java.util.ArrayList;

import controller.IStoryController;

public class MainWindow extends Application
{

	//States
	Stage window;												//A Stage Is A Window
	
	public int gameWidth = 750;									//Game Width
	public int gameHeight = 500;								//Game Height
	
	//Scene: What's Inside The Window
	Scene mainMenuScene;										//Main Menu Scene
	Scene gameAreaScene;										//Actual Game Scene
	Scene gameOverScene;										//Game Over Scene
	Scene gameWonScene;											//Game Won Scene
	
	//Main Menu Scene Components
	Button playButton;											//A Button To Start The Game
	Button backToMenuButtonLose;								//A Button To Return To The Main Menu
	Button backToMenuButtonWin;									//A Button To Return To The Main Menu
	
	//Game Scene Components
	public TextField playerInput;								//Text Field Where User Types
	public String instructionsText;								//Instructions
	public Label instructions;									//Instructions Label For The Player
	public Label typeToPlay;									//Tells User To Type Anything To Begin
	public Label worldSummary;									//Describe World To Player
	public Label arrow;											//Visual Purpose Only
	
	public VBox gameLeft;										//Used For Game Layout
	
	public String currentColor = "GREEN";						//Keeps Track Of Text Color
	ArrayList<Label> allStoryLabels = new ArrayList<Label>(); 	//Used For Changing All Text Color
	
	
	//---------------------------------------------------------------------------------------
	
	
	//Start Method: Needed Because This Class Extends Application
	@Override
	public void start(Stage window) throws Exception 
	{
		
		this.window = window;										//Set Up The Stage
		window.setTitle("WIL.DON.ROD");								//Give Window A Title
		
		
		//---------------------------------------------------------------------------------------
		
		
		//Main Menu Scene: Play Button
		playButton = new Button();									//Create The Play Button
		playButton.setText("PLAY");									//Set The Text On Button
		playButton.setBackground(null);								//Remove The Background
		playButton.setTextFill(Color.rgb(0, 255, 102));				//Set Font & Font Color
		playButton.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 18));
		
		
		//---------------------------------------------------------------------------------------
		
		
		//Game Over Scene: Return To Main Menu Button
		backToMenuButtonLose = new Button();									//Create Button
		backToMenuButtonLose.setText("GAME OVER");								//Set The Text On Button
		backToMenuButtonLose.setBackground(null);								//Remove The Background
		backToMenuButtonLose.setTextFill(Color.rgb(0, 255, 102));				//Set Font & Font Color
		backToMenuButtonLose.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 18));
		
		
		//---------------------------------------------------------------------------------------
		
		
		//Game Over Scene: Return To Main Menu Button
		backToMenuButtonWin = new Button();										//Create Button
		backToMenuButtonWin.setText("YOU WIN!");								//Set The Text On Button
		backToMenuButtonWin.setBackground(null);								//Remove The Background
		backToMenuButtonWin.setTextFill(Color.rgb(0, 255, 102));				//Set Font & Font Color
		backToMenuButtonWin.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 18));
				
				
		//---------------------------------------------------------------------------------------
		
		
		//Game Scene: Arrow
		arrow = new Label();										//Create A Label
		arrow.setText(" >");										//Give It Text
		arrow.setBackground(null);									//Remove The Background
		arrow.setTextFill(Color.rgb(0, 255, 102));					//Set Font & Font Color
		arrow.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 13));
		
		//Game Scene: User Text Field
		playerInput = new TextField();								//Create User Text Field
		playerInput.setPrefWidth(gameWidth);						//Set Its Width
		playerInput.setBackground(null);							//Remove The Background
		playerInput.setStyle("-fx-text-inner-color: #00ff66");		//Set Font & Font Color
		playerInput.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 13));
		
		//Instructions
		instructionsText = "\nHOW TO PLAY" +
							"\n- Click And Drag To Scroll" + 
							"\n- You Start The Game With 100 Health " +
							"\n- Type INVENTORY Or STUFF To View Your Inventory" +
							"\n- Type HEALTH To View Your Health" + 
							"\n- Type STATS To View Your Stats" +
							"\n- Type INSTRUCTIONS Or HELP To View The Instructions";
		
		//Game Scene: Instructions Label
		instructions = new Label();									//Create A Label
		instructions.setText(instructionsText);						//Set Its Text
		instructions.setBackground(null);							//Remove The Background
		instructions.setTextFill(Color.rgb(0, 255, 102));			//Set Font & Font Color
		instructions.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 13));
		
		//Game Scene: Type To Play
		typeToPlay = new Label();
		typeToPlay.setText("\n\nType Anything To Begin\n");
		typeToPlay.setBackground(null);								//Remove The Background
		typeToPlay.setTextFill(Color.rgb(0, 255, 102));				//Set Font & Font Color
		typeToPlay.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 13));
		
		//Game Scene: World Summary
		worldSummary = new Label();									//Create A Label
		worldSummary.setText("Welcome to the world of WIL.DON.ROD." //Give Label Text	
							 + "\n\nThe year is 2182. For reasons unknown, nearly all technology" 
							 + " has failed." 
							 + "\nWorking technology is therefore considered a highly coveted resource."
							 + "\nYou are a wanderer of unknown origin. " 
							 + "Your purpose is to seek and covet \nany technology you can find.");								
		worldSummary.setBackground(null);							//Remove Its Background
		worldSummary.setTextFill(Color.rgb(0, 255, 102));			//Set Font/Font Color
		worldSummary.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 13));
		
		//Set User Text To Always Be UpperCase
		playerInput.setTextFormatter(new TextFormatter<>((change) -> 
		{			
			change.setText(change.getText().toUpperCase());
			
		    return change;     
		}));
		
		
		//---------------------------------------------------------------------------------------
		
		
		//Event Handling: Gets Sent Out To Controller
		

		IStoryController controller = new StoryController();
		
		//Handle Play Button
		playButton.setOnAction(e -> 							
		{			
			window.setScene(gameAreaScene);							//Display The Game Scene
		});
		
		//Handle Game Over Button
		backToMenuButtonLose.setOnAction(e -> 							
		{			
			window.setScene(mainMenuScene);							//Display The Main Menu Scene
		});
		
		//Handle You Win Button
		backToMenuButtonWin.setOnAction(e -> 							
		{			
			window.setScene(mainMenuScene);							//Display The Main Menu Scene
		});
		
		//Handle Player Input
		playerInput.setOnAction(e -> 						
		{					
			//If User Types Inventory Into The Field, An Inventory Window Will Pop Up
			if (playerInput.getText().contains("INVENTORY") || playerInput.getText().contains("STUFF"))		
			{
				InventoryWindow.display();
			} else if (playerInput.getText().contains("STATS")) 	//Display Player Stats
			{
				StatsWindow.display();
			} else if (playerInput.getText().contains("HEALTH"))	//Display Health Level
			{
				String playerHealth = controller.displayHealth();
				
				Label displayHealth = new Label(playerHealth);
				setStyle(displayHealth, currentColor);
				gameLeft.getChildren().add(displayHealth);
				
			} else if (playerInput.getText().contains("INSTRUCTIONS") || playerInput.getText().contains("HELP")) 
			{														//Display How To Play
				Label displayInstructions = new Label(instructionsText);
				setStyle(displayInstructions, currentColor);
				gameLeft.getChildren().add(displayInstructions);
			} else if (playerInput.getText().contains("CHANGE TO BLUE")) 
			{
				playButton.setTextFill(Color.rgb(173,216,230));
				backToMenuButtonLose.setTextFill(Color.rgb(173,216,230));
				backToMenuButtonWin.setTextFill(Color.rgb(173,216,230));
				arrow.setTextFill(Color.rgb(173,216,230));
				playerInput.setStyle("-fx-text-inner-color: #add8e6");
				instructions.setTextFill(Color.rgb(173,216,230));
				typeToPlay.setTextFill(Color.rgb(173,216,230));
				worldSummary.setTextFill(Color.rgb(173,216,230));
				
				currentColor = "BLUE";
				changeAllLabelsColor(allStoryLabels, currentColor);
				
			} else if (playerInput.getText().contains("CHANGE TO YELLOW")) 
			{
				playButton.setTextFill(Color.rgb(255,240,89));
				backToMenuButtonLose.setTextFill(Color.rgb(255,240,89));
				backToMenuButtonWin.setTextFill(Color.rgb(255,240,89));
				arrow.setTextFill(Color.rgb(255,240,89));
				playerInput.setStyle("-fx-text-inner-color: #fff059");
				instructions.setTextFill(Color.rgb(255,240,89));
				typeToPlay.setTextFill(Color.rgb(255,240,89));
				worldSummary.setTextFill(Color.rgb(255,240,89));
				
				currentColor = "YELLOW";
				changeAllLabelsColor(allStoryLabels, currentColor);
				
			} else if (playerInput.getText().contains("CHANGE TO GREEN")) 
			{
				playButton.setTextFill(Color.rgb(0, 255, 102));
				backToMenuButtonLose.setTextFill(Color.rgb(0, 255, 102));
				backToMenuButtonWin.setTextFill(Color.rgb(0, 255, 102));
				arrow.setTextFill(Color.rgb(0, 255, 102));
				playerInput.setStyle("-fx-text-inner-color: #00ff66");
				instructions.setTextFill(Color.rgb(0, 255, 102));
				typeToPlay.setTextFill(Color.rgb(0, 255, 102));
				worldSummary.setTextFill(Color.rgb(0, 255, 102));
				
				currentColor = "GREEN";
				changeAllLabelsColor(allStoryLabels, currentColor);
				
			} else if (playerInput.getText().contains("CHANGE TO PINK")) 
			{
				playButton.setTextFill(Color.rgb(255,97,232));
				backToMenuButtonLose.setTextFill(Color.rgb(255,97,232));
				backToMenuButtonWin.setTextFill(Color.rgb(255,97,232));
				arrow.setTextFill(Color.rgb(255,97,232));
				playerInput.setStyle("-fx-text-inner-color: #ff61e8");
				instructions.setTextFill(Color.rgb(255,97,232));
				typeToPlay.setTextFill(Color.rgb(255,97,232));
				worldSummary.setTextFill(Color.rgb(255,97,232));
				
				currentColor = "PINK";
				changeAllLabelsColor(allStoryLabels, currentColor);
				
			} else													//Get Next Story Element
			{
				String displayNext = controller.handleUserInput(playerInput.getText());
				
				//When The Player Has Lost
				if (displayNext.equals("GAME OVER"))
				{
					gameLeft.getChildren().clear();
					gameLeft.getChildren().addAll(worldSummary, instructions, typeToPlay);
					window.setScene(gameOverScene);
				} else if (displayNext.equals("YOU WIN!"))
				{
					gameLeft.getChildren().clear();
					gameLeft.getChildren().addAll(worldSummary, instructions, typeToPlay);
					window.setScene(gameWonScene);
				}else
				{
					Label nextDisplay = new Label(displayNext);
					allStoryLabels.add(nextDisplay);
					setStyle(nextDisplay, currentColor);
					gameLeft.getChildren().add(nextDisplay);
				}
			}
			
			playerInput.setText("");								//Clear Field After User "Enters"			
		});
		
		
		//---------------------------------------------------------------------------------------
		
		
		//Scene Layouts
		
		
		//Main Menu Layout
		VBox mainMenuCenter = new VBox();							//Create VBox (Vertical Layout - Stacking)
		mainMenuCenter.getChildren().addAll(playButton);			//Add The Play Button
		mainMenuCenter.setAlignment(Pos.CENTER);					//Center The VBox
		
		BorderPane mainMenuLayout = new BorderPane();				//Create A BorderPane (Scene Layout)
		mainMenuLayout.setCenter(mainMenuCenter);					//Add A Pane At The Center Of The Scene (VBox)
		mainMenuLayout.setBackground(null);							//Remove The Background
		
		//Game Over Layout
		VBox gameOverCenter = new VBox();							//Create VBox
		gameOverCenter.getChildren().addAll(backToMenuButtonLose);	//Add Button
		gameOverCenter.setAlignment(Pos.CENTER);					//Center The VBox
		
		BorderPane gameOverLayout = new BorderPane();				//Create BorderPane
		gameOverLayout.setCenter(gameOverCenter); 					//Add Pane At Center
		gameOverLayout.setBackground(null); 						//Remove Background
		
		//Game Won Layout
		VBox gameWonCenter = new VBox();							//Create VBox
		gameWonCenter.getChildren().addAll(backToMenuButtonWin);	//Add Button
		gameWonCenter.setAlignment(Pos.CENTER);						//Center The VBox

		BorderPane gameWonLayout = new BorderPane();				//Create BorderPane
		gameWonLayout.setCenter(gameWonCenter);						//Add Pane To Center
		gameWonLayout.setBackground(null);							//Remove Background
		
		//Game Layout		
		gameLeft = new VBox();										//Create VBox (For Left Of Game Scene)
		gameLeft.getChildren().addAll(worldSummary, instructions, typeToPlay);	//Add Labels
		ScrollPane scrollGameLeft = new ScrollPane();				//Allows Game To Scroll Down
		scrollGameLeft.setContent(gameLeft);						//Add GameLeft VBox
		scrollGameLeft.setVbarPolicy(ScrollBarPolicy.NEVER);		//Scroll Bar Visibility
		scrollGameLeft.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollGameLeft.setPrefViewportWidth(gameWidth - 14);		//Set Width Of Scroll Area
		scrollGameLeft.setStyle("-fx-background: black;"			//Color It
							+ "-fx-border-color: black;");			//#00ff66
		
		//Scroll To Bottom + Scroll By Clicking/Dragging
		scrollGameLeft.vvalueProperty().bind(gameLeft.heightProperty());
		scrollGameLeft.setPannable(true);
		
		HBox gameBottom = new HBox();								//Create HBox (For Bottom Of Game Scene)
		gameBottom.getChildren().addAll(arrow, playerInput);		//Add Arrow & User Text Field
		gameBottom.setAlignment(Pos.CENTER_LEFT);					//Vertically Center HBox
		
		BorderPane gameLayout = new BorderPane();					//Create A BorderPane (Scene Layout)
		gameLayout.setLeft(scrollGameLeft);							//Add A Pane At The Left Of The Scene (VBox)
		gameLayout.setBottom(gameBottom);							//Add A Pane At The Bottom Of The Scene (VBox)
		gameLayout.setBackground(null);								//Remove The Background
		
		
		//---------------------------------------------------------------------------------------
		
		
		//Create Scenes
		
		
		//Main Menu Scene
		mainMenuScene = new Scene(mainMenuLayout, gameWidth, gameHeight, Color.BLACK);
		
		//Game Scene
		gameAreaScene = new Scene(gameLayout, gameWidth, gameHeight, Color.BLACK);
		
		//Game Over Scene
		gameOverScene = new Scene(gameOverLayout, gameWidth, gameHeight, Color.BLACK);
		
		//Game Won Scene
		gameWonScene = new Scene(gameWonLayout, gameWidth, gameHeight, Color.BLACK);
		
		//---------------------------------------------------------------------------------------
		
		window.setScene(mainMenuScene);								//Start With Main Menu Scene Displayed
		window.show();												//Display The Window
		
	}//End of Start Method
	
	//For Giving The Next Story Label A Style
	public void setStyle(Label label, String currentColor)
	{		
		label.setBackground(null);							
		label.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 14));
		
		if (currentColor.equals("BLUE")) 
		{
			label.setTextFill(Color.rgb(173,216,230));
		}
		else if (currentColor.equals("YELLOW")) 
		{
			label.setTextFill(Color.rgb(255,240,89));
		}
		else if (currentColor.equals("PINK")) 
		{
			label.setTextFill(Color.rgb(255,97,232));
		}
		else 
		{
			//GREEN
			label.setTextFill(Color.rgb(0, 255, 102));
		}
		
	}//End of Set Style
	
	//For Changing The Color Of All Previous Story Labels
	public void changeAllLabelsColor (ArrayList<Label> allStoryLabels, String currentColor)
	{
		if (currentColor.equals("BLUE")) 
		{
			for (int i = 0; i < allStoryLabels.size(); i++) 
			{
				allStoryLabels.get(i).setTextFill(Color.rgb(173,216,230));
			}
		}
		else if (currentColor.equals("YELLOW")) 
		{
			for (int i = 0; i < allStoryLabels.size(); i++) 
			{
				allStoryLabels.get(i).setTextFill(Color.rgb(255,240,89));
			}
		}
		else if (currentColor.equals("PINK")) 
		{
			for (int i = 0; i < allStoryLabels.size(); i++) 
			{
				allStoryLabels.get(i).setTextFill(Color.rgb(255,97,232));
			}
		}
		else 
		{
			//GREEN
			for (int i = 0; i < allStoryLabels.size(); i++) 
			{
				allStoryLabels.get(i).setTextFill(Color.rgb(0, 255, 102));
			}
		}
	}//End of Change All Labels Color
	
	
}//End of Class Main Window