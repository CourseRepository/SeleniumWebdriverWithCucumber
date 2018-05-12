package com.webdriver.page.menu;

import org.openqa.selenium.WebDriver;

import com.webdriver.page.PageBase;

public class SearchPageClass extends PageBase {
	
	private WebDriver driver;
	public SearchPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
