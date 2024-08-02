package com.crm.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryNetwork implements IRetryAnalyzer{

	int start=0, end=4;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(start<end)
		{
			start++;
			return true;
		}
		return false;
	}
	

}
