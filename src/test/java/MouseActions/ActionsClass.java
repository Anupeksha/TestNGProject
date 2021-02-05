package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class ActionsClass extends TestBaseClass
{
	@Test
	public void spicejet() throws InterruptedException
	{
		driver.get("https://www.spicejet.com/");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		act.click(driver.findElement(By.linkText("Priority Check-in"))).build().perform();
		act.clickAndHold();
		Thread.sleep(2000);
		act.contextClick();
		Thread.sleep(2000);
		act.contextClick(driver.findElement(By.className("spicejet_logo")));
		Thread.sleep(2000);
		act.doubleClick();
		Thread.sleep(2000);
		act.doubleClick(driver.findElement(By.className("spicejet_logo")));
		Thread.sleep(2000);
		
	}

}
