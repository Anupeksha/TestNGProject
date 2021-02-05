package DataDrivenApproach;


import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;
import Utils.TestUtil;


public class AmityUniversity extends TestBaseClass
{
	
	@Test(dataProvider = "getData")
	public void register(String Name,String email,String contact,String state, String city,String program) throws InterruptedException
	{
		driver.navigate().to(prop.getProperty("Form_url"));
		System.out.print(Name+"\t"+email+"\t"+contact+"\t"+state+"\t"+city+"\t");
		driver.findElement(By.xpath(prop.getProperty("name_id"))).sendKeys(Name);
		driver.findElement(By.xpath(prop.getProperty("emailAdd_id"))).sendKeys(email);
		driver.findElement(By.xpath(prop.getProperty("contact_id"))).sendKeys(contact);
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop.getProperty("contact_id")))));
		String st="document.getElementById('"+prop.getProperty("state_id")+"').setAttribute('value', '"+state+"')";
		js.executeScript(st);
		String ct="document.getElementById('"+prop.getProperty("city_id")+"').setAttribute('value', '"+city+"')";
		js.executeScript(ct);
		String prgm="document.getElementById('"+prop.getProperty("program_id")+"').setAttribute('value', '"+program+"')";
		js.executeScript(prgm);
		Thread.sleep(3000);
	}

	@Test(enabled = false)
	public void register2() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(prop.getProperty("Form_url"));
		//System.out.print(Name+"\t"+email+"\t"+contact+"\t"+state+"\t"+city+"\t");
		driver.findElement(By.xpath(prop.getProperty("name_id"))).sendKeys("Anupeksha");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("emailAdd_id"))).sendKeys("xyz@xya.com");
		driver.findElement(By.xpath(prop.getProperty("contact_id"))).sendKeys("9989397490");


		js.executeScript("document.getElementById('ddlstate').setAttribute('value', 'Karnataka')");
		js.executeScript("document.getElementById('txtcity').setAttribute('value', 'Bangalore')");
		js.executeScript("document.getElementById('txtprogram').setAttribute('value', 'POST GRADUATE DIPLOMA IN LOGISTICS AND SUPPLY CHAIN MANAGEMENT')");
		//Thread.sleep(3000);
		//WebElement e=driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/div[contains(text(),'Karnataka')]"));
		//		WebDriverWait wait=new WebDriverWait(driver, 20);
		//		wait.until(ExpectedConditions.visibilityOf(e));
		//js.executeScript("window.scrollBy(0,6)");		
		//		String xpath="//ul[@id='ui-id-1']/li/div[contains(text(),'Karnataka')]";
		//		String javascript="document.evaluate('//ul[@id='ui-id-1']/li/div[contains(text(),'Karnataka')]',document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue;)"; 
		//		WebDriverWait wait=new WebDriverWait(driver, 20);
		//		wait.until(ExpectedConditions.visibilityOf(e));
		//		WebElement element = (WebElement) js.executeScript(javascript); 
		//		element.click();
		//		js.executeScript("arguments[0].click();", e);


		//		Actions act=new Actions(driver);
		//		act.moveByOffset(0, 15).build().perform();
		//		act.click().build().perform();
		Thread.sleep(3000);
		//driver.findElement(By.xpath(prop.getProperty("city_id"))).sendKeys(city);
		//driver.findElement(By.xpath(prop.getProperty("program_id"))).sendKeys(program);
	}

	@DataProvider
	public Iterator<Object[]> getData()
	{
		ArrayList<Object[]> myData = TestUtil.getDataFromExcel("/home/anu/Workspace IntelliJ/TestNG/src/test/java/TestDataxls/TestData.xlsx", "Amity");
		return myData.iterator();

	}

}
