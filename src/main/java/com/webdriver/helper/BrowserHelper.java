package com.webdriver.helper;

import org.openqa.selenium.WebDriver;

public class BrowserHelper {
	
	private static BrowserHelper browserHelper;
	private static WebDriver wdDrvier;
	
	private BrowserHelper(WebDriver driver){
		wdDrvier = driver;
	}
	
	public static BrowserHelper getInstance(WebDriver driver){
		if(browserHelper == null || wdDrvier.hashCode() != driver.hashCode())
			browserHelper = new BrowserHelper(driver);
		return browserHelper;
	}
	
	// Sigleton Design patter
	
	/**
	* The cons should be private - so no other class can create the object of this class
	* To get the instance use the getInstance method
	*/
	
	
	public void moveForward(){
		wdDrvier.navigate().forward();
	}
	
	public void moveBackword(){
		wdDrvier.navigate().back();
	}
	
	public void refresh(){
		wdDrvier.navigate().refresh();
	}
	
	public void maximize(){
		wdDrvier.manage().window().maximize();
	}

}
