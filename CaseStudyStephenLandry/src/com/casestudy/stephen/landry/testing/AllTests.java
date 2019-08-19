package com.casestudy.stephen.landry.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GameServicesTesting.class, UserServicesTesting.class, UserServicesUpdateUserTest.class })
public class AllTests {

}
