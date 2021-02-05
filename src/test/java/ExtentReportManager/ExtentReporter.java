package ExtentReportManager;

import java.io.File;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter 
{
	static ExtentReports reports;

	public static ExtentReports getReports()
	{
		if(reports==null)
		{
			reports = new ExtentReports();
			//Initialize the Report Folder

			Date d = new Date();
			String timestamp = d.toString().replaceAll(":", "-");
			String reportsFolder= timestamp+"/Screenshots";

			String ScreenshotFolderpath = System.getProperty("user.dir") + "/Reports/"+reportsFolder;
			String ReportFolderpath= System.getProperty("user.dir") + "/Reports/"+timestamp;
			//		System.out.println(ScreenshotFolderpath);
			File f = new File(ScreenshotFolderpath);
			f.mkdirs();		 //Creates dynamic report folder name with timestamp+Screenshots folder

			ExtentSparkReporter spark = new ExtentSparkReporter(ReportFolderpath);
			spark.config().setReportName("Functional Testing Report");
			spark.config().setDocumentTitle("Integration part-1");
			spark.config().setTheme(Theme.DARK);
			spark.config().setEncoding("UTF-8");

			reports.attachReporter(spark);
		}

		return reports;
	}

}
