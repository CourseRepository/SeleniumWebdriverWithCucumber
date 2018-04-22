package com.webdriver.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;

public class CustomInternetExplorerDriver  {
	
	private void setDriverExecutable(){
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "C:\\Users\\rathr1\\Downloads\\IEDriverServer_x64_3.8.0\\IEDriverServer.exe");
	}
	
	private InternetExplorerOptions getInternetExplorerOption() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.destructivelyEnsureCleanSession(); // Make sure to clean the session before launching the IE
		options.ignoreZoomSettings(); // ignore the zoom setting
		options.introduceFlakinessByIgnoringSecurityDomains(); // ignore the security check
		options.elementScrollTo(ElementScrollBehavior.BOTTOM);
		return options;
	}
	
	public WebDriver getInternetExplorerDriver(){
		setDriverExecutable();
		InternetExplorerOptions options = getInternetExplorerOption();
		InternetExplorerDriver driver = new InternetExplorerDriver(options);
		return driver;
	}

	

}
