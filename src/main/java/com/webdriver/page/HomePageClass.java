package com.webdriver.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass extends PageBase {
	
	private WebDriver driver;
	
	public HomePageClass(WebDriver driver){
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	// WebElement
	/*public By fileABuglink = By.id("enter_bug");
	public By quickSearchTextBox = By.id("quicksearch_main");*/
	
	@FindBy(how = How.ID,using = "enter_bug")
	public WebElement fileABuglink;
	@FindBy(how = How.ID,using = "quicksearch_main")
	public WebElement quickSearchTextBox;
	
	// Serach Button
	// Open a new Account ..
	
	// Action
	public void search(String str){
		// Implementaion
	}
	
	// Navigation
	public PageBase navigateToLoginPage(){
		LoginPageClass loginPage = new LoginPageClass(driver);
		fileABuglink.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButotn));
		return loginPage;
	}	

}
