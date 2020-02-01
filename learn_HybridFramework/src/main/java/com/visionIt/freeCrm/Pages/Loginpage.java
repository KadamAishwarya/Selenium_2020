package com.visionIt.freeCrm.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//public WebDriver driver;
	//Object Repository
	@FindBy(name="username")
	WebElement user;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public String verifyLoginpageTitle()
	{
		
		return driver.getTitle();
	}
	public HomePage verifyLoginIntoAnApplication(String un,String up)
	{
		
		user.sendKeys(un);
		pass.sendKeys(up);
		loginBtn.click();
	return new HomePage(driver);
	}

	

	
}
