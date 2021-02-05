package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseClass 
{

	public WebDriver driver;
	public Properties prop;
	public JavascriptExecutor js;

	@BeforeMethod
	public void before()
	{
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

		if(prop.getProperty("browser").equals("Chrome"))
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
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
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
		
		js=(JavascriptExecutor) driver;

	}

	@AfterMethod
	public void after()
	{
		//driver.close();
		driver.quit();
	}

}
