package JavaScriptExecutor;

import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class Javascript_generateAlert extends TestBaseClass 
{
	@Test
	public void crm() throws InterruptedException
	{
		driver.get("https://ui.freecrm.com");
		String msg="Issue found";
		js.executeScript("alert('"+msg+"')");
		Thread.sleep(4000);
	}

}
