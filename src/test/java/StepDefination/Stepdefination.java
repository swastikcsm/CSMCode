package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Annotation.BrowserFactory;
import BusinessLib.BSKYTestData;
import PageObeject.LoginPage;
import PageObeject.TMS_Hospital_OR;
import Utils.Utility;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.TesseractException;

public class Stepdefination extends Utility implements BSKYTestData{
	public double oldAvalAMont;
	public double dischargAmt;
	public double newAvalAmnt;
	public double blockedAmt;
	public double currentFemaleFund;
	public double useofFemaleFund;
	public double amntForunblock;
	public double blockingAmount;
	public LoginPage loginhos;
	public WebDriver driver;
	public TMS_Hospital_OR TMSHS;
	@Before("@LoginHospital")

	public void LoginHos() throws InterruptedException, TesseractException, Exception { 
		driver=BrowserFactory.setupHos(); 
		//driver= BrowserFactory.setupAuth();
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();  
	}

	@When("User open URL {string}")
	public void user_open_url(String url) throws Exception {
		driver.get(url); 
		driver.manage().window().maximize();
	}

	@When("User enter ID as {string} and Password as {string}")
	public void user_enter_id_as_and_password_as(String userid, String Password) throws Exception {
		loginhos =new LoginPage(driver);
		loginhos.enterHosUserId(userid);
		loginhos.enterHosPassword(Password);
		loginhos.EnterCaptcha(driver);
		Thread.sleep(3000);

	}
	//LoginAsChildHospital
	@Before("@LoginChildHospital")

	public void LoginChildHospital() throws InterruptedException, TesseractException, Exception { 
		driver=BrowserFactory.setupChildHos(); 
		//driver= BrowserFactory.setupAuth();
	}
	//LoginAsThirdHospital
	@Before("@LoginAsThirdHospital")

