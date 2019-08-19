package com.casestudy.stephen.landry.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.stephen.landry.entities.Game;
import com.casestudy.stephen.landry.entities.User;
import com.casestudy.stephen.landry.services.GameServices;
import com.casestudy.stephen.landry.services.UserServices;

@Controller
@SessionAttributes("suser")
public class MainController {
	
	//Handling for main page to direct to login or register
	@RequestMapping(value= {"/","/index"})
	public ModelAndView showIndex(){
		return new ModelAndView("index");
	}
	
	//Show the register page
	@RequestMapping("/RegisterUser")
	public ModelAndView showRegister() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}
	
	//Logic for login prompt
	@RequestMapping("/AddUser")
	public ModelAndView addUser(@Valid @ModelAttribute User user, BindingResult errors, String verPassword) {
		ModelAndView mav = new ModelAndView("register");
		String message = "Try again";
		//if there are errors return to registration
		if(errors.hasErrors()) {
			return mav;
		}
		//return error if password mismatch
		if(!user.getPassword().equals(verPassword))
		{
			message = "Passwords do not match. Please try again...";
			mav.addObject("messageResult", message);
			return mav;
		}
		//else redirect to the home page for user
		UserServices userServices = new UserServices();
		boolean result = userServices.addUser(user);
		if(result)
		{
			mav.addObject("suser", user);
			message = "User added";
			mav.setViewName("redirect:/Home");
			
		}
		mav.addObject("messageResult", message);
		return mav;
	}
	
	//logic for login verification
	@RequestMapping("/VerifyUser")
	public ModelAndView verifyUser(@ModelAttribute User user) {
		String librarySize;
		ModelAndView mav = new ModelAndView("index");
		UserServices userServices = new UserServices();
		User foundUser = userServices.getUserByName(user.getName());
		String message = "Incorrect username or password";
		if(foundUser != null && foundUser.getPassword().equals(user.getPassword()))
		{
			librarySize = Integer.toString(foundUser.getGameLibrary().size());
			mav.addObject("librarySize", librarySize);
			mav.addObject("suser", foundUser);
			message = "logged in";
			mav.setViewName("redirect:/Home");
		}
		mav.addObject("messageResult", message);
		return mav;
	}
	
	//logic for logging out user
	@RequestMapping("/LogoutUser")
	public ModelAndView logoutUser(@SessionAttribute("suser") User user) {
		ModelAndView mav = new ModelAndView();
		mav.clear();
		mav.setViewName("index");
		return mav;
	}
	
	//show the home page
	@RequestMapping("/Home")
	public ModelAndView showHome(@SessionAttribute("suser") User user) {
		String librarySize;
		ModelAndView mav = new ModelAndView("home");
		librarySize = Integer.toString(user.getGameLibrary().size());
		mav.addObject("librarySize", librarySize);
		return mav;
	}
	
	//Show the account settings page
	@RequestMapping("/AccountSettings")
	public ModelAndView showAccountSettings() {
		return new ModelAndView("accountSettings");
	}
	
	//Show the user's library page
	@RequestMapping("/ViewLibrary")
	public ModelAndView showLibrary(@SessionAttribute("suser") User user) {
		List<Game> gameLibrary = user.getGameLibrary();
		ModelAndView mav = new ModelAndView("library");
		mav.addObject("gameLibrary", gameLibrary);
		return mav;
	}
	
	//Update the user's email
	@RequestMapping("/UpdateEmail")
	public ModelAndView updateEmail(@SessionAttribute("suser") User user, String newEmail) {
		String message = "Email not updated";
		ModelAndView mav = new ModelAndView("accountSettings");
		UserServices userServices = new UserServices();
		if(newEmail != null)
		{
			user.setEmail(newEmail);
			if(userServices.updateUser(user))
			{
				message = "Email updated";
				mav.addObject("suser",user);
			}
		}
		mav.addObject("emailMessageResult", message);
		return mav;
	}
	
	//Update the user's password
	@RequestMapping("/UpdatePassword")
	public ModelAndView updatePassword(@SessionAttribute("suser") User user, String newPassword, String verPassword) {
		String message = "Password not updated.";
		ModelAndView mav = new ModelAndView("accountSettings");
		UserServices userServices = new UserServices();
		if(newPassword != null)
		{
			if(!newPassword.equals(verPassword))
			{
				message = "Passwords do not match. Please try again...";
				mav.addObject("passwordMessageResult", message);
				return mav;
			}
			user.setPassword(newPassword);
			if(userServices.updateUser(user))
			{
				message = "Password updated.";
				mav.addObject("suser",user);
			}
		}
		mav.addObject("passwordMessageResult", message);
		return mav;
	}
	
	//Show the warning page for final decision on account deletion
	@RequestMapping("/DeleteAccountWarning")
	public ModelAndView showDeleteAccountWarning(){
		return new ModelAndView("deleteAccountWarning");
	}
	
	//Logic for deleting the user
	@RequestMapping("/DeleteUser")
	public ModelAndView deleteUser(@SessionAttribute("suser") User user) {
		ModelAndView mav = new ModelAndView("deleteAccountWarning");
		UserServices userServices = new UserServices();
		if(userServices.removeUser(user))
		{
			mav.clear();
			mav.setViewName("index");
		}
		else
		{
			mav.addObject("messageResult", "Error: User not deleted.");
		}
		return mav;
	}
	
	//show the game search menu to add game to user library
	@RequestMapping("/AddToLibrary")
	public ModelAndView showAddToLibrary() {
		GameServices gameServices = new GameServices();
		List<Game> gameCatalog = gameServices.getAllGames();
		ModelAndView mav = new ModelAndView("registerGame");
		mav.addObject("gameArchive", gameCatalog);
		return mav;
	}
	
	//Logic for adding game to the database
	@RequestMapping("/AddGame")
	public ModelAndView addGame(@ModelAttribute Game game) {
		ModelAndView mav = new ModelAndView("registerGame");
		String message = "Try again";
		GameServices gameServices = new GameServices();
		boolean result = gameServices.addGame(game);
		if(result)
		{
			message = "Game added";			
		}
		mav.addObject("messageResult", message);
		return mav;
	}
	
	//logic for adding a game to user's library and update user in the database
	@RequestMapping("/AddGameToUser")
	public ModelAndView addGameToUser(@SessionAttribute("suser") User user, @ModelAttribute Game game) {
		ModelAndView mav = new ModelAndView("registerGame");
		String message = "Game not found in archive";
		UserServices userServices = new UserServices();
		GameServices gameServices = new GameServices();
		Game foundGame = gameServices.getGameByName(game.getName());
		if(foundGame != null)
		{	
			message = "Game added to library";
			userServices.addGameToLibrary(user, foundGame);	
		}
		if(userServices.updateUser(user))
		{
			mav.addObject("suser", user);
		}
		mav.addObject("messageResult", message);
		mav.addObject("suser", user);
		return mav;
	}
	
	//Add game to user library and update database based on catalog decision
	@RequestMapping("/AddGameFromCatalog/{urlName}")
	public ModelAndView addGameFromCatalog(@PathVariable("urlName") String gameName, @SessionAttribute("suser") User user) {
		ModelAndView mav = new ModelAndView("catalog");
		UserServices userServices = new UserServices();
		GameServices gameServices = new GameServices();
		Game foundGame = gameServices.getGameByName(gameName);
		if(foundGame != null)
		{	
			if(userServices.addGameToLibrary(user, foundGame) && userServices.updateUser(user)) {
				mav.addObject("suser", user);
			}
		}		
		mav.setViewName("redirect:/ViewCatalog");
		return mav;
	}
	
	//remove a given game from user's library and update the database
	@RequestMapping("/removeGame/{urlName}")
	public ModelAndView deleteGame(@PathVariable("urlName") String gameName, @SessionAttribute("suser") User user) {
		ModelAndView mav = new ModelAndView("redirect:/ViewLibrary");
		String message = "Game not deleted";
		UserServices userServices = new UserServices();
		List<Game> gameLibrary = user.getGameLibrary();
		for(Game game : gameLibrary)
		{
			if(game.getName().contentEquals(gameName))
			{
				gameLibrary.remove(game);
				break;
			}
		}	
		user.setGameLibrary(gameLibrary);
		if(userServices.updateUser(user))
		{
			mav.addObject("suser", user);
			message = "Game removed from library";
		}
		mav.addObject("messageResult", message);
		mav.addObject("gameLibrary", gameLibrary);
		return mav;
	}
	
	//View page that displays all the games in the main archive
	@RequestMapping("/ViewCatalog")
	public ModelAndView viewCatalog(@SessionAttribute("suser") User user) {
		GameServices gameServices = new GameServices();
		List<Game> gameCatalog = gameServices.getAllGames();
		ModelAndView mav = new ModelAndView("catalog");
		mav.addObject("gameCatalog", gameCatalog);
		mav.addObject("user", user);
		return mav;
	}
}
