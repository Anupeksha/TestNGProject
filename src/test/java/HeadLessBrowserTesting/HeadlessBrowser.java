package HeadLessBrowserTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessBrowser 
{
	@Test
	public void FreeCRM()
	{
		Properties prop=new Properties();
		try 
		{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Project.properties");
			prop.load(fis);
		} 
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		}
		//		System.setProperty("webdriver.gecko.driver", "/home/anu/Selenium Drivers/geckodriver");
		//HTMLUnitDriver is not available in Selenium 3
		//To use this concept, download HTMLUnitDRiver jars
		//HTMLUnitDriver is not available in Selenium 3
		//To use this concept, download HTMLUnitDRiver jars

		//		WebDriver driver = new HtmlUnitDriver();
		//		driver.manage().window().maximize();
		//		driver.manage().deleteAllCookies();
		//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//
		//		driver.get("https://ui.freecrm.com");
		//		driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys(prop.getProperty("userName"));
		//		driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys(prop.getProperty("Password"));
	}

}
