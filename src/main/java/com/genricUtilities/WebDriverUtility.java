package com.genricUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 *   contains all reusable Actions of Webdriver 
 *
 */
public class WebDriverUtility{
	/**
	 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstants.Implicitly_TIMEOUT, TimeUnit.SECONDS);
	}
	
	/**
	 * used to select the value from the dropDwon  based on value / option available in GUI
	 * @param element
	 * @param value
	 */
	
	public void selectV(WebElement element , String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	
	public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	
	public void executeJavaScript(WebDriver driver , WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	   
}



