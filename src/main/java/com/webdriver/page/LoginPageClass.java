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

public class LoginPageClass {
	
	private WebDriver driver;
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
/*	public By username = By.id("Bugzilla_login");
	public By password = By.id("Bugzilla_password");
	public By loginButotn = By.id("log_in");*/

	@FindBy(how = How.ID,using = "Bugzilla_login")
	public WebElement username;
	@FindBy(how = How.ID,using = "Bugzilla_password")
	public WebElement password;
	@FindBy(how = How.ID,using = "log_in")
	public WebElement loginButotn;
	// Action 
	// Reset password
	//Serach 
	
	//Navigation
	public EnterBugClass login(String user,String pass){
		EnterBugClass enterBug = new EnterBugClass(driver);
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButotn.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(enterBug.testnglink));
		return enterBug;
	}
	
	private WebDriverWait getWait(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}

}
