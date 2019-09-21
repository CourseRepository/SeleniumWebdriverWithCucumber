package com.webdriver.ngdriver;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.webdriver.utils.ResourceUtils;

public class TestNgCommonBase {
	
	protected WebDriver driver;
	protected NgWebDriver ngWebDriver;

	@Before
	public void setUp() throws Exception {
		String chromePath = "";
		if (System.getProperty("os.name").contains("Windows"))
			chromePath = ResourceUtils.getResourcePath("chromedriver.exe");
		else
			chromePath = "/home/vagrant/jenkins_home/chromedriver";

		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
	}

	@After
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}


}
