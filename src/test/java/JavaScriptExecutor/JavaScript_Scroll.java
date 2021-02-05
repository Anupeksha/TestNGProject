package JavaScriptExecutor;

import static org.testng.Assert.expectThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class JavaScript_Scroll extends TestBaseClass
{
	@Test
	public void crm() throws InterruptedException
	{
		driver.get("https://ui.freecrm.com");
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(4000);
		//OR
		js.executeScript("window.scrollTo(0,50)");
	}

}
