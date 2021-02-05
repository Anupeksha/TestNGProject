package FindElementsConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class FindElemnt extends TestBaseClass
{
	@Test
	public void google() throws InterruptedException
	{
	driver.get("https://www.google.com/");
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("size = "+links.size());
	for (WebElement webElement : links) 
	{
		System.out.println(webElement.getText());		
	}
	Thread.sleep(3000);
	}
	

}
