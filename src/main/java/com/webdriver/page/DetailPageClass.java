package com.webdriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.helper.DropdownHelper;

public class DetailPageClass extends PageBase {

	private WebDriver driver;

	public DetailPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Use the @Findby annotation with web element
	 * Use PageFactroy.initElement() to initialize the web element
	 * 
	 * 
	 * */
	
	/*public By componenet = By.id("component");
	public By version = By.id("version");
	public By severity = By.id("bug_severity");
	public By hardware = By.id("rep_platform");
	public By os = By.id("op_sys");
	public By summary = By.id("short_desc");
	public By description = By.id("comment");
	public By submitbug = By.id("commit");*/
	
	@FindBy(how = How.ID,using = "component")
	public WebElement componenet;
	@FindBy(how = How.ID,using = "version")
	public WebElement version;
	@FindBy(how = How.ID,using = "bug_severity")
	public WebElement severity;
	@FindBy(how = How.ID,using = "rep_platform")
	public WebElement hardware;
	
	@FindBy(how = How.ID,using = "op_sys")
	public WebElement os;
	@FindBy(how = How.ID,using = "short_desc")
	public WebElement summary;
	@FindBy(how = How.ID,using = "comment")
	public WebElement description;
	@FindBy(how = How.ID,using = "commit")
	public WebElement submitbug;
	
	
	// Actions
	
	public void provideDetails(String comp,String ver,String sever,String hard){
		DropdownHelper helper = DropdownHelper.getInstance(driver);
		helper.selectByValue(componenet, comp);
		helper.selectByValue(version, ver);
		helper.selectByValue(severity, sever);
		helper.selectByValue(hardware, hard);
	}
	
	public void provideOtherDetails(String operatingsys,String shortSummary,String comment){
		DropdownHelper helper = DropdownHelper.getInstance(driver);
		helper.selectByValue(os, operatingsys);
		summary.sendKeys(shortSummary);
		description.sendKeys(comment);
	}
	
	public PageBase clickSubmitBugButton(){
		BugSummaryPage summaryPage = new BugSummaryPage(driver);
		submitbug.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(summaryPage.saveChanges));
		return summaryPage;
	}

}
