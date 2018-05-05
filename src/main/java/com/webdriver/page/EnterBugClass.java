package com.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterBugClass extends PageBase {
	
	private WebDriver driver;
	
	public EnterBugClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	// PageBase -> All the common code which will be used by page classes. All the page classes will inherits from the pageBase
	
	/*public By testnglink = By.xpath("//a[text()='Testng']");
	public By testproductlink = By.xpath("//a[text()='TestProduct']");*/
	
	@FindBy(how = How.XPATH,using = "//a[text()='Testng']")
	public WebElement testnglink;
	@FindBy(how = How.XPATH,using = "//a[text()='TestProduct']")
	public WebElement testproductlink;
	
	
	public PageBase clickTestngLink(){
		DetailPageClass detailpage = new DetailPageClass(driver);
		testnglink.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(detailpage.submitbug));
		return detailpage;
	}	
}
