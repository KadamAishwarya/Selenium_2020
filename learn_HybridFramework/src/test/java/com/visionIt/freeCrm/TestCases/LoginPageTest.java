package com.visionIt.freeCrm.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.visionIt.freeCrm.Pages.Loginpage;
import com.visionIt.freeCrm.TestBase.TestBase;
import com.visionIt.freeCrm.utility.BrowserFactory;

//import Excel_Read_Write.ExcelDataProvider;

public class LoginPageTest extends TestBase{

	public Loginpage login;
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	driver=BrowserFactory.browserSetup(configaDataprovider.getKey("browser"),
			configaDataprovider.getKey("url"));
	//login=PageFactory.initElements(driver, Loginpage.class);
	login=new Loginpage(driver);
	}
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		String actualTitle=login.verifyLoginpageTitle();
		System.out.println("actual Title of the login page is:"+actualTitle);
		String expectedTitle="CRMPRO - CRM software for customer "
				+ "relationship management, sales, and support.";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/*@Test(priority=2)
	public void verifyLoginTest()
	{
		login.verifyLogin(excelDataProvider.getStringCellData("freeCrm_login", 1, 0),
				excelDataProvider.getStringCellData("freeCrm_login", 1, 1));
		helper.captureScreenshot(driver, "freeCrm_login");
	}
	/*
	 //for Excel DataProvider
	@Test(dataProvider ="getData")
	public void verifyLoginTest(String uname,String Pass)
	{
		login.verifyLogin(uname, Pass);
		//login.verifyLogin(excelDataProvider.getStringCellData("freeCrm_login", 1, 0),
				excelDataProvider.getStringCellData("freeCrm_login", 1, 1));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return excelDataProvider.getExcelData("login_smoke");
		
	}

*/	
	//for Config DataProvider
	@Test(priority=2)
	public void verifyLoginIntoAnApplicationTest()
		{
			login.verifyLoginIntoAnApplication(configaDataprovider.getKey("username"),
					configaDataprovider.getKey("password"));
			
			
			//driver.switchTo().frame("mainpanel");
			helper.switchToFrame(driver, "mainpanel");
			
			WebElement username=driver.findElement
					(By.xpath("//td[@align='left' and @class='headertext']"));
			
			
			String user=username.getText();
			System.out.println("logged in user name is:"+user);
			
			if(user.contains("Mayuri")){
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
			
	}
}
