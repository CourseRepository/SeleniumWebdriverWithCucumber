package com.webdriver.utils;

public interface IReader {
	
	/*
	 * 1. Our test req some basic configuration to be present and that can be enforce using interface.
	 * 2. In interface I will define some methods which are must needed for the configuration 
	 * 3. This interface will be implemented by the class which will read the data from properties file.
	 * 4. The class will provide the implementation for the must have methods
	 * 
	 * */
	
	public String getApplicationUrl(); // this will return the application url from properties file
	public String getUserName();
	public String getPassword();
	public int getExplicitWait();
	public String getBrowserType();
	public void setBrowserType();

}
