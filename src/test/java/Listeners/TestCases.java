package Listeners;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases 
{
	@Test
	public void test1()
	{
		AssertJUnit.assertTrue(8<90);
	}
	
	@Test
	public void test2()
	{
		AssertJUnit.assertFalse(1<2);
	}
	
	@Test
	public void test3() 
	{
		try
		{
			throw new Exception("SkipException");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Test(timeOut = 1000)
	public void test4() throws InterruptedException
	{
		Thread.sleep(2000);
	}
	
	

}
