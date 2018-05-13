package com.webdriver.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.page.factory.CustomFactory;
import com.webdriver.page.factory.PageName;

public class PageBase {
	
	private WebDriver driver;
	
	@FindBy(how = How.XPATH,using = "//div[@id='header']/ul[1]/li[11]/a")
	public WebElement logout;
	@FindBy(how = How.XPATH,using = "//a[text()='Home']")
	public WebElement home;
	@FindBy(how = How.XPATH,using = "//a[text()='New']")
	public WebElement newLink;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected WebDriverWait getWait(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
	
	public PageBase logoutFromApplication(){
		logout.click();
		HomePageClass homePage = new HomePageClass(driver);
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.fileABuglink));
		return homePage;
	}
	
	protected PageBase navigateTo(PageName name,WebDriver driver,WebElement element){
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(element));
		return CustomFactory.getInstance(name, driver);
		
	}

}
