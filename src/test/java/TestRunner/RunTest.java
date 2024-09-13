package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		//features=".//BSKY_Feature/LoginChildHospital.feature",
		//features=".//BSKY_Feature/AddBlockPackage_GOC.feature",
		//features=".//BSKY_Feature/GOCVerify&BlockPackage.feature",
		features=".//BSKY_Feature/BlockPackageWithConditions.feature",
		glue = "StepDefination",
		//tags = "~@skip",
		dryRun = false,
		monochrome = true,
		plugin= {"pretty","html:BSKYProj/BSKY.reports/reports.html"},
		stepNotifications = true
		)

public class RunTest {
}

