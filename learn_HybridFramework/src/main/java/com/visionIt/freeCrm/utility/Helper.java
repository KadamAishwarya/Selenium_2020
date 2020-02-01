package com.visionIt.freeCrm.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//Handle the iFrame
	//3 ways to handle iFrame:index,name/id,webElement
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchToFrame(String id,WebDriver driver)
	{
		driver.switchTo().frame(id);
	}
	public void switchToFrame(WebElement ele,WebDriver driver)
	{
		driver.switchTo().frame(ele);
	}
    public void switchToFrame(WebDriver driver)
    {
    //driver.switchTo().defaultContent();	
    	driver.switchTo().parentFrame();
	}
    //capture screenshots method
    
    public static void captureScreenshot(WebDriver driver,String screenshotname)
    {
    	try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileHandler.copy(srcFile, new File(".//screenshots//crmpro_"+getCurrentDateTime()+"_"+screenshotname+".png"));
		System.out.println("Sucessfuly capture screenshot....");
    	} catch (Exception e) {
    		System.out.println("Screenshot is not captured");
			e.printStackTrace();
		} 
    }
    
    public static String getCurrentDateTime()
    {
    	DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
    	Date currentDate=new Date();
    	return customFormat.format(currentDate);
    	
    }
    
    public static void mouseHoverAndClickActions(WebDriver driver,
    		WebElement contact,WebElement newcontact)
    {
    	Actions action=new Actions(driver);
    action.moveToElement(contact)
    	.moveToElement(newcontact).build().perform();
    }
    
}
