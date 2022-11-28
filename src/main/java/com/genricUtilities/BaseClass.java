package com.genricUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	WebDriverUtility wLib = new WebDriverUtility();
	
	@BeforeSuite()
	public void configBS() {

		System.out.println("Before Suite");

	}
	
	@BeforeClass()
	public void configBC() throws Throwable{
		
		//initiate browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		System.out.println("Opening the browser");

		//maximize browser window
		driver.manage().window().maximize();
		
		wLib.waitForElementInDOM(driver);

	}

	@AfterClass()
	public void configAC() {

		System.out.println("Closing the browser");
		driver.quit();

	}

	@AfterSuite()
	public void configAS() {

		System.out.println("After Suite");

	}



}
