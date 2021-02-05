package Popups;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class BrowserPopup  extends TestBaseClass
{
	@Test
	public void qtpSelenium() throws InterruptedException
	{
		driver.get("http://naukri.com");		
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Size: "+windows.size());
		Iterator<String> itr = windows.iterator();
		String MainWindow = itr.next();
		System.out.println(MainWindow);
		System.out.println(driver.getTitle());
		while(itr.hasNext())
		{
			String s = itr.next();
			System.out.println(s);
			driver.switchTo().window(s);
			System.out.println(driver.getTitle());
			driver.close();
			Thread.sleep(3000);
		}
	}

}
