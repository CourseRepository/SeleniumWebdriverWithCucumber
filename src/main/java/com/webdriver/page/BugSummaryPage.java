package com.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BugSummaryPage extends PageBase {
	
	public BugSummaryPage(WebDriver driver) {
		super(driver);
	}

	private WebDriver driver;
	
	@FindBy(how = How.ID,using = "commit")
	public WebElement saveChanges;
	@FindBy(how=How.ID,using= "comment")
	public WebElement additionalcomments;
	@FindBy(how=How.ID,using = "bug_status")
	public WebElement bugstatus;
	
	
}
