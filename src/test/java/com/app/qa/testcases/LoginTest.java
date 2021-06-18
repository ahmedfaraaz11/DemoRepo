package com.app.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.app.qa.testbase.TestBase;

public class LoginTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();	
	}
	@Test(priority = 1)
	public void titleTest() {
		
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "Login - PHPTRAVELS", "Title does not match");
	}
	
	@Test(priority = 2)
	public void logoTest(){
	boolean logo = loginPage.validateLogo();
	Assert.assertTrue(logo, "Logo not found");
	}
	
	@Test(priority = 3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username") , prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
