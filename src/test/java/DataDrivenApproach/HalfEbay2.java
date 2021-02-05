package DataDrivenApproach;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;
import Utils.TestUtil;
import Utils.XLSReader;

public class HalfEbay2 extends TestBaseClass
{
	@Test(dataProvider = "getData")
	public void register(String firstName,String lastName,String email,String password) throws InterruptedException
	{
		driver.navigate().to(prop.getProperty("ebay_url"));
		driver.findElement(By.id(prop.getProperty("firstName_id"))).sendKeys(firstName);
		driver.findElement(By.id(prop.getProperty("lastName_id"))).sendKeys(lastName);
		driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(email);
		driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(password);
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Iterator<Object[]> getData()
	{
		ArrayList<Object[]> myData = TestUtil.getDataFromExcel("/home/anu/Workspace IntelliJ/TestNG/src/test/java/TestDataxls/TestData.xlsx", "HalfEbay_Registration");
		return myData.iterator();
		
	}

}
