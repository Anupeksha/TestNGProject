package Groups;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class RegularExpression 
{
	@Test
	public void test1smoke()
	{
		AssertJUnit.assertTrue(8<90);
	}
	
	@Test
	public void test2()
	{
		AssertJUnit.assertFalse(1<2);
	}
	
	@Test
	public void test3smoke() 
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
