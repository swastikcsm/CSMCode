package Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener extends Annotation.BrowserFactory implements ITestListener {

	static ExtentReports report;
	ExtentTest logger;

	public void onTestStart(ITestResult result) {

		logger = report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(logger);

	}

	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.PASS,
				"Testcase: " + result.getMethod().getMethodName() + " is Passed.");
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailure(ITestResult result) {

		ExtentFactory.getInstance().getExtent().log(Status.FAIL,
				"Testcase: " + result.getMethod().getMethodName() + " is Failed.");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());

		//File src = ((TakesScreenshot) BrowserFactoryNew.StartApplication()).getScreenshotAs(OutputType.FILE);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String SSPath = System.getProperty("user.dir") + "/Screenshots/" + actualDate + ".png";

		File dest = new File(SSPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			System.out.println("Unable to capture screenshot" + e.getMessage());
			e.printStackTrace();
		}
		ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(SSPath, "Failed Testcase Screenshot");
		ExtentFactory.getInstance().removeExtentObject();

	}

	public void onTestSkipped(ITestResult result) {

		ExtentFactory.getInstance().getExtent().log(Status.SKIP,
				"Testcase: " + result.getMethod().getMethodName() + " is Skipped.");
		ExtentFactory.getInstance().removeExtentObject();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		try {
			report = ExtentReportNG.setupExtentReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onFinish(ITestContext context) {
		// close extent
		report.flush();

	}

}