package com.webdriver.ngdriver;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularModel;

public class TestNgWebdriverRepeat extends TestNgCommonBase {
	
	@Test
	public void testByAngularMode_repeat() throws InterruptedException{
		driver.navigate().to("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_ng-repeat");
		try {
			ngWebDriver.waitForAngularRequestsToFinish();
			driver.switchTo().frame("iframeResult");
			for(int i = 0; i < 4; i++ ){
				WebElement ngWebElement = driver.findElement(ByAngular.repeater("x in records").row(i));
				System.out.println(ngWebElement.getText());
			}
			Thread.sleep(3000);
		} finally {}
	}
	
	@Test
	public void testByAngularModel_repeat_table() throws InterruptedException{
		driver.navigate().to("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_ng-repeat3");
		try {
			ngWebDriver.waitForAngularRequestsToFinish();
			driver.switchTo().frame("iframeResult");
			for(int i = 1; i <=3; i++){
				WebElement ngElement = driver.findElement(ByAngular.exactRepeater("(x, y) in myObj").row(1).column("{{x}}"));
				System.out.println(ngElement.getText());
				ngElement = driver.findElement(ByAngular.exactRepeater("(x, y) in myObj").row(1).column("{{y}}"));
				System.out.println(ngElement.getText());
			}
			Thread.sleep(3000);
		} finally {
		}
	}


}
