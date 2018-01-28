package com.webdriver.firefox;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefoxBrowser {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rathr1\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		System.out.println(driver.toString());
		
	}

}
