package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class Javascript_ClickElement extends TestBaseClass 
{
	@Test
	public void crm() throws InterruptedException
	{
		driver.get("https://ui.freecrm.com");

		WebElement e=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));

		js.executeScript("arguments[0].click", e);
		Thread.sleep(4000);
	}

}
