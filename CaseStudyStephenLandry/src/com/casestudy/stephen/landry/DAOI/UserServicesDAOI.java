package com.casestudy.stephen.landry.DAOI;

import com.casestudy.stephen.landry.entities.Game;
import com.casestudy.stephen.landry.entities.User;

public interface UserServicesDAOI {
	
	//Method for adding user to the database
	boolean addUser(User user);

	//Method for pulling user data based on name from the databasse
	User getUserByName(String name);

	//method to update user within database
	boolean updateUser(User user);

	//method to remove user from database
	boolean removeUser(User user);

	//Method to add a game to a user's library
	boolean addGameToLibrary(User user, Game game);
}
