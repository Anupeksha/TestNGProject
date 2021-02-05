package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class JavaScript_Datapicker extends TestBaseClass
{
	@Test
	public void sakra() throws InterruptedException
	{
		driver.navigate().to("https://www.sakraworldhospital.com/request-appointment.php");
		driver.findElement(By.linkText("Dr. Srikanth Narayanaswamy")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 15);
		Thread.sleep(3000);
		WebElement datepicker=driver.findElement(By.id("req_prefdate1"));
		String dateVal = "08-08-2021";
		js.executeScript("arguments[0].scrollIntoView(true);", datepicker);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", datepicker);
		Thread.sleep(5000);
	}

}
