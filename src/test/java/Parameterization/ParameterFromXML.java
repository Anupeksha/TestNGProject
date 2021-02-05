package Parameterization;

import org.testng.annotations.Test;

import Utils.XLSReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ParameterFromXML 
{
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	@Parameters("browser")
	public void before(String browser)
	{
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/anu/Selenium Drivers/chromedriver");
			ChromeOptions opt=new ChromeOptions();
			driver=new ChromeDriver(opt);
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Initialize Properties file
		prop=new Properties();
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

	}

	@Test
	@Parameters({"url","username","password"})
	public void login(String url,String username,String password) throws InterruptedException
	{
		driver.get(url);
		driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys(username);
		driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys(password);
		Thread.sleep(3000);
	}

	@AfterMethod
	public void after()
	{
		//driver.close();
		driver.quit();
	}


}
