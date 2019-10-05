package controller;

import model.IPlayer;

public class StatsController implements IStatsController
{
	
	IPlayer p = StoryController.player;
	
	@Override
	public String displayStats() 
	{
		return "Stats:"
				+ "\nPlayer Name:" + p.getPlayerName()
				+ "\nPlayer Money:"
				+ "\nPlayer Health: " + p.getPlayerHealth();

	}
	
}//End of Class Stats Controller