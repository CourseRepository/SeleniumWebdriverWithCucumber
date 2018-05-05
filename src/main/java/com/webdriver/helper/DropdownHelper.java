package com.webdriver.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHelper {
	
	private static DropdownHelper drodownHelper;
	private static WebDriver wdDrvier;
	
	private DropdownHelper(WebDriver driver){
		wdDrvier = driver;
	}
	
	public static DropdownHelper getInstance(WebDriver driver){
		if(drodownHelper == null || wdDrvier.hashCode() != driver.hashCode())
			drodownHelper = new DropdownHelper(driver);
		return drodownHelper;
	}
	
	/**
	 * @param locator :- unique 
	 * @param visibleValue :- UI value
	 */
	public void selectByVisibleText(By locator,String visibleValue){
		Select select = new Select(wdDrvier.findElement(locator));
		select.selectByVisibleText(visibleValue);
	}
	
	/**
	 * @param locator
	 * @param index :- Index of the value to be selected
	 */
	public void selectByIndex(By locator,int index){
		Select select = new Select(wdDrvier.findElement(locator));
		select.selectByIndex(index);
		
	}
	
	/**
	 * @param locator
	 * @param valueAttribute :- Corresponding value attribute
	 */
	public void selectByValue(By locator,String valueAttribute){
		Select select = new Select(wdDrvier.findElement(locator));
		select.selectByValue(valueAttribute);
	}
	
	public void selectByValue(WebElement element,String valueAttribute){
		Select select = new Select(element);
		select.selectByValue(valueAttribute);
	}
	
	/**
	 * @param locator
	 * @return List<WebElement> : Each element in list repre a value in drop down
	 */
	public List<WebElement> getAllValues(By locator){
		Select select = new Select(wdDrvier.findElement(locator));
		return select.getOptions();
	}

}
