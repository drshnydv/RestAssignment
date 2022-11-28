package org.demo;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genricUtilities.BaseClass;
import com.genricUtilities.ExcelUtility;
import com.genricUtilities.FileUtility;
import com.genricUtilities.WebDriverUtility;
import com.pomrepository.Home;
import com.pomrepository.Monitors;
import com.pomrepository.Product;

public class tutorialsNinjaTest extends BaseClass{

	@Test
	public void demoTest() throws Throwable {
		
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		String url = fLib.getPropertyKeyValue("URL");
		
		String expTitle = eLib.getExcelData("Demo", 1, 0);
		String text = eLib.getExcelData("Demo", 1, 1);
		String drpDwnValue = eLib.getExcelData("Demo", 1, 2);
		String quantity = eLib.getExcelData("Demo", 1, 3);
		String expErrMsg = eLib.getExcelData("Demo", 1, 4);
		
		// entering the URL
		driver.get(url);

		//getting page title
		String actTitle = driver.getTitle();
		
		//verifying page title
		Assert.assertEquals(expTitle, actTitle);
		System.out.println(actTitle + " ==> Title is Verified");
		
		Home hme = new Home(driver);
		
		//selecting drop down element
		WebElement components = hme.getComponentsDrpDwn();

		//mouse overing on element
		wLib.mouseOverOnElement(driver, components);

		//selecting value in drop down
		hme.clickOnMonitors();
		
		Monitors mntr = new Monitors(driver);

		//getting expected price
		String expPrice = mntr.expPrice();

		//clicking on product
		mntr.clickOnProduct();
		
		Product pro = new Product(driver);

		//getting actual price
		String actPrice = pro.actPrice();

		//verifying the price
		Assert.assertEquals(expPrice, actPrice);
		System.out.println(actPrice + " ==> Price is verfied");
		
		//getting element for scroll down
		WebElement ele = pro.getAvaiableOptionSec();
		
		//scrolling to element
		wLib.executeJavaScript(driver, ele);
		
		//selecting radio check box
		pro.clickOnRadioBtn();
		
		//selecting check box
		pro.clickOnCheckBox();
		
		//entering the value to text field
		pro.editTextArea(text);
		
		//selecting element for drop down
		WebElement select = pro.getFileDrpDwn();
		
		//selecting value in drop down
		wLib.selectV(select, drpDwnValue);
		
		//entering the value in quantity text field
		pro.editQuantityEdt(quantity);
		
		//clicking on add to cart
		pro.clickAddToCart();
		
		//getting error message
		String actErrMsg = pro.errorMsg();
		
		//verifying error message
		Assert.assertEquals(expErrMsg, actErrMsg);
		System.out.println(actErrMsg + " ==> Error message is verfied");

	}

}