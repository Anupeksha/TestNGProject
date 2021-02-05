package TestNGFeatures;

import org.testng.annotations.Test;

public class FeaturesOfTestNG 
{
	@Test
	public void testcase1()
	{
		System.out.println("Login Test");
		System.out.println(9/50);
	}
	
	@Test(dependsOnMethods = "testcase1")
	public void testcase2()
	{
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods = "testcase1")
	public void testcase3()
	{
		System.out.println("Contacts Page Test");
	}

	@Test(dependsOnMethods = "testcase1")
	public void testcase4()
	{
		System.out.println("Search Page Test");
	}
}
