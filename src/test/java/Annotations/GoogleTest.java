package Annotations;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest
{
	WebDriver driver;
	@BeforeMethod
	public void before()
	{
		//		WebDriverManager.chromedriver().browserVersion("86.0.4240.198").setup();
		//		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		//		System.setProperty("webdriver.chrome.driver", "/home/anu/Selenium Drivers/chromedriver");
		//		ChromeOptions opt=new ChromeOptions();
		//		opt.setBinary("/home/anu/Selenium Drivers/chromedriver");
		//		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com/");
	}

	@Test(priority = 1,groups = "Smoke")
	public void googleTitleTest() throws InterruptedException
	{
		String title=driver.getTitle();
		System.out.println("Title of the Page is : "+title);
	}

	@Test(priority = 2,groups = "Reg")
	public void googleLogoTest()
	{
		boolean logoPresent=driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		if(logoPresent)
		{
			System.out.println("Logo is Present");
		}
		else
		{
			System.out.println("Logo not found");
		}
	}

	@Test(priority = 3,groups = "Reg")
	public void gmailLinkTest()
	{
		boolean b=driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).isDisplayed();
		if(b)
		{
			System.out.println("Gmail Link is present");
		}
	}

	@Test(priority = 4,groups = "search")
	public void searchTest()
	{
		System.out.println("Searching for a keyword");
	}

	@Test(priority = 5,groups = "search")
	public void browserSearchResults()
	{
		System.out.println("Browsing search Results");
	}

	@AfterMethod
	public void after()
	{
		//driver.close();
		driver.quit();
	}
}
