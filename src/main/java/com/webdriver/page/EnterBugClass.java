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

public class EnterBugClass {
	
	private WebDriver driver;
	
	public EnterBugClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public By testnglink = By.xpath("//a[text()='Testng']");
	public By testproductlink = By.xpath("//a[text()='TestProduct']");*/
	
	@FindBy(how = How.XPATH,using = "//a[text()='Testng']")
	public WebElement testnglink;
	@FindBy(how = How.XPATH,using = "//a[text()='TestProduct']")
	public WebElement testproductlink;
	
	
	public DetailPageClass clickTestngLink(){
		DetailPageClass detailpage = new DetailPageClass(driver);
		testnglink.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(detailpage.submitbug));
		return detailpage;
	}
	
	private WebDriverWait getWait(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
}
