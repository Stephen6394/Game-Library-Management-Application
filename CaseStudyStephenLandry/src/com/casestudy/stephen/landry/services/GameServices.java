package com.casestudy.stephen.landry.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.casestudy.stephen.landry.DAOI.GameServicesDAOI;
import com.casestudy.stephen.landry.entities.Game;

public class GameServices implements GameServicesDAOI {
	String projectName = "CaseStudyStephenLandry";

	//add game to the main database
	@Override
	public boolean addGame(Game game) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(projectName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(game);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		}
		entityManager.close();
		entityManagerFactory.close();
		return result;
	}
	
	//retrieve a given game from the database
	@Override
	public Game getGameByName(String gameName) {
		Game foundGame = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(projectName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			foundGame = entityManager.find(Game.class, gameName);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		entityManager.close();
		entityManagerFactory.close();
		return foundGame;
	}
	
	//return all games in the database
	public List<Game> getAllGames()
	{
		List<Game> gameArchive = new ArrayList();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(projectName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{
			Query query = entityManager.createNamedQuery("GetAllGames");
			gameArchive = query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		entityManager.close();
		entityManagerFactory.close();
		return gameArchive;
	}
	
	//remove a game from the database
	@Override
	public boolean removeGame(String gameName) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(projectName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Game foundGame = entityManager.find(Game.class, gameName);
			entityManager.remove(foundGame);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		}
		entityManager.close();
		entityManagerFactory.close();
		return result;
	}
}
