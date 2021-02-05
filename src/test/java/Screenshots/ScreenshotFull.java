package Screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import TestBase.TestBaseClass;

public class ScreenshotFull extends TestBaseClass
{
	@Test
	public void spice() throws IOException
	{
		driver.get("https://www.spicejet.com/");
		//***Complete Screenshot****
		//Take the screenshot
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy the screenshot to a desired location
		String ScreenshotFolder="/home/anu/Workspace_IntelliJ/TestNG/Screenshots/";
		FileUtils.copyFile(src, new File(ScreenshotFolder+"spice.png"));
		
	}

}
