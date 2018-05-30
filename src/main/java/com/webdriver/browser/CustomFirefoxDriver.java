package com.webdriver.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;

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
		setDriverExecutable();
		FirefoxProfile profile = getFirefoxProfile();
		FirefoxOptions options = getFirefoxOptions(profile);
		FirefoxDriver driver = new FirefoxDriver(options);
		return driver;
	}

	@Override
	public WebDriver getBrowserDriver() {
		return getFirefoxDriver();
	}

}
