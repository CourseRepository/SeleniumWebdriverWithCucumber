package com.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonHelper {
	
	private static ButtonHelper buttonHelper;
	private static WebDriver wdDriver;
	
	private ButtonHelper(WebDriver driver){
		wdDriver = driver;
	}
	
	public static ButtonHelper getInstance(WebDriver driver){
		if(buttonHelper == null || wdDriver.hashCode() != driver.hashCode())
			buttonHelper = new ButtonHelper(driver);
		return buttonHelper;
	}
	
	public void click(By locator){
		wdDriver.findElement(locator).click();
	}

}
