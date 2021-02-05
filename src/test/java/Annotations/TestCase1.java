package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1
{
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before Method");
	}

	@BeforeTest
	public void beforetest()
	{
		System.out.println("Before Test");
	}

	@Test
	public void testCase1()
	{
		System.out.println("Test Case1");
	}

	@Test
	public void testCase2()
	{
		System.out.println("Test Case2");
	}

	
	@AfterClass
	public void Afterclass()
	{
		System.out.println("After Class");
	}

	@AfterMethod
	public void Aftermethod()
	{
		System.out.println("After Method");
	}

	@AfterTest
	public void Aftertest()
	{
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite");
	}

}
