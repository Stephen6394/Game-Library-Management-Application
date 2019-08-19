package com.casestudy.stephen.landry.testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import com.casestudy.stephen.landry.entities.Game;
import com.casestudy.stephen.landry.entities.User;
import com.casestudy.stephen.landry.services.GameServices;
import com.casestudy.stephen.landry.services.UserServices;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServicesTesting {

	User expected;
	static UserServices userServices = new UserServices();
	
	public UserServicesTesting(User expected) {
		super();
		this.expected = expected;
	}
	
	//user objects to be used for the following tests
	@Parameterized.Parameters
	public static Collection params() {
		return Arrays.asList(new Object[][]{
				{new User("Name1", "password1", "first@email.com", null)},
				{new User("Name2", "password2", "second@email.com", null)},
				{new User("Name3", "password3", "third@email.com", null)},
				{new User("Name4", "password4", "fourth@email.com" , null)}
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

	///testing adding a user to the database
	@Test
	public void stage1_testAddUser() {
		System.out.println("Test Add User");
		System.out.println(expected.toString());
				
		assertTrue(userServices.addUser(expected));
	}

	//test retrieving user from database based on name
	@Test
	public void stage2_testGetUserByName() {
		System.out.println("Test get user by name");
		System.out.println(expected.toString());
		
		User actual = userServices.getUserByName(expected.getName());
		
		assertEquals(expected,actual);
	}

	//test to remove user
	@Test
	public void stage3_testRemoveUser() {
		System.out.println("test remove user");
		System.out.println(expected.toString());
		
		assertTrue(userServices.removeUser(expected));
	}

	//test to add a game to a user's library
	@Test
	public void stage2_testAddGameToLibrary() {
		System.out.println("test add game to library");
		System.out.println(expected.toString());
		
		Game testGame = new Game("Test name", "Test platform", 60.0, "test rating");
		userServices.addGameToLibrary(expected, testGame);
		
		assertTrue(expected.getGameLibrary().contains(testGame));
	}

}
