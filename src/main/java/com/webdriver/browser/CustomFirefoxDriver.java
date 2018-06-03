package com.webdriver.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.webdriver.utils.ResourceUtils;

public class CustomFirefoxDriver implements BrowserConfiguration {
	
	private void setDriverExecutable(){
		String firefoxPath = "";
		
		if(System.getProperty("os.name").contains("Windows")){
			firefoxPath = ResourceUtils.getResourcePath("geckodriver.exe");
		}else{
			// Code for other machine
		}
		 
		/*System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,"C:\\Users\\rathr1\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");*/
		System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,firefoxPath);
	}
	
	private FirefoxOptions getFirefoxOptions(FirefoxProfile profile){
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		options.setAcceptInsecureCerts(true);
		return options;
	}
	
	private FirefoxProfile getFirefoxProfile(){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		return profile;
	}
	
	public WebDriver getFirefoxDriver(){
		FirefoxDriver driver = getNormalFirefoxDriver();
		return driver;
	}

	private FirefoxDriver getNormalFirefoxDriver() {
		setDriverExecutable();
		FirefoxProfile profile = getFirefoxProfile();
		FirefoxOptions options = getFirefoxOptions(profile);
		FirefoxDriver driver = new FirefoxDriver(options);
		return driver;
	}
	
	private WebDriver getGridFirefoxDriver(){
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setAcceptInsecureCerts(true);
		capabilities.setJavascriptEnabled(true);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(getHubUrl(), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return driver;
	}

	@Override
	public WebDriver getBrowserDriver() {
		if(isGridSetup())
			return getGridFirefoxDriver();
		else
			return getFirefoxDriver();
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
