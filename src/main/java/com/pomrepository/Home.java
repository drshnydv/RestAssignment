package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	public Home(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()='Components']")
	public WebElement componentsDrpDwn;
	
	@FindBy(xpath = "//a[text()='Monitors (2)']")
	public WebElement MonitorBtn;

	public WebElement getComponentsDrpDwn() {
		return componentsDrpDwn;
	}

	public WebElement getMonitorBtn() {
		return MonitorBtn;
	}
	
	public void clickOnMonitors() {
		
		getMonitorBtn().click();
		
	}
	
}
