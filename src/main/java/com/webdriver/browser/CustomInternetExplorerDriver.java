package com.webdriver.browser;

import static org.openqa.selenium.ie.InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CustomInternetExplorerDriver implements BrowserConfiguration  {
	
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
		InternetExplorerDriver driver = getNormalDriver();
		return driver;
	}
	
	private WebDriver getGridDriver(){
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setAcceptInsecureCerts(true);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(getHubUrl(), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return driver;
	}
	
	private InternetExplorerDriver getNormalDriver() {
		setDriverExecutable();
		InternetExplorerOptions options = getInternetExplorerOption();
		InternetExplorerDriver driver = new InternetExplorerDriver(options);
		return driver;
	}

	@Override
	public WebDriver getBrowserDriver() {
		if(isGridSetup())
			return getGridDriver();
		else
			return getNormalDriver();
	}

	@Override
	public boolean isGridSetup() {
		String property = System.getProperty("IsGridSetup");
		
		if(null == property || property.isEmpty() || "false".equalsIgnoreCase(property))
			return false;
		return true;
	}

	@Override
	public URL getHubUrl() throws MalformedURLException {
		String property = System.getProperty("HubUrl");
		
		if(null == property || property.isEmpty())
			throw new RuntimeException("Invalid Hub url");
		
		return new URL(property);
	}

	

}
