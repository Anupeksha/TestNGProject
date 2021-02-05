package Frames;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class iFrame extends TestBaseClass
{
	@Test(enabled = true)
	public void paytm() throws InterruptedException
	{
		driver.get("http://paytm.com");
		driver.findElement(By.xpath("//div[@class='_3ac-']")).click();
		//		driver.switchTo().frame(0);
		//		Thread.sleep(3000);

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		//Switch to a Frame using previously located webelement
		//driver.switchTo().frame(Webelement)
		for(int i=0;i<frames.size();i++)
		{
			driver.switchTo().frame(i);
			try
			{
				String s= driver.findElement(By.xpath("//div[@class='content']")).getText();
				System.out.println(s);
				break;
			}
			catch(Exception e)
			{
				System.out.println(e);
				driver.switchTo().defaultContent();
			}
		}
	}

	@Test(enabled = false)
	public void toolsqa() throws InterruptedException
	{
		driver.get("http://paytm.com");
		driver.findElement(By.xpath("//div[@class='_3ac-']")).click();
		Thread.sleep(5000);
		//First find the element using any of locator stratedgy
		WebElement iframeElement =driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/qr-code-login/div/div[2]/div"));

		//now use the switch command
		driver.switchTo().frame(iframeElement);
		driver.quit();
	}

}
