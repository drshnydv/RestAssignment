package com.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	
	public Product(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//ul[@class='list-unstyled']/li/h2")
	public WebElement priceTxt;
	
	@FindBy(xpath = "//h3[text()='Available Options']")
	public WebElement avaiableOptionSec;
	
	@FindBy(name = "option[218]")
	public WebElement radioChkBox;
	
	@FindBy(xpath = "//input[@name='option[223][]'  and @value='10']")
	public WebElement checkBoxChkBox;
	
	@FindBy(id = "input-option208")
	public WebElement textAreaEdt;
	
	@FindBy(id = "input-option217")
	public WebElement fileDrpDwn;
	
	@FindBy(name = "quantity")
	public WebElement quantityEdt;
	
	@FindBy(id = "button-cart")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@class='form-group required has-error']/descendant::button/following-sibling::div")
	public WebElement errorMsg;

	public WebElement getPriceTxt() {
		return priceTxt;
	}

	public WebElement getAvaiableOptionSec() {
		return avaiableOptionSec;
	}

	public WebElement getRadioChkBox() {
		return radioChkBox;
	}

	public WebElement getCheckBoxChkBox() {
		return checkBoxChkBox;
	}

	public WebElement getTextAreaEdt() {
		return textAreaEdt;
	}

	public WebElement getFileDrpDwn() {
		return fileDrpDwn;
	}

	public WebElement getQuantityEdt() {
		return quantityEdt;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}
	
	public String actPrice() {
		
		String actPrice = getPriceTxt().getText();
		return actPrice;
		
	}
	
	public void clickOnRadioBtn() {
		
		getRadioChkBox().click();
		
	}
	
	public void clickOnCheckBox() {
		
		getCheckBoxChkBox().click();
		
	}
	
	public void editTextArea(String text) {
		
		getTextAreaEdt().clear();
		getTextAreaEdt().sendKeys(text);
		
	}
	
	public void editQuantityEdt(String text) {
		
		getQuantityEdt().clear();
		getQuantityEdt().sendKeys(text);
		
	}
	
	public void clickAddToCart() {
		
		getAddToCartBtn().click();
		getAddToCartBtn().click();
		
	}
	
	public String errorMsg() {
		
		String errorMsg = getErrorMsg().getText();
		return errorMsg;
		
	}

}
