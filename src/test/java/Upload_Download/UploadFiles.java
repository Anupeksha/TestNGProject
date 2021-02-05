package Upload_Download;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class UploadFiles extends TestBaseClass
{
	@Test
	public void upload() throws InterruptedException
	{
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.id("fileupload")).sendKeys("/home/anu/Selenium_Learning/JavaBasics/ExceptionHandling.png");
		Thread.sleep(3000);
	}

}
