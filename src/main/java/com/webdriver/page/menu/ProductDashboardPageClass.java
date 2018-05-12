package com.webdriver.page.menu;

import org.openqa.selenium.WebDriver;

import com.webdriver.page.PageBase;

public class ProductDashboardPageClass extends PageBase {
	
	private WebDriver driver;
	public ProductDashboardPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
