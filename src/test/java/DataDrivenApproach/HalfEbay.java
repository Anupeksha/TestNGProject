package DataDrivenApproach;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;
import Utils.XLSReader;

public class HalfEbay extends TestBaseClass
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
	public Object[][] getData()
	{
		XLSReader xls=new XLSReader("/home/anu/Workspace IntelliJ/TestNG/src/test/java/TestDataxls/TestData.xlsx");
		String SheetName="HalfEbay_Registration";
		Object[][] data=new Object[5][4];
		
		for(int row=2;row<=xls.getRowCount(SheetName);row++)
		{
			for(int col=1;col<=xls.getColumnCount(SheetName);col++)
			{
				data[row-2][col-1]=xls.getCellData(SheetName, row, col);
			}
		}
		
		return data;
	}

}
