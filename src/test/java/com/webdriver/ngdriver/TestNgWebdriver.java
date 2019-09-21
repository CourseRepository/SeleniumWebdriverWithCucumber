package com.webdriver.ngdriver;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.webdriver.utils.ResourceUtils;

public class TestNgWebdriver {
	
	/*
	 * http://www.angularjshub.com/examples/forms/
	 * http://hello-angularjs.appspot.com/addtablerow
	 * */

	@Test
	public void testByModel() throws InterruptedException {

		String chromePath = "";
		if (System.getProperty("os.name").contains("Windows"))
			chromePath = ResourceUtils.getResourcePath("chromedriver.exe");
		else
			chromePath = "/home/vagrant/jenkins_home/chromedriver";

		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_model");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);

		try {
			ngWebDriver.waitForAngularRequestsToFinish();
			driver.switchTo().frame("iframeResult");
			WebElement nameWebelement = driver.findElement(ByAngular.model("name"));
			nameWebelement.clear();
			nameWebelement.sendKeys("Angular Application");
			System.out.println(nameWebelement.getText());
			Thread.sleep(3000);
		} finally {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		}

	}

	@Test
	public void testByNgBinding() throws InterruptedException {

		String chromePath = "";
		if (System.getProperty("os.name").contains("Windows"))
			chromePath = ResourceUtils.getResourcePath("chromedriver.exe");
		else
			chromePath = "/home/vagrant/jenkins_home/chromedriver";

		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_databinding_two-way");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);

		try {
			ngWebDriver.waitForAngularRequestsToFinish();
			driver.switchTo().frame("iframeResult");
			driver.findElement(ByAngular.model("firstname")).clear();
			driver.findElement(ByAngular.model("firstname")).sendKeys("This is two way binding");
			WebElement nameWebelement = driver.findElement(ByAngular.binding("first"));
			System.out.println(nameWebelement.getText());
			Thread.sleep(3000);
		} finally {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		}

	}

	@Test
	public void testByNgBindingExact() throws InterruptedException {

		String chromePath = "";
		if (System.getProperty("os.name").contains("Windows"))
			chromePath = ResourceUtils.getResourcePath("chromedriver.exe");
		else
			chromePath = "/home/vagrant/jenkins_home/chromedriver";

		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_databinding_two-way");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);

		try {
			ngWebDriver.waitForAngularRequestsToFinish();
			driver.switchTo().frame("iframeResult");
			driver.findElement(ByAngular.model("firstname")).clear();
			driver.findElement(ByAngular.model("firstname")).sendKeys("This is two way binding");
			WebElement nameWebelement = driver.findElement(ByAngular.exactBinding("firstname"));
			System.out.println(nameWebelement.getText());
			Thread.sleep(3000);
		} finally {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		}
	}
	
}
