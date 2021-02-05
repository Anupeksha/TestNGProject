package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		System.out.println("___________________");
		System.out.println("On Test Start");		
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("On Test Success");		
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println("On Test Failure");		
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("On Test Skipped");		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		System.out.println("On Test Failed with Timeout");		
	}
	
	public void onTestFinish(ITestResult result)
	{
		System.out.println("Finish");
		System.out.println("___________________");
	}

	

}
