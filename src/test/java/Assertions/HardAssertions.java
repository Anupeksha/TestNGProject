package Assertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertions 
{
	WebDriver driver;

	@BeforeMethod
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "/home/anu/Selenium Drivers/chromedriver");
		ChromeOptions opt=new ChromeOptions();
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com/");
	}

	@Test()
	public void googleTitleTest() throws InterruptedException
	{
		String title=driver.getTitle();
		String expected="Google";
		System.out.println("Title of the Page is : "+title);
		Assert.assertEquals(title, expected);
		//Assert.assertEquals(title, "sdjh","Not a match");
		Assert.assertEquals(title, expected,"Actual doesn't match with Expected");
		Assert.assertNotEquals(title, "unExpected");
		Assert.assertNotNull(title);
		Assert.assertTrue(title.equals(expected), "Actual doesn't match with Expected");
		Assert.assertFalse(title.equals("UTH"), "Correct");
	
	}

	@AfterMethod
	public void after()
	{
		//driver.close();
		driver.quit();
	}
}


