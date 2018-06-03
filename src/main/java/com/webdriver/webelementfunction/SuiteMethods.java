package com.webdriver.webelementfunction;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SuiteMethods implements ISuiteListener,ITestListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("OnStart");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
