package TestNGFeatures;

import org.testng.annotations.Test;

public class ExceptionTimeOut 
{

	@Test(timeOut =  2000,expectedExceptions = NumberFormatException.class,enabled = false)
	public void infiniteLoopTest()
	{
		int i=1;
		while(i==1)
		{
			System.out.println(i);
		}
	}

	@Test(timeOut =  2000,expectedExceptions = NumberFormatException.class)
	public void expectedExceptionTest()
	{
		String s="100i";
		System.out.println(Integer.parseInt(s));
		System.out.println("Ended");
		System.out.println("ahdsahsd");
	}

}
