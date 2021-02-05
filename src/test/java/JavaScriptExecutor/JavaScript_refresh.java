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

import TestBase.TestBaseClass;


public class JavaScript_refresh extends TestBaseClass

{
	@Test
	public void freecrm() throws InterruptedException, IOException
	{
		driver.get("https://ui.freecrm.com");
		//1.By using selenium
		driver.navigate().refresh();
		//By usind Javascript
		js.executeScript("history.go(0)");
	}

}
