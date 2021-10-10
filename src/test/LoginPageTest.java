package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parking.LoginPage;

public class LoginPageTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void LoginTest()
	{
		LoginPage obj = new LoginPage();
		assertTrue(obj.loginactivity("admin", "admin"));
	}
	
	
	@Test
	public void LoginFail()
	{
		LoginPage obj = new LoginPage();
		assertFalse(obj.loginactivity("", "admin"));
	}
	
	
	@Test
	public void LoginFail_2()
	{
		LoginPage  obj = new LoginPage();
		assertFalse(obj.loginactivity("admin", ""));
	}
	

	@Test
	public void LoginFail_3()
	{
		LoginPage obj = new LoginPage();
		assertFalse(obj.loginactivity("", ""));
	}
	
		
	@Test
	public void LoginFail_4()
	{
		LoginPage  obj = new LoginPage();
		assertFalse(obj.loginactivity("Jitendra", "Joshi"));
	}
	
}