	public void LoginAsThirdHospital() throws InterruptedException, TesseractException, Exception { 
		driver=BrowserFactory.setupAsThirdHos(); 
		//driver= BrowserFactory.setupAuth();
	}
	//Login As Authority
	@Before("@LoginAsAuthority")
	public void LoginAUth() throws InterruptedException, TesseractException, Exception { 
		//driver=BrowserFactory.setupHos(); 
		driver= BrowserFactory.setupAuth();
	}
	@Given("Authority launch chrome browser")
	public void authority_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	}

	@When("Authority open URL {string}")
	public void authority_open_url(String url) {
		driver.get(url); 
		driver.manage().window().maximize();
	}

	@When("Authority enter ID as {string} and Password as {string}")
	public void authority_enter_id_as_and_password_as(String userid, String Password) throws Exception {
		loginhos =new LoginPage(driver);
		loginhos.enterAuthUserId(userid);
		loginhos.enterAuthPassword(Password);
		loginhos.EnterCaptcha1(driver);
		Thread.sleep(3000);
	}
	@Before("@LoginAsAuthority2")
	public void LoginAUth2() throws InterruptedException, TesseractException, Exception { 
		//driver=BrowserFactory.setupHos(); 
		driver= BrowserFactory.setupAuth2();
	}
	////////////AddBlockpackage///////////////////////////

	//Scenario 1 Verify the response of generate override code.
	@When("user Click on Block package")
	public void user_click_on_block_package() throws Exception {

		TMSHS=new TMS_Hospital_OR(driver);
		Thread.sleep(2000);
		TMSHS.ClickBlockPackageLink();
	}

	@When("user enter data in the search field {string}")
	public void user_enter_data_in_the_search_field(String data) throws Exception {
		TMSHS=new TMS_Hospital_OR(driver);
		Thread.sleep(2000);
		TMSHS.EnterBlockPage_Add_EnterURNNo(data);
	}

	@When("user click on search button")
	public void user_click_on_search_button() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver);
		Thread.sleep(2000);
		TMSHS.ClickSearchButton();
	}

	@When("user select patient name")
	public void user_select_patient_name() throws Exception {
		ScrolltoDown(driver);
		Thread.sleep(2000);
		TMSHS=new TMS_Hospital_OR(driver);
		TMSHS.SelectPatientName();
	}
	@When("user tick on declaration checkbox") 
	public void user_tick_on_declaration_checkbox() throws Exception { 
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.CheckDeclarationCheckbox(); 
		ScrolltoDown(driver);
	}

	@Then("Click on Generate Override Code") 
	public void	click_on_generate_override_code() throws Exception { 
		ScrolltoDown(driver);
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickGenerateOverrideCode(); 
	}

	@Then("Verify the response when click on Generate Override Code") 
	public void verify_the_response_when_click_on_generate_override_code() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.DisplayOfOverrideRequest(); 
		driver.close();
	}
	@When("user choose Package header of Any")
	public void user_choose_package_header_of_any() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.SearchCovidPackageName();
		Thread.sleep(2000);
		TMSHS.ClickOnChoosePackage();
	}

	@When("user Choose Package information of Any")
	public void user_choose_package_information_of_any() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickSelectPackageInfomation();
	}

	//Scenario 2 : Verify the submission of Override Request

	@Then("user enter data in no of days field")
	public void user_enter_data_in_no_of_days_field() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver);
		Thread.sleep(2000); TMSHS.
		EnterNoOfDays(NoOfDaysdata);
	}

	@Then("user enter data in description field")
	public void user_enter_data_in_description_field() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterGOCDescription(DescriptionGOC);
	}

	@Then("user click on SubmitButton")
	public void user_click_on_submit_button() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickGOCSubmitButton(); 
	}

	@Then("Verify the succesful submition of override request")
	public void verify_the_succesful_submition_of_override_request() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyGOCSubmittedMsg();
		driver.close();
	}
	//Approving the GOC
	@When("Auth click on RefferalModule")
	public void auth_click_on_refferal_module() throws Exception {
		System.out.println("NOT WORKING");
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickOnReferral();
	}

	@When("Auth click on FP Override Code")
	public void auth_click_on_fp_override_code() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickOnFPOverrideCode();
	}

	@When("Auth Enter Patient Search data")
	public void auth_enter_patient_search_data() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterSearchPatient(PatientName);
	}

	@When("Auth select patient check box")
	public void auth_select_patient_check_box() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickPatientCheckbox();
		ScrolltoDown(driver);
	}

	@Then("Auth Click on the Approve button")
	public void auth_click_on_the_approve_button() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickApproveBtn();
		TMSHS.ClickApproveBtnYes();
		Thread.sleep(1000);
		driver.close();
	}

	//Scenario 3 :Verify the Auto fetched of Override code
	@Then("Verify the Auto fetched of Override code")
	public void verify_the_auto_fetched_of_override_code() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		ScrolltoDown(driver);
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.getAutofetchOR();
		//	driver.close();
	}

	//////////Add and Delete Package Button/////////////////////////

	@When("user click on Package Header")
	public void user_click_on_package_header() throws Exception {
		ScrolltoDown(driver);
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickOnPackageheader();
	}

	@When("user choose Package header")
	public void user_choose_package_header() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.SearchMRPackageName();
		Thread.sleep(2000);
		TMSHS.ClickOnChoosePackage();
	}

	@When("user click Package details")
	public void user_click_package_details() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickSelectPackageDetails();
	}

	@When("user Choose Package information")
	public void user_choose_package_information() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickSelectPackageInfomation();
	}

	@When("user Select Ward")
	public void user_select_ward() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.SelectWard();
		//ScrolltoDown(driver);
	}

	@Then("user click On Add Package button")
	public void user_click_on_add_package_button() throws Exception {
		ScrolltoDown(driver);
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickAddPackage();
	}

	//Scenario 4 verify add package added successfully
	@Then("user verify add package added successfully")
	public void user_verify_add_package_added_successfully() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.verifyAddpackageaddedsuccessfully();
		//driver.close();
	}

	//Scenario 5 verify add package should not added successfully		


	@Then("user scrolldown till Add Package button") 
	public void user_scrolldown_till_add_package_button() throws InterruptedException {
		//TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(1000);
		ScrolltoDown(driver); 
		Thread.sleep(1000); 
		ScrolltoDown(driver);
		//Thread.sleep(1000); 
		//ScrolltoDown(driver); 
	}


	@Then("user verify add package sould not added successfully")
	public void user_verify_add_package_sould_not_added_successfully() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyAddPacMsg();
		//driver.close();
	}

	//Scenario 6: Verify the delete functionality under package details section.

	@Then("user verify the delete functionality under package details section")
	public void user_verify_the_delete_functionality_under_package_details_section() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyDeleteAddPackage();
	}
	//Vital Parameter Scenarios

	@Then("User scroll downn till Vital Parameter")
	public void user_scroll_downn_till_vital_parameter() throws Exception {
		Thread.sleep(1000);
		ScrolltoDown(driver); 
	}

	@Then("user select parameter")
	public void user_select_parameter() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.SelectParameter();
	}

	@Then("user enter parameter value")
	public void user_enter_parameter_value() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterParameterValue();
	}

	@Then("user click on add more button of vital information")
	public void user_click_on_add_more_button_of_vital_information() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.AddParameterDetails();
	}

	//Scenario 7 Verify the add more functionality of vital information

	@Then("Verify the add more functionality of vital information")
	public void verify_the_add_more_functionality_of_vital_information() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyParameterAddedSuccessfully();
	}

	//Scenario 8 Verify the add more functionality of vital information

	@Then("Verify the add more functionality without select vital information details")
	public void verify_the_add_more_functionality_without_select_vital_information_details() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyAddMoreWithoutEnteringParameter();
	}

	@Then("user click on delete button of added vital information")
	public void user_click_on_delete_button_of_added_vital_information() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickDeleteParameterBtn();
	}

	//Scenario 9 Verify the delete functionality under vital information section

	@Then("Verify the delete functionality under vital information section")
	public void verify_the_delete_functionality_under_vital_information_section() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyDeleteParameter();
	}
	//Block Package with "Surgical/Preauth" .

	@Then("user Enter Patient Phone No and wait")
	public void user_enter_patient_phone_no_and_wait() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterPatientPhoneNo();
		Thread.sleep(5000);
		TMSHS.OTPValidation(driver);
	}
	@Then("user enter Blocking Remark")
	public void user_enter_blocking_remark() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterBlockingRemark();
	}
	@Then("user click on the Block button")
	public void user_click_on_the_block_button() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickOnBlock();
		Thread.sleep(2000);
		TMSHS.ClickBlockYes();
	}

	@Then("user close the Block Successfully Alert")
	public void user_close_the_block_successfully_alert() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickBlockCloseBtn();
	}
	//Scenario 38: Block MR package in parent hospital(Patient name A)
	@Then("Verify MR Package Blocked Successfully")
	public void verify_mr_package_blocked_successfully() throws Exception 
	{
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.blockedpackageConfirmation();
		Thread.sleep(2000);
		TMSHS.verifypackageblockedsuccessfully();
	}

	//Scenario 39: Block twice MR package in parent hospital(Patient name A)
	@Then("Verify Proper Alert Messsage should be displayed")
	public void verify_proper_alert_messsage_should_be_displayed() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.AlertWhenMRpackagePatientAblockedTwice();
	}	
	@When("user validate adhaar OTP")
	public void user_validate_adhaar_otp() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.OTPValidationforAadhar(driver);
	}
	//Scenario 40: Block twice MR package in parent hospital(Patient name A)
	@Then("verify Proper Alert Message should be displayed for MR package")
	public void verify_proper_alert_message_should_be_displayed_for_mr_package() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.AlertWhenMRpackageTakenInOtherHos();
	}
	//Scenario 41: Block other package in child hospital(Patient name A) without discharge of patient from parent hospital after block MR package in parent hospital.
	@Then("Verify Other Package should be blocked successfully")
	public void verify_other_package_should_be_blocked_successfully() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.blockedpackageConfirmation();
		Thread.sleep(2000);
		TMSHS.verifypackageblockedsuccessfully();
	}
	//Scenario 42 & 43 : Block package in parent hospital(Patient A) without discharge of patient A from child hospital and
	//Block package in 3rd hospital for patient A without discharge from child hospital

	@Then("Verify proper alert message should be displayed for already admitted patient")
	public void verify_proper_alert_message_should_be_displayed_for_already_admitted_patient() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.AlretWhenAPatientAlreadyBlockedInAnotherHos();
	}

	//Scenario 44: Discharge patient in parent hospital(Patient A) without discharge of patient A from child hospital

	@When("user Click on Discharge Package")
	public void user_click_on_discharge_package() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickDischargePackageLink();
	}

	@Then("Verify Patient A should not display under Discharge Page")
	public void verify_patient_a_should_not_display_under_discharge_page() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.PetientAShouldNotVisibleUnderDischarge();
	}

	//Scenario 47: Verify the card balance after block the package

	@Then("verify the Blocked Amount")
	public void verify_the_blocked_amount() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		blockedAmt=TMSHS.CaptureBlockAmount();
	}

	@Then("Verify the card balance after block the package")
	public void verify_the_card_balance_after_block_the_package() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		System.out.println(oldAvalAMont);
		System.out.println(blockedAmt);
		newAvalAmnt=TMSHS.AvailablecurrentbalanceBeforeBlocking();
		double k=3.5;
		Assert.assertEquals(oldAvalAMont+k, newAvalAmnt, "Values do not match!");
		/*
		 * if(oldAvalAMont-blockedAmt==newAvalAmnt) { System.out.println(newAvalAmnt);
		 * System.out.println("Verify the card balance after block the package=" +
		 * "PASS"); }else { System.out.println(newAvalAmnt);
		 * System.out.println("Verify the card balance after block the package=" +
		 * "FAIL"); }
		 */
	}

	//For unblock package

	@Then("user click on the unblock Package link")
	public void user_click_on_the_unblock_package_link() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickUnblockPackageLink();
	}
	@Then("user search the patient name")
	public void user_search_the_patient_name() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterDataInSearchHere();
	}
	@Then("user click on unblock button against the record")
	public void user_click_on_unblock_button_against_the_record() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickUnblockButtonLink();
	}

	@Then("user select package to unblock")
	public void user_select_package_to_unblock() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickUnblockActionBtn();
		//ScrolltoDown(driver);
	}

	@Then("user enter unblocking remark")
	public void user_enter_unblocking_remark() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterUnblockongRemark();
		ScrolltoDown(driver);
	}

	@Then("user click on the Unblock button")
	public void user_click_on_the_unblock_button() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickOnUnblockButton();
	}

	@When("user Click on Block package from view page")
	public void user_click_on_block_package_from_view_page() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		//TMSHS.ClickOnBlockpackagelinkfromviewpag();

		// Find the loading image element
		WebElement loadingImage = driver.findElement(By.xpath("/body/div[@id='preloader']/img[1]"));

		// Check if the loading image is displayed
		if (loadingImage.isDisplayed()) {
			// Wait for the loading image to disappear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		}
		// Once the loading image disappears, continue with the next steps
		// For example, you can interact with other elements on the page
		// WebElement element = driver.findElement(By.id("element_id"));
		TMSHS.ClickOnBlockpackagelinkfromviewpag();
	}

	@Then("Verify the current available balance before block the package")
	public void verify_the_current_available_balance_before_block_the_package() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		oldAvalAMont=TMSHS.AvailablecurrentbalanceBeforeBlocking();
	}
	@Then("user scroll up")
	public void user_scroll_up() throws InterruptedException {
		Thread.sleep(2000);
		ScrollToUp(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Explicit Wait Example
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for a maximum of 10 seconds
		try {
			// Wait for an element to be visible
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Block Package')]")));
			// Once the element is visible, perform desired action
			element.click();
		} finally {
			// Quit the WebDriver
			//   driver.quit();
		}

	}
	@Then("user capture the blocked package amount")
	public void user_capture_the_blocked_package_amount() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		//TMSHS.VerifyCurrentBlockedAmount();
		amntForunblock=TMSHS.CaptureBlockedAmountNeedtoUnblock(); 
	}
	@Then("user go to home page")
	public void user_go_to_home_page() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickOnHomepageLink();
	}

	@Then("user Verify the card balance after unblock the package")
	public void user_verify_the_card_balance_after_unblock_the_package() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		newAvalAmnt=TMSHS.AvailablecurrentbalanceBeforeBlocking();
		if (oldAvalAMont+amntForunblock==newAvalAmnt) {
			System.out.println(oldAvalAMont);
			System.out.println(amntForunblock);
			System.out.println(newAvalAmnt);
			System.out.println("user Verify the card balance after unblock the package=" + "PASS");
		}else {
			System.out.println(oldAvalAMont);
			System.out.println(amntForunblock);
			System.out.println(newAvalAmnt);
			System.out.println("user Verify the card balance after unblock the package=" + "FAIL");
		}
	}
	///////////////////////////////////////////////////////////
	@When("user click on the view tab")
	public void user_click_on_the_view_tab() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickViewTabBtn();
	}

	@When("user click on search button on view tab")
	public void user_click_on_search_button_on_view_tab() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickViewSearchBtn();
	}

	@When("user Enter Search data")
	public void user_enter_search_data() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterViewSearchHereText();
	}

	@When("user Click on Patient Slip")
	public void user_click_on_patient_slip() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickPatientSlipLink();
	}

	@Then("user Verify Patient Slip")
	public void user_verify_patient_slip() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyPatientSlip();
	}

	@Then("user Click on Hospital Slip")
	public void user_click_on_hospital_slip() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickHospitalSlipLink();
	}

	@Then("user Verify Hospital Slip")
	public void user_verify_hospital_slip() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyHospitalSlip();
	}

	//////////////For Discharge////////////////////

	@Then("user click on the Discharge Package link")
	public void user_click_on_the_discharge_package_link() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickOnDischargeLink();
	}

	@Then("Click on discharge link against the record")
	public void click_on_discharge_link_against_the_record() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickDischargeActionBtn();
	}

	@Then("user tick on the package check box")
	public void user_tick_on_the_package_check_box() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickPackageCheckBox();
	}

	@Then("user change the claim amount")
	public void user_change_the_claim_amount() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterClaimAMountText();
	}

	@Then("user select Actual Date of Discharge")
	public void user_select_actual_date_of_discharge() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickDischargeDateCalander();
		Thread.sleep(2000);
		TMSHS.SelectDischargeDate();
	}

	@Then("user fetched the claimed amount and capture it")
	public void user_fetched_the_claimed_amount_and_capture_it() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		//TMSHS.CaptureClaimAmount();
		Thread.sleep(1000);
		dischargAmt=TMSHS.CaptureClaimAmount();
	}
	@Then("user select Mortality")
	public void user_select_mortality() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.SelectMortality();
	}

	@Then("user enter Description")
	public void user_enter_description() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterDescription();
	}

	@Then("user select Discharge parameter")
	public void user_select_discharge_parameter() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.SelectDischargevitalParameter();
	}

	@Then("user enter Discharge parameter value")
	public void user_enter_discharge_parameter_value() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterDischargeParameterValue();
	}

	@Then("user click on Discharge add more button of vital information")
	public void user_click_on_discharge_add_more_button_of_vital_information() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickDischargeAddmore();
	}

	@Then("user enter Discharge Remarks")
	public void user_enter_discharge_remarks() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.EnterDischargeRemark();
	}

	@Then("user click on the Discharge button")
	public void user_click_on_the_discharge_button() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ClickDischargeButton();
	}

	@Then("user verify card balance update after refund amount in patient discharge")
	public void user_verify_card_balance_update_after_refund_amount_in_patient_discharge() throws Exception {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		System.out.println("old  val" + oldAvalAMont);
		System.out.println("Claim amount" + dischargAmt);
		newAvalAmnt=TMSHS.AvailablecurrentbalanceBeforeBlocking();
		//double k=3.5;
		Assert.assertEquals(oldAvalAMont, newAvalAmnt, "Values do not match!");

		/*
		 * if (oldAvalAMont+dischargAmt==newAvalAmnt) { System.out.println("new  val" +
		 * newAvalAmnt); System.out.
		 * print("card balance update after refund amount in patient discharge=" +
		 * "PASS"); }else { System.out.println("new  val" + newAvalAmnt); System.out.
		 * println("card balance update after refund amount in patient discharge=" +
		 * "FAIL"); }
		 */
	}

	//////////////////////For Preauth//////////////////////////////////

	@When("user choose Package header of Preauth")
	public void user_choose_package_header_of_preauth() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.ChoosePacForPreauth();
	}

	@When("user Choose Package information of Preauth")
	public void user_choose_package_information_of_preauth() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.PackageInfoForPreauth();
	}

	@Then("user choose Preauth file")
	public void user_choose_preauth_file() {

	}

	@Then("user Enter No.Of.Days")
	public void user_enter_no_of_days() {

	}

	@Then("user click on the Preauth Description")
	public void user_click_on_the_preauth_description() {

	}
	//////////////////For Insufficient Fund////////////

	/////////Use Of Female Funds///////////

	@Then("Verify the Current Female Fund")
	public void verify_the_current_female_fund() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		currentFemaleFund=TMSHS.AvailableFemaleFundBeforeBlocking();
		System.out.println("current FemaleFund= " + currentFemaleFund);
	}
	@Then("user the Capture Blocking Amount during add pac")
	public void user_the_capture_blocking_amount_during_add_pac() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		blockingAmount=TMSHS.CapturingPacBlockingAmount();
		System.out.println("blocking Amount= " + blockingAmount);
	}
	@Then("Verify the Use Of Current Female Fund")
	public void verify_the_use_of_current_female_fund() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		System.out.println("current FemaleFund= " + currentFemaleFund);
		System.out.println("blocking Amount" + blockingAmount);
		useofFemaleFund=TMSHS.AvailableFemaleFundBeforeBlocking();
		System.out.println("useof FemaleFund" + useofFemaleFund);
		//double k=3.5;
		//Assert.assertEquals(oldAvalAMont, newAvalAmnt, "Values do not match!");

		if (currentFemaleFund-useofFemaleFund==blockingAmount) { 
			System.out.print("verify_the_use_of_current_female_fund=" +"PASS"); 
		}else { 
			System.out.println("verify_the_use_of_current_female_fund=" +"FAIL"); 
		}	 
	}
	@When("user select Male patient name")
	public void user_select_male_patient_name() throws InterruptedException {
		ScrolltoDown(driver);
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.SelectAnyMaleElement();
	}

	@Then("user verify Block package for male&Family to check use of female fund")
	public void user_verify_block_package_for_male_family_to_check_use_of_female_fund() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		TMSHS.VerifyUseOFFemleFundByMale();
	}

	@Then("user verify insufficient fund amount for block package")
	public void user_verify_insufficient_fund_amount_for_block_package() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(2000);
		if(currentFemaleFund>blockingAmount) { 
			System.out.print("verify insufficient fund amount for block package=" + "PASS"); 
		}else { 
			System.out.println("verify insufficient fund amount for block package=" + "FAIL"); 
		}		
	}
	
	@Then("user unable to add implant and HED for block package if insufficient amount is there")
	public void user_unable_to_add_implant_and_hed_for_block_package_if_insufficient_amount_is_there() throws InterruptedException {
		TMSHS=new TMS_Hospital_OR(driver); 
		Thread.sleep(1000);
		TMSHS.AddImplant();
		Thread.sleep(1000);
		TMSHS.AddHED();
		Thread.sleep(1000);
		TMSHS.verifyImpantHedAddedSuccessfully();
	}


}


