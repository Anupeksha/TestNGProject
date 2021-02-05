package CustomLocators;

import org.testng.annotations.Test;

import TestBase.TestBaseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomCSS extends TestBaseClass 
{
	@Test
	public void Google() throws InterruptedException
	{
		driver.get("https://www.google.com/");
		driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("restaurants near me");
		Thread.sleep(3000);
		List<WebElement> results = driver.findElements(By.cssSelector("ul.erkvQe>li>div>div:nth-child(2)>div>span"));
		String text = "restaurants near me for birthday party";
		for (WebElement webElement : results) 
		{
			//System.out.println(webElement.getText());
			if(webElement.getText().equals(text))
			{
				webElement.click();
				break;
			}
		}
	}

}
