package com.webdriver.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class CustomThreadLocal {
	
	private static ThreadLocal<String> browserType = new ThreadLocal<>();
	
	public static void setValue(String Type) {
		browserType.set(Type);
	}
	
	public static String getValue() {
		return browserType.get();
	}
	
}
