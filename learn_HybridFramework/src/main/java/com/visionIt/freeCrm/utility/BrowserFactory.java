package com.visionIt.freeCrm.utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	
	public static WebDriver browserSetup(String bname,String url)
	{
		if(bname.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");

			driver=new ChromeDriver();
		}
		else if(bname.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".//Driver//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(bname.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"//.Driver//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Browser name is not matching");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	public void quitBrowser()
	{
		driver.quit();
	}
	
}
	
