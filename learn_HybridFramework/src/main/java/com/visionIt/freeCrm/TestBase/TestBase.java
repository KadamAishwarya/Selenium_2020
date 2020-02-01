package com.visionIt.freeCrm.TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.visionIt.freeCrm.Pages.Loginpage;
import com.visionIt.freeCrm.utility.BrowserFactory;
import com.visionIt.freeCrm.utility.ConfigDataProvider;
import com.visionIt.freeCrm.utility.ExcelDataProvider;
import com.visionIt.freeCrm.utility.Helper;

public class TestBase {

	//public static WebDriver driver;
	public Helper helper;
	public ConfigDataProvider configaDataprovider;
	public BrowserFactory browserFactory;
	public ExcelDataProvider excelDataProvider;
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
	@BeforeSuite
	public void init()
	{
		helper=new Helper();
	    configaDataprovider=new ConfigDataProvider();
	    excelDataProvider=new ExcelDataProvider();
		browserFactory=new BrowserFactory();
		//driver=BrowserFactory.browserSetup("chrome", "https://www.crmpro.com/");
	}
	@AfterMethod
	public void tearDown()
	{
		browserFactory.quitBrowser();
	}
}
