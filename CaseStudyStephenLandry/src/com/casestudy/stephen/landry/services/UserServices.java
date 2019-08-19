package com.casestudy.stephen.landry.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.casestudy.stephen.landry.DAOI.UserServicesDAOI;
import com.casestudy.stephen.landry.entities.Game;
import com.casestudy.stephen.landry.entities.User;

public class UserServices implements UserServicesDAOI {
	String projectName = "CaseStudyStephenLandry";

	//Add a registered user to the database
	@Override
	public boolean addUser(User user) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(projectName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		}
		entityManager.close();
		entityManagerFactory.close();
		return result;
	}

	//return a user from the database based on name
	@Override
	public User getUserByName(String name) {
		User foundUser = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(projectName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			foundUser = entityManager.find(User.class, name);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		entityManager.close();
		entityManagerFactory.close();

		return foundUser;
	}

	//Update a given serr within the database with new user object fields
	@Override
	public boolean updateUser(User user) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(projectName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			User foundUser = entityManager.find(User.class, user.getName());
			foundUser.setPassword(user.getPassword());
			foundUser.setEmail(user.getEmail());
			foundUser.setGameLibrary(user.getGameLibrary());
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		}
		entityManager.close();
		entityManagerFactory.close();
		return result;
	}

	//remove a user from the database
	@Override
	public boolean removeUser(User user) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(projectName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			User foundUser = entityManager.find(User.class, user.getName());
			entityManager.remove(foundUser);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		}
		entityManager.close();
		entityManagerFactory.close();
		return result;
	}

	//Logic for adding a game to a given user's library
	@Override
	public boolean addGameToLibrary(User user, Game game) {
		boolean result = true;
		List<Game> gameLibrary = user.getGameLibrary();
		for(Game item : gameLibrary) {
			if(item.getName().equals(game.getName())) {
				result = false;
				return result;
			}
		}
		gameLibrary.add(game);
		user.setGameLibrary(gameLibrary);
		return result;
	}
}
