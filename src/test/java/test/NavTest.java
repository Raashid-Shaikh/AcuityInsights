package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.NavBar;

public class NavTest extends TestBase{

	NavBar navbar;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		navbar = new NavBar();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void clickButtons() throws InterruptedException {
		//navbar.handleFrame();
		navbar.clickOnNav();
		navbar.searchNav();
	}
	
	@Test(priority=2)
	public void handleLogin() {
		navbar.login();
		
		String actualEmailError = navbar.validateEmailError();
		String actualPassError = navbar.validatePassError();
		String expectedEmailError = "You must enter an email address";
		String expectedPassError = "You must enter a password";
		
		Assert.assertEquals(expectedEmailError, actualEmailError);
		Assert.assertEquals(actualPassError, expectedPassError);
	}
	
}
