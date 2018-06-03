package com.webdriver.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.webdriver.utils.ResourceUtils;

public class CustomChromeDriver implements BrowserConfiguration{
	
	private void setDriverExecutable(){
		String	chromePath = "";
		if(System.getProperty("os.name").contains("Windows"))
			chromePath = ResourceUtils.getResourcePath("chromedriver.exe");
		else
			chromePath = "/home/vagrant/jenkins_home/chromedriver";
		
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
		ChromeDriver driver = getNormalDriver();
		return driver;
	}

	private ChromeDriver getNormalDriver() {
		setDriverExecutable();
		ChromeOptions options = getChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}
	
	private WebDriver getGridDriver(){
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
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
			return getGridDriver();
		else
			return getChromeDriver();
	}

	@Override // This method will tell whether we have grid setup or not
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
