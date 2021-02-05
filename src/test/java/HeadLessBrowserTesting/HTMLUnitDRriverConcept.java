package HeadLessBrowserTesting;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class HTMLUnitDRriverConcept extends TestBaseClass
{
	@Test(enabled = false)
	public void freecrmWithoutHTML()
	{
		driver.navigate().to("https://ui.freecrm.com");
		driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys(prop.getProperty("Password"));
	}

}
