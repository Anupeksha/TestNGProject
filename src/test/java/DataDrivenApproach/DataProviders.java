package DataDrivenApproach;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;
import Utils.XLSReader;

public class DataProviders extends TestBaseClass 
{

	@Test(dataProvider = "getData")
	public void login(String username,String password) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys(username);
		driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys(password);
		Thread.sleep(3000);
	}

	@DataProvider
	public Object[][] getData()
	{
		XLSReader xls=new XLSReader("/home/anu/Workspace IntelliJ/TestNG/src/test/java/TestDataxls/TestData.xlsx");
		String testCaseName="LoginTest";
		Object[][] data=new Object[2][2];

		for(int row=2;row<=xls.getRowCount(testCaseName);row++)
		{
			for(int col=1;col<=xls.getColumnCount(testCaseName);col++)
			{
				data[row-2][col-1]=xls.getCellData(testCaseName, row, col);
			}
		}
		return data;

	}

}
