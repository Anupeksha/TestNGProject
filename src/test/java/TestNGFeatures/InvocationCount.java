package TestNGFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class InvocationCount 
{
	@Test(invocationCount = 10) 		//Invocation count is used to run the same test case multiple times
	public void sum()
	{
		int a=89;
		int b=67;
		System.out.println("Sum is : "+(a+b));
		System.out.println("____________________________________");
	}

}
