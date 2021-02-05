package LinkTesting;

import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;


public class CheckingEachLink extends TestBaseClass
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
			Response_Code(webElement.getAttribute("href"));
			System.out.println("***************");
		}
		Thread.sleep(3000);
	}

	public boolean Response_Code(String url)
	{
		int resp_code=0;
		try 
		{
			resp_code=Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
			System.out.println("Response cose for URL "+ url +" is : "+resp_code);
			if(resp_code==200)
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;

	}


}
