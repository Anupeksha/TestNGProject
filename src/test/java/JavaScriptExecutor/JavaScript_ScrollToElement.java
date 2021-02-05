package JavaScriptExecutor;

import static org.testng.Assert.expectThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class JavaScript_ScrollToElement extends TestBaseClass
{
	@Test
	public void crm() throws InterruptedException
	{

		
		driver.get("https://www.amazon.in/");
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement e=driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
	
		js.executeScript("arguments[0].scrollIntoView(true);",e);
		Thread.sleep(4000);
	}

}
