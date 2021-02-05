package ExplicitWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class ExplicitWaiting extends TestBaseClass
{
	@Test
	public void spice() throws InterruptedException
	{
		driver.get("https://www.spicejet.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement e=driver.findElement(By.className("search-buttons-heading"));
		wait.until(ExpectedConditions.visibilityOf(e));
		Actions act=new Actions(driver);
		act.contextClick(e);
		Thread.sleep(3000);
	}
}

