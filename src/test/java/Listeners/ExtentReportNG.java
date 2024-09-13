package Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {

	static ExtentReports report;

	public static ExtentReports setupExtentReport() throws IOException {

		SimpleDateFormat format= new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		String actualDate=format.format(date);

		String reportPath = System.getProperty("user.dir")+
				"/Reports/BSKYProject_CSM.html";

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

		report = new ExtentReports();
		report.attachReporter(sparkReport);

		//for adding logo
		sparkReport.loadXMLConfig(new File(System.getProperty("user.dir")+"\\logoconfig.xml"));

		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setTheme(Theme.DARK);
		//sparkReport.config().setReportName("Extent Report");

		report.setSystemInfo("Executed on Environment:",System.getProperty("http://192.168.10.46/bsky_tms_testI/#/login"));
		report.setSystemInfo("Executed on Browser:", System.getProperty("chrome"));
		report.setSystemInfo("Executed on OS:", System.getProperty("os.name"));
		report.setSystemInfo("Executed by User:", System.getProperty("user.name"));
		return report;

	}

}
