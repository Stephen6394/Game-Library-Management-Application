package com.casestudy.stephen.landry.DAOI;

import com.casestudy.stephen.landry.entities.Game;

public interface GameServicesDAOI {

	//method for adding game to database 
	boolean addGame(Game game);

	//method for removing game from database
	boolean removeGame(String gameName);

	//method for pulling game data from database
	Game getGameByName(String gameName);
}
