package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Monitors {
	
	public Monitors(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//p[@class='price']/span[@class='price-new']")
	public WebElement PriceTxt;
	
	@FindBy(xpath = "//a[text()='Apple Cinema 30\"']")
	public WebElement productBtn;

	public WebElement getPriceTxt() {
		return PriceTxt;
	}

	public WebElement getProductBtn() {
		return productBtn;
	}
	
	public String expPrice() {
		
		String expPrice = getPriceTxt().getText();
		return expPrice;
		
	}
	
	public void clickOnProduct() {
		
		getProductBtn().click();
		
	}
	
}
