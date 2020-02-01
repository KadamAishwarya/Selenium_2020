package com.visionIt.freeCrm.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.visionIt.freeCrm.utility.Helper;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath="//*[@href='https://www.crmpro.com/system/index.cfm?action=contact']")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@href='https://www.crmpro.com/system/index.cfm?action=contact&sub=load&edit=1']")
	WebElement newcontactsLink;
	
	@FindBy(xpath="//html//body//table[1]//tbody//tr[1]//td//table//tbody//tr//td[1]")
	WebElement loggedUserName;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public String verifyloggedUserName() {
		
		return loggedUserName.getText();
	}
	
	//iframe name=mainpanel
	public NewContactPage navigatetoNewContactPage() {
		Helper.mouseHoverAndClickActions(driver, contactsLink, newcontactsLink);
		//newcontacsLink.click();
		return new NewContactPage(driver);
	}

}
