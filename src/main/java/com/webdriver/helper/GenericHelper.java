package com.webdriver.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericHelper {
	
	private static GenericHelper genericHelper;
	private static WebDriver wdDriver;
	
	private GenericHelper(WebDriver driver){
		wdDriver = driver;
	}
	
	public static GenericHelper getInstance(WebDriver driver){
		if(genericHelper == null || wdDriver.hashCode() != driver.hashCode())
			genericHelper = new GenericHelper(driver);
		return genericHelper;
	}
	
	public void takeScrenShot(String aDir,String bFileName){
		/*
		 * If dir is present , then save the screen shot in the given dir
		 * Create the dir, take the screen shot and save the screen shot in the dir
		 *  File -> java framework
		 * 
		 * */
		
		File directory = new File(aDir);
		
		if(!directory.exists())
			directory.mkdirs();
		
		File screenshot = ((TakesScreenshot)wdDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(directory.getAbsolutePath() + File.separator + bFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public byte[] takeScrenShot(){
		byte[] screenshot = ((TakesScreenshot)wdDriver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

}
