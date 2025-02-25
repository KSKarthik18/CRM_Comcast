package com.comcast.crm.generic.listener_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_analyser implements IRetryAnalyzer {
	int count=0;
	int limit_count=5;
	@Override
	public boolean retry(ITestResult result) {
		if(count<limit_count) {
			count++;
			return true;
		}
		return false;
	}
}
