package com.crm.listner;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import BaseDWS.DWSBaseListener;
import baseClass.BaseClass_DWS;

public class Basic extends DWSBaseListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String name = result.getMethod().getMethodName();
		Reporter.log("onTestStart"+" "+name,true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		Reporter.log("onTestSuccess",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Reporter.log("onTestFailure",true);
		LocalDate date = LocalDate.now();
		String dateTime = date.toString().replace(":", "-");
		TakesScreenshot ts= (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE) ;
		File dest= new File("./Screenshot/fail"+""+dateTime+""+".jpg");
		try {
			FileHandler.copy(file,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("onTestSkipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("onTestFailedButWithinSuccessPercentage",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("onTestFailedWithTimeout",true);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("onStart",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("onFinish",true);
	}
	

}
