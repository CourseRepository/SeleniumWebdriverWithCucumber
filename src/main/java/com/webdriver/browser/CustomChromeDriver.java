package com.webdriver.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.webdriver.utils.ResourceUtils;

public class CustomChromeDriver {
	
	private void setDriverExecutable(){
		String chromePath = ResourceUtils.getResourcePath("chromedriver.exe");
		/*System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rathr1\\Downloads\\chromedriver_win32\\chromedriver.exe");*/
		System.setProperty("webdriver.chrome.driver",
				chromePath);
	}
	
	private ChromeOptions getChromeOptions(){
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		// headless
		// command line arg
		// binary location
		// Extension
		return options;
		
	}
	
	public WebDriver getChromeDriver(){
		setDriverExecutable();
		ChromeOptions options = getChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}

}
