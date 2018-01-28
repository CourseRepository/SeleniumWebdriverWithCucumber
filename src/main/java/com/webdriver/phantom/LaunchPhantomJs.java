package com.webdriver.phantom;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class LaunchPhantomJs {
	public static void main(String[] args) {
		System.setProperty("phantomjs.binary.path", "C:\\Users\\rathr1\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		PhantomJSDriver driver = new PhantomJSDriver();
		System.out.println(driver.toString());
	}

}
