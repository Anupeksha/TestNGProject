package JavaScriptExecutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class JavaScript_changecolor

{
	@Test
	public void freecrm() throws InterruptedException, IOException
	{
		WebDriver driver=new FirefoxDriver();
		Properties prop=new Properties();
		JavascriptExecutor js=(JavascriptExecutor) driver;
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
		driver.get("https://ui.freecrm.com");
		driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys(prop.getProperty("Password"));
		WebElement we=driver.findElement(By.name(prop.getProperty("password_name")));
		js.executeScript("arguments[0].style.border='5px solid red'", we);
		WebElement e=driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));

		js.executeScript("arguments[0].style.backgroundColor = 'rgb(0,200,0)'", e);
		Thread.sleep(3000);
		File src = e.getScreenshotAs(OutputType.FILE);
		driver.quit();
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/javascript1.png"));
	}

}
