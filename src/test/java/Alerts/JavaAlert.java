package Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class JavaAlert extends TestBaseClass
{
	@Test
	public void rediff() throws InterruptedException
	{
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		Thread.sleep(3000);
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}
}
