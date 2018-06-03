package com.webdriver.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

public interface BrowserConfiguration {
	
	public WebDriver getBrowserDriver();
	public boolean isGridSetup(); // True or false based on grid setup
	public URL getHubUrl() throws MalformedURLException;

}
