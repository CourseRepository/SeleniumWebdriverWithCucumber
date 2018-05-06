package com.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BugSummary extends PageBase {
	
	public BugSummary(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private WebDriver driver;
	
	
	@FindBy(how = How.ID,using = "comment")
	public WebElement addtionalcomment;
	@FindBy(how = How.ID,using = "commit")
	public WebElement savechanges;
	@FindBy(how = How.ID,using = "bug_status")
	public WebElement bugstatus;

}
