package Locators;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class Linktext  extends TestBaseClass
{
	
	@Test
	public void amazon() throws InterruptedException
	{
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.linkText("Today's Deals")).click();	;
		String Pname="Beauty";
		driver.findElement(By.partialLinkText(Pname));
		Thread.sleep(3000);
	}
	

}
