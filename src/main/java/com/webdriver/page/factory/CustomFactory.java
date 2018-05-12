package com.webdriver.page.factory;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;

import com.webdriver.page.EnterBugClass;
import com.webdriver.page.HomePageClass;
import com.webdriver.page.LoginPageClass;
import com.webdriver.page.PageBase;
import com.webdriver.page.menu.NewCasePageClass;
import com.webdriver.page.menu.NewRunPageClass;
import com.webdriver.page.menu.ProductDashboardPageClass;
import com.webdriver.page.menu.SearchPageClass;

public class CustomFactory {
	
	/*
	 * Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class instance
	 * Super Class - PageBase -> HomePageClass, LoginPageClass, EnterBugClass so on
	 * Navigation --> Based on input we need to have intance of corr page class
	 * */
	
	public static PageBase getInstance(PageName name,WebDriver driver) {
		
		switch (name) {
			case HomePage:
				return new HomePageClass(driver);
			case LoginPage:
				return new LoginPageClass(driver);
			case NewCasePage:
				return new NewCasePageClass(driver);
			case NewRunPage:
				return new NewRunPageClass(driver);
			case ProductDashboardPage:
				return new ProductDashboardPageClass(driver);
			case SearchPage :
				return new SearchPageClass(driver);
			case EnterBugPage :
				return new EnterBugClass(driver);

		default:
			throw new RuntimeException("Invalid Page Name");
		}
		
	}

}
