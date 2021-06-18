package com.app.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.testbase.TestBase;

public class LoginPage extends TestBase
{

	@FindBy(xpath ="//a[@class = 'lvl-0 sign-in btn btn-md btn-white-outline open']")
	WebElement loginLink;
	
	@FindBy(xpath ="//img[@alt='PHPTRAVELS']")
	WebElement logo;
	
	@FindBy(name ="username")
	WebElement usernameField;
	
	@FindBy(name ="password")
	WebElement passwordField;
	
	@FindBy(xpath ="//span[@role = 'checkbox']")
	WebElement checkboxRobot;

	@FindBy(id ="login")
	WebElement loginButton;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle(){
	return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return logo.isDisplayed();
	}
	
	public HomePage login(String uname, String pass){
		usernameField.sendKeys(uname);
		passwordField.sendKeys(pass);
		loginButton.click();
		
		return new HomePage();
	}
	
}

