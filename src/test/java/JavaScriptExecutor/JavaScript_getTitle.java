package JavaScriptExecutor;

import java.awt.image.TileObserver;
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


public class JavaScript_getTitle extends TestBaseClass

{
	@Test
	public void freecrm() throws InterruptedException, IOException
	{
		driver.get("https://ui.freecrm.com");

		//By usind Javascript
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		System.out.println(pageText);
	}

}
