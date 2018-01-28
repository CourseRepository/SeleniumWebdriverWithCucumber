package com.webdriver.microrsoft;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchMicrosoftBrowser {
	public static void main(String[] args) {
		/*System.setProperty("webdriver.edge.driver", "C:\\Users\\rathr1\\Downloads\\MicrosoftWebDriver.exe");
		EdgeDriver driver = new EdgeDriver();
		System.out.println(driver.toString());*/
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\rathr1\\Downloads\\IEDriverServer_x64_3.8.0\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		System.out.println(driver.toString());
		
		
		/**
		 * Version
		 * Driver Version
		 * Browser Version
		 * Browser Bit Version
		 * Selenium Version
		 * 
		 */
		
	}

}
