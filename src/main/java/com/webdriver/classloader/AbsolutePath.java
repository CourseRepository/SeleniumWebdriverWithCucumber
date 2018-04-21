package com.webdriver.classloader;

import java.net.URL;

public class AbsolutePath {
	
	public static void main(String[] args) {
		/*
		 * 1. Get the class
		 * 2. Using the class get class loader
		 * 3. Using the class loader get the resource path
		 * 
		 * */
		
		Class cls = AbsolutePath.class;
		ClassLoader loader = cls.getClassLoader();
		URL url = loader.getResource("./chromedriver.exe"); // "." current working directory ".." parent dir
		System.out.println(url.toString());
		
	}

}
