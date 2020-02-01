package com.visionIt.freeCrm.TestBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

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
