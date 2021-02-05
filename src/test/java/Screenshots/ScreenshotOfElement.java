package Screenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class ScreenshotOfElement extends TestBaseClass
{
	@Test
	public void spice() throws IOException
	{
		driver.get("https://www.spicejet.com/");
		//***Screenshot of the Element****
		
		WebElement e=driver.findElement(By.className("search-buttons-heading"));
		
		//Create a new Folder
		Date d= new Date();
		String ScreenshotFolder="/home/anu/Workspace_IntelliJ/TestNG/Screenshots/"+d.toString().replace(":", "")+"/";
		File f = new File(ScreenshotFolder);
		f.mkdirs();
		
		//Take the screenshot
		File src = e.getScreenshotAs(OutputType.FILE);
		//Copy it in location
		FileUtils.copyFile(src, new File(ScreenshotFolder+"spice1.png"));

	}

}
