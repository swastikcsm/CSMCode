package Annotation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Screenshots extends BrowserFactory
{

	@After
	public void takescreenshotonfailuretestcase(Scenario scenario) throws IOException, Exception
	{
		if (scenario.isFailed())
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
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
		}
		
		Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@alt='user']")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Log Out")).click();
			
		
		
	}
}
	


