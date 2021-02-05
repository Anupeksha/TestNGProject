package Parameterization;

import org.testng.annotations.Test;

import Utils.XLSReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ParameterFromXLS 
{
	WebDriver driver;
	Properties prop;

	@Test
	public void readingXLS()
	{
		XLSReader xls=new XLSReader("/home/anu/Workspace IntelliJ/TestNG/src/test/java/TestDataxls/TestData.xlsx");
		String sheetname="TestCases";
		System.out.println("Row Count : "+xls.getRowCount(sheetname));
		System.out.println("Column Count : "+xls.getColumnCount(sheetname));
		
		for(int row=1;row<=xls.getRowCount(sheetname);row++)
		{
			for(int col=1;col<=xls.getColumnCount(sheetname);col++)
			{
				System.out.print(xls.getCellData(sheetname, row, col));
				System.out.print("\t\t");
			}
			System.out.println();
		}
	}



}
