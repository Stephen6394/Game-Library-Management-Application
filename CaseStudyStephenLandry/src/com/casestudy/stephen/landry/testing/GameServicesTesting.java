package com.casestudy.stephen.landry.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.casestudy.stephen.landry.entities.Game;
import com.casestudy.stephen.landry.services.GameServices;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameServicesTesting {
	
	Game expected;
	static GameServices gameServices = new GameServices();
	
	public GameServicesTesting(Game expected) {
		super();
		this.expected = expected;
	}
	
	//Game objects used for each test
	@Parameterized.Parameters
	public static Collection params() {
		return Arrays.asList(new Object[][]{
				{new Game("Battlefield 3", "Xbox360", 60.00,"M")},
				{new Game("Dead Space", "Xbox360", 60.00,"M")},
				{new Game("Neir", "Xbox360", 60.00,"M")},
				{new Game("Halo Wars", "Xbox360", 60.00,"M")}
		});
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//testing adding a game to the database
	@Test
	public void stage1_testAddGame() {
		System.out.println("Test Add Game");
		System.out.println(expected.toString());
				
		assertTrue(gameServices.addGame(expected));
	}
	
	//testing getting a game based on name from database
	@Test
	public void stage2_testGetGameByName(){
		System.out.println("Test get game by name");
		System.out.println(expected.toString());
		
		Game actual = gameServices.getGameByName(expected.getName());
		
		assertEquals(expected,actual);
	}
	
	//testing getting all games within the database
	@Test
	public void stage2_testGetAllGames() {
		System.out.println("Test get all games");
		System.out.println(expected.toString());
		
		boolean result = false;
		System.out.println("about to populate list");
		List<Game> actual = gameServices.getAllGames();
		System.out.println("list size: " + actual.size());
		System.out.println("populated list");
		for(Game element : actual)
		{
			System.out.println("PING");
			System.out.println(element.toString());
			System.out.println(expected.toString());
			if(element.equals(expected))
			{
				System.out.println("found a match");
				result=true;
				break;
			}
		}
		assertTrue(result);
	}
	
	//testing removing a game from the database
	@Test
	public void stage3_testRemoveGame() {
		System.out.println("test remove game");
		System.out.println(expected.toString());
		
		assertTrue(gameServices.removeGame(expected.getName()));
	}

}
