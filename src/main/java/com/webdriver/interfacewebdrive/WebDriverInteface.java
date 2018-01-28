package com.webdriver.interfacewebdrive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInteface {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rathr1\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rathr1\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\rathr1\\Downloads\\MicrosoftWebDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		System.out.println(driver.toString());
		driver = new FirefoxDriver();
		System.out.println(driver.toString());
		driver = new EdgeDriver();
		System.out.println(driver.toString());
	}
}
