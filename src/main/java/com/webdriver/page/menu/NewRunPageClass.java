package com.webdriver.page.menu;

import org.openqa.selenium.WebDriver;

import com.webdriver.page.PageBase;

public class NewRunPageClass extends PageBase {

	private WebDriver driver;
	public NewRunPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
