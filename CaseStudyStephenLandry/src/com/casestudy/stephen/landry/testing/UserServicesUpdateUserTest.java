package com.casestudy.stephen.landry.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.casestudy.stephen.landry.entities.User;
import com.casestudy.stephen.landry.services.UserServices;

public class UserServicesUpdateUserTest {

	static UserServices userServices = new UserServices();
	static User testUser; 
	

	//Create a fake user for the below test
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testUser = new User("test name", "test password", "test@email.com", null);
		userServices.addUser(testUser);
	}

	//delete the user used for testing
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userServices.removeUser(testUser);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//test updating user with new parameters within database
	@Test
	public void testUpdateUser() {
		
		User expected = new User("test name", "expectedPassword", "expected@email.com", null);
		
		userServices.updateUser(expected);
		
		User actual = userServices.getUserByName(expected.getName());
		
		assertEquals(expected, actual);
	}
}
