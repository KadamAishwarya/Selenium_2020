package com.visionIt.freeCrm.TestCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.visionIt.freeCrm.Pages.HomePage;
import com.visionIt.freeCrm.Pages.Loginpage;
import com.visionIt.freeCrm.TestBase.TestBase;
import com.visionIt.freeCrm.utility.BrowserFactory;
import com.visionIt.freeCrm.utility.Helper;

public class HomePageTest extends TestBase {
    Loginpage login;
	public WebDriver driver;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp()
	{
	driver=BrowserFactory.browserSetup(configaDataprovider.getKey("browser"),
			configaDataprovider.getKey("url"));
	//login=PageFactory.initElements(driver, Loginpage.class);
	login=new Loginpage(driver);
	homepage=login.verifyLoginIntoAnApplication(excelDataProvider.getStringCellData("freeCrm_login", 1, 0),
			excelDataProvider.getStringCellData("freeCrm_login", 1, 1));
	
			/*(excelDataProvider.getStringCellData(1, 1, 0),
					excelDataProvider.getStringCellData(1, 1, 1));*/
	
	}
	@Test(priority=1)
	public void verifyloggedUserNameTest()
	{
		//driver.switchTo().frame("mainpanel");
		helper.switchToFrame(driver, "mainpanel");
		String uname=homepage.verifyloggedUserName();
		
		if(uname.contains("Mayuri"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	@Test(priority=2)
	public void navigatetoNewContactPageTest()
	{
		//driver.switchTo().frame("mainpanel");
		helper.switchToFrame(driver, "mainpanel");
		homepage.navigatetoNewContactPage();
	    Helper.captureScreenshot(driver, "contact");
	}
	
}
