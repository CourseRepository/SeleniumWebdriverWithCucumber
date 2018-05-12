package com.webdriver.page.menu;

import org.openqa.selenium.WebDriver;

import com.webdriver.page.PageBase;

public class NewCasePageClass extends PageBase {

	private WebDriver driver;
	public NewCasePageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
