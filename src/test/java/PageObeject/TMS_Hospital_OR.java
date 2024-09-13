package PageObeject;

import java.time.Duration;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BusinessLib.BSKYTestData;
import Utils.Utility;

public class TMS_Hospital_OR extends Utility implements BSKYTestData{
	// private double CAmountBeforeBlock;
	//private  double CAmountafterblock ;
	//private  double BAmount ;
	//private double CBAmount;
	private double AvailablecurrentbalanceBeforeBlocking;
	private double CaptureClaimAmount;
	//Declaration of object by locators
	@FindBy(xpath ="//p[contains(text(),'Blocking of package against patient URN.')]" )
	protected	WebElement BlockPackageLink;
	@FindBy(xpath = "//input[@id='txtSearch']" )
	protected	WebElement BlockPage_Add_EnterURNNo;
	@FindBy(xpath = "//input[@id='btnSearch']")
	protected WebElement SearchButton;
	@FindBy(xpath = "//button[@id='selectFamily2']")
	protected	 WebElement SelectPatient;
	@FindBy(xpath = "//input[@id='verificationAuthCheckbox']")
	protected	 WebElement CheckDeclaration;
	@FindBy(xpath="//input[@id='generateOverride']")
	protected	 WebElement GenerateOverrideCode;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	protected	 WebElement CloseOverrideCodePopup;
	@FindBy(xpath ="//input[@id='ocNoOfDays']")
	protected	 WebElement NoOfDays;
	@FindBy(xpath="//INPUT[@id=\"ocNoOfDays\"]")
	protected	 WebElement UploadFile;
	@FindBy(xpath="//textarea[@id='ocDescription']")
	protected	 WebElement GOCDescription;
	@FindBy(xpath ="//button[@id='btnSubmit']")
	protected	 WebElement GOCSubmitButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	protected	 WebElement GOCAlertOk;
	@FindBy(xpath="//input[@id='txtPackageHeader']/following-sibling::*")
	protected	 WebElement SelectPackageheader;
	@FindBy(xpath="//DIV[contains(@class,'modal-dialog modal-lg modal-dialog-scrollable')]/descendant::INPUT[@placeholder='Search Here']")
	protected	 WebElement SearchPackage;
	@FindBy(xpath="//TABLE[@id='tblPackageHeader']/descendant::BUTTON[contains(.,'Select')]")
	protected	 WebElement ChooseSearchedPackage;
	@FindBy(xpath="//input[@id='txtPackageDetails']/following-sibling::*")
	protected	 WebElement SelectPackageDetails;
	@FindBy(xpath="//tbody/tr[5]/td[10]/input[1]")
	protected	 WebElement SelectPackageInfomation;
	@FindBy(xpath="//select[@id='wardDetails']")
	protected	 WebElement SelectWard;
	@FindBy(xpath="//input[@id='btnAddPackage']")
	protected	 WebElement ClickAddPackage;
	@FindBy(id="dtActualAdmission")
	protected	 WebElement AddmissionDateCalendar;
	@FindBy(id="txtDoctorName")
	protected	 WebElement EnterDoctorName;
	@FindBy(id="txtDrPhoneNo")
	protected	 WebElement EnterDoctorPhoneNo;
	@FindBy(xpath="//input[@id='ddPatientPhone']")
	protected	 WebElement EnterPatientPhoneNo;
	@FindBy(xpath="//select[@id='vitalParameter']")
	protected	 WebElement SelectParameter;
	@FindBy(xpath="//input[@id='txtVitalsValue']")
	protected	 WebElement EnterParameterValue;
	@FindBy(xpath="//BUTTON[normalize-space(.)='Add']")
	protected	 WebElement AddParameterDetails;
	@FindBy(xpath="//tbody/tr[1]/td[4]/a[1]/i[1]")
	protected	 WebElement DeleteParameterDetails;
	@FindBy(xpath="//input[@id='ocPatientPhoto']")	
	protected	 WebElement UploadPatientPhoto;
	@FindBy(xpath="//body/app-root[1]/app-block-package[1]/app-website-inner-layout[1]/section[1]/div[1]/div[4]/div[6]/div[1]/textarea[1]")
	protected	 WebElement EnterBlockingRemark;
	@FindBy(xpath="//INPUT[@value=\"Block\"]")
	protected	 WebElement ClickBlock;
	@FindBy(xpath="//button[contains(text(),'Yes, Confirm!')]")
	protected	 WebElement ClickBlockYes;
	@FindBy(xpath="//BUTTON[.='Close']")
	protected	 WebElement BlockCloseBtn;
	@FindBy(xpath="//BUTTON[normalize-space(.)='View Slip']")
	protected	 WebElement ViewSlip;
	@FindBy(xpath="//p[contains(text(),'Discharge patient through URN.')]")
	protected	 WebElement DischargePackage;
	@FindBy(xpath="//p[contains(text(),'Unblocking of package against patient URN.')]")
	protected	 WebElement UnblockPackageLink;
	@FindBy(xpath="//div[contains(text(),'Unblock Package')]")
	protected	 WebElement UnblockPackageLinkFromView;
	@FindBy(xpath="//INPUT[contains(@placeholder,'Search Here')]")
	protected	 WebElement SearchForUnblockPackage;
	@FindBy(xpath="//button[contains(text(),'Unblock')]")
	protected	 WebElement UnblockButtonLink;
	@FindBy(xpath="//button[@id='unblock1']")
	protected	 WebElement UnblockActionBtn;
	@FindBy(xpath="//textarea[@id='remark']")
	protected	 WebElement UnblockongRemark;
	@FindBy(xpath="//input[@value='Un-Block']")
	protected	 WebElement UnblockButton;
	@FindBy(xpath="//a[contains(text(),'View')]")
	protected	 WebElement ViewTabBtn;
	@FindBy(xpath="//input[@id='btnSearch']")
	protected	 WebElement ViewSearchBtn;
	@FindBy(xpath="//input[@placeholder='Search Here']")
	protected	 WebElement ViewSearchHereText;
	@FindBy(xpath="//TBODY[contains(.,'Gayatri Rath') and contains(.,'| Female') and contains(.,'CASE/') and contains(.,'/') and contains(.,'-Mar-')]/TR[1]/TD[8]/A/I")
	protected	 WebElement HospitalSlip;
	@FindBy(xpath="//TBODY[contains(.,'Gayatri Rath') and contains(.,'| Female') and contains(.,'CASE/') and contains(.,'/') and contains(.,'-Mar-')]/TR[1]/TD[8]/BUTTON[1]")
	protected	 WebElement PatientSlip;

	///////For Discharge/////////

	@FindBy(xpath="//h5[contains(text(),'Discharge')]")
	protected	 WebElement DischargeLink;
	@FindBy(xpath="//td[contains(text(),'7008956426')]/following-sibling::td/button")
	protected	 WebElement DischargeActionBtn;
	@FindBy(xpath="//input[@id='blockPackageId0']")
	protected	 WebElement PackageCheckBox;
	@FindBy(xpath="//input[@id='claimAmout0']")
	protected	 WebElement ClaimAMountText;
	@FindBy(xpath="//input[@id='txtDischargedate']")
	protected	 WebElement DischargeDateCalander;
	@FindBy(xpath="//A[contains(@class,'ui-state-default ui-state-highlight ui-state-hover')]")
	protected	 WebElement DischargeDate;
	@FindBy(xpath="//input[@id='claimAmountId']")
	protected	 WebElement ClaimAmountDisabledField;
	@FindBy(xpath="//select[@id='mortalityId']")
	protected	 WebElement Mortality;
	@FindBy(xpath="//textarea[@id='dischargeDetails']")
	protected	 WebElement Description;
	@FindBy(xpath="//select[@id='vitalParameterId']")
	protected	 WebElement DischargevitalParameter;
	@FindBy(xpath="//input[@id='vitalParameterValue']")
	protected	 WebElement DischargeParameterValue;
	@FindBy(xpath="//BUTTON[contains(.,'Add More')]")
	protected	 WebElement DischargeAddmore;
	@FindBy(xpath="//textarea[@id='dischargeRemarks']")
	protected	 WebElement DischargeRemark;
	@FindBy(xpath="//INPUT[@value='Discharge']")
	protected	 WebElement DischargeButton;

	//Initialization of object through constructor

	WebDriver driver;
	public TMS_Hospital_OR(WebDriver Driver)
	{
		this.driver=Driver;
		PageFactory.initElements(Driver, this);
	}
	//Unblock package initialization
	public void ClickUnblockPackageLink() throws Exception {
		UnblockPackageLink.click();
		Thread.sleep(2000);	
	}
	public void EnterDataInSearchHere() throws Exception {
		SearchForUnblockPackage.sendKeys(SearchPatient);
		Thread.sleep(2000);	
	}
	public void ClickUnblockButtonLink() throws Exception {
		UnblockButtonLink.click();
		Thread.sleep(2000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", UnblockActionBtn);
	}
	public void ClickUnblockActionBtn() throws Exception {
		UnblockActionBtn.click();
		Thread.sleep(2000);	
	}
	public void EnterUnblockongRemark() throws Exception {
		UnblockongRemark.sendKeys(Unblockingremarks);
		Thread.sleep(2000);	
	}
	public void ClickOnUnblockButton() throws Exception {
		UnblockButton.click();
		Thread.sleep(1000);	
		YesConfirmBlock.click();
		Thread.sleep(1000);	
	}

	@FindBy(xpath="//div[contains(text(),'Block Package')]")
	protected	 WebElement Blockpackagelinkfromviewpage;
	public void ClickOnBlockpackagelinkfromviewpag() throws Exception {
		Blockpackagelinkfromviewpage.click();
		Thread.sleep(2000);	
	}
	//Initialization of Discharge object through constructor

	public void ClickOnDischargeLink() throws Exception {
		DischargeLink.click();
		Thread.sleep(2000);	
	}
	public void ClickDischargeActionBtn() throws Exception {
		DischargeActionBtn.click();
		Thread.sleep(2000);	
	}
	public void ClickPackageCheckBox() throws Exception {
		PackageCheckBox.click();
		Thread.sleep(2000);	
	}
	public void EnterClaimAMountText() throws Exception {
		ClaimAMountText.clear();
		Thread.sleep(1000);	
		ClaimAMountText.sendKeys(claimAMountvalue);
		Thread.sleep(2000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", Description);
	}
	public void ClickDischargeDateCalander() throws Exception {
		DischargeDateCalander.click();
		Thread.sleep(2000);	
	}
	public void SelectDischargeDate() throws Exception {
		DischargeDate.click();
		Thread.sleep(2000);	
	}
	public void SelectMortality() throws Exception {
		Mortality.sendKeys(mortalitystatus);
		Thread.sleep(2000);	
	}
	public void EnterDescription() throws Exception {
		Description.sendKeys(DischageDes);
		Thread.sleep(2000);	
	}
	public void SelectDischargevitalParameter() throws Exception {
		DischargevitalParameter.sendKeys(Parameter);
		Thread.sleep(2000);	
	}
	public void EnterDischargeParameterValue() throws Exception {
		DischargeParameterValue.sendKeys(ParameterValue);
		Thread.sleep(2000);	
	}
	public void ClickDischargeAddmore() throws Exception {
		DischargeAddmore.click();
		Thread.sleep(2000);	
	}
	public void EnterDischargeRemark() throws Exception {
		DischargeRemark.sendKeys(dischargeremarks);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", DischargeButton);
	}
	@FindBy(xpath ="//button[contains(text(),'No, Thanks')]")
	protected	WebElement DischargeNoTanx;
	public void ClickDischargeButton() throws Exception {
		DischargeButton.click();
		Thread.sleep(2000);	
		YesConfirmBlock.click();
		Thread.sleep(1000);
		DischargeNoTanx.click();
	}

	// GOC- Generate Override Code submitted
	public void ClickBlockPackageLink() throws Exception {
		BlockPackageLink.click();
		Thread.sleep(2000);	
	}
	public void ClickDischargePackageLink() throws Exception {
		DischargePackage.click();
		Thread.sleep(2000);	
	}
	public void EnterBlockPage_Add_EnterURNNo(String data) throws Exception {
		BlockPage_Add_EnterURNNo.sendKeys(data);;
		Thread.sleep(2000);	
	}
	public void ClickSearchButton() throws Exception {
		SearchButton.click();
		Thread.sleep(2000);	
	}
	public void SelectPatientName() throws Exception {
		SelectPatient.click();
		Thread.sleep(2000);	
	}
	public void CheckDeclarationCheckbox() throws Exception {
		try {
			if(CheckDeclaration.isEnabled()) {
				System.out.println("proceed further");
				CheckDeclaration.click();
			}else {
				//CheckDeclaration.click();
				Thread.sleep(2000);
			}
		}catch(Exception e) {

		}

	}
	public void ClickGenerateOverrideCode() throws Exception {
		GenerateOverrideCode.click();
		Thread.sleep(3000);	
	}
	public void EnterNoOfDays(String data) throws Exception {
		NoOfDays.sendKeys(data);
		Thread.sleep(2000);	
	}
	public void UploadFileDoc() throws Exception {
		UploadFile.click();
		Thread.sleep(2000);	
	}
	public void EnterGOCDescription(String data) throws Exception {
		GOCDescription.sendKeys(data);
		Thread.sleep(2000);	
	}
	public void ClickGOCSubmitButton() throws Exception {
		GOCSubmitButton.click();
		Thread.sleep(2000);	
	}
	public void ClickGOCAlertOk() throws Exception {
		GOCAlertOk.click();
		Thread.sleep(2000);	
	}

	////////////////Add Packgae Methods////////////
	public void ClickOnPackageheader() throws Exception {
		SelectPackageheader.click();
		Thread.sleep(2000);	
	}
	public void SearchMRPackageName() throws Exception {
		SearchPackage.sendKeys(SearchMRPac);
		Thread.sleep(2000);	
	}
	public void SearchCovidPackageName() throws Exception {
		SearchPackage.sendKeys(SearchAnyPac);
		Thread.sleep(2000);	
	}
	public void SearchPreauthPackageName() throws Exception {
		SearchPackage.sendKeys(SearchAnyPac);
		Thread.sleep(2000);	
	}
	public void ClickOnChoosePackage() throws Exception {
		ChooseSearchedPackage.click();
		Thread.sleep(2000);	
	}
	public void ClickSelectPackageDetails() throws Exception {
		SelectPackageDetails.click();
		Thread.sleep(2000);	
	}
	public void ClickSelectPackageInfomation() throws Exception {
		SelectPackageInfomation.click();
		Thread.sleep(2000);	
		try {
			if(ALertOk.isDisplayed()) {
				ALertOk.click();
			}else {
				driver.navigate().refresh();
				Thread.sleep(1000);
				UnblockPackageLink.click();
				Thread.sleep(1000);
				SearchForUnblockPackage.sendKeys(SearchAnyPac);
			}
		}catch(Exception e) {

		}
	}
	public void SelectWard() throws Exception {
		SelectWard.sendKeys(Ward);
		Thread.sleep(2000);	
		try{
			if(ALertOk.isDisplayed()) {
				ALertOk.click();
			}else {
				System.out.println(false);
			}
		}
		catch(Exception e) {
		}
	}
	public void ClickAddPackage() throws Exception {
		ClickAddPackage.click();
		Thread.sleep(2000);	
	}
	public void AddmissionDateCalendar() throws Exception {
		AddmissionDateCalendar.click();
		Thread.sleep(2000);	
	}
	public void EnterDoctorName() throws Exception {
		EnterDoctorName.click();
		Thread.sleep(2000);	
	}
	public void EnterDoctorPhoneNo() throws Exception {
		EnterDoctorPhoneNo.click();
		Thread.sleep(2000);	
	}
	public void EnterPatientPhoneNo() throws Exception {
		EnterPatientPhoneNo.sendKeys(PatientPhoneNo);
		Thread.sleep(2000);	
	}
	public void SelectParameter() throws Exception {
		SelectParameter.sendKeys(Parameter);
		Thread.sleep(2000);	
	}
	public void EnterParameterValue() throws Exception {
		EnterParameterValue.sendKeys(ParameterValue);
		Thread.sleep(2000);	
	}
	public void AddParameterDetails() throws Exception {
		AddParameterDetails.click();
		Thread.sleep(2000);	
	}
	public void ClickDeleteParameterBtn() throws Exception {
		DeleteParameterDetails.click();
		Thread.sleep(2000);	
	}
	public void UploadPatientPhoto() throws Exception {
		UploadPatientPhoto.click();
		Thread.sleep(2000);	
	}
	public void EnterBlockingRemark() throws Exception {
		EnterBlockingRemark.sendKeys(BlockingRemark);
		Thread.sleep(2000);	
	}
	public void ClickOnBlock() throws Exception {
		ClickBlock.click();
		Thread.sleep(2000);	
	}
	public void ClickBlockYes() throws Exception {
		ClickBlockYes.click();
		Thread.sleep(2000);	
	}
	public void ClickBlockCloseBtn() throws Exception {
		BlockCloseBtn.click();
		Thread.sleep(2000);	
	}
	//view page initialization
	public void ClickViewTabBtn() throws Exception {
		ViewTabBtn.click();
		Thread.sleep(2000);	
	}
	public void ClickViewSearchBtn() throws Exception {
		ViewSearchBtn.click();
		Thread.sleep(2000);	
	}
	public void EnterViewSearchHereText() throws Exception {
		ViewSearchHereText.sendKeys(SearchPatient);
		Thread.sleep(2000);	
	}
	public void ClickHospitalSlipLink() throws Exception {
		HospitalSlip.click();
		Thread.sleep(2000);	
	}
	public void ClickPatientSlipLink() throws Exception {
		PatientSlip.click();
		Thread.sleep(2000);	
	}
	//AUthority Objects

	@FindBy(xpath = "//A[normalize-space(.)='Referrals']" )
	protected	WebElement Referral;
	@FindBy(xpath = "//a[contains(text(),'FP Override Code')]" )
	protected	WebElement FPOverrideCode;
	@FindBy(xpath = "//input[@id='txtsearchDate']")
	protected WebElement SearchPatientdata;
	@FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
	protected	 WebElement PatientCheckbox1;
	@FindBy(xpath = "//tbody/tr[2]/td[1]/input[1]")
	protected	 WebElement PatientCheckbox2;
	@FindBy(xpath = "//button[contains(text(),'Approve')]")
	protected	 WebElement ApproveBtn;
	@FindBy(xpath = "//button[contains(text(),'Yes!!')]")
	protected	 WebElement ApproveBtnYes;

	public void ClickOnReferral() throws Exception {
		Thread.sleep(5000);	
		Referral.click();	
	}
	public void ClickOnFPOverrideCode() throws Exception {
		Thread.sleep(2000);	
		FPOverrideCode.click();
	}
	public void EnterSearchPatient(String data) throws Exception {
		Thread.sleep(2000);	
		SearchPatientdata.sendKeys(data);
	}
	public void ClickPatientCheckbox() throws Exception {
		Thread.sleep(2000);	
		PatientCheckbox1.click();
		Thread.sleep(1000);	
		PatientCheckbox2.click();
	}
	public void ClickApproveBtn() throws Exception {
		Thread.sleep(2000);
		ApproveBtn.click();	
	}
	public void ClickApproveBtnYes() throws Exception {
		Thread.sleep(2000);
		ApproveBtnYes.click();	
	}
	///////////Condition for OTP Validation///////////////////////

	@FindBy(xpath="//input[@id='textAdmissionOTP']")
	protected WebElement EnterOTPField; 
	@FindBy(xpath="//DIV[@id='admissionOTPModal']/descendant::INPUT[@value='Verify']")
	protected WebElement VerifyOTP;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	protected WebElement AlertOk;
	public void OTPValidation(WebDriver driver) throws InterruptedException { 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		waitForOTPInput(driver,EnterOTPField, Duration.ofMinutes(5));
		VerifyOTP.click();
		Thread.sleep(2000);
		AlertOk.click();
	}
	@FindBy(xpath="//button[@id='btnOTP2']")
	protected WebElement ClickOnOTPButton; 
	@FindBy(xpath="//input[@id='textOTP']")
	protected WebElement EnterOTPFieldforAadhar;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	protected WebElement ClickOTPforAadharYes; 
	@FindBy(xpath="//DIV[@id='OTPModal']/descendant::INPUT[@value='Verify']")
	protected WebElement VerifyOTPbtnforAadhar;
	public void OTPValidationforAadhar(WebDriver driver) throws InterruptedException { 
		String autofetchedCode = AutofetchOR.getAttribute("value");
		String expectedCodePrefix = "B";
		try {
			if(autofetchedCode.startsWith(expectedCodePrefix)) {
				System.out.print("Move further");
			}else {
				ClickOnOTPButton.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				ClickOTPforAadharYes.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				waitForOTPInput(driver,EnterOTPFieldforAadhar, Duration.ofMinutes(5));
				VerifyOTPbtnforAadhar.click();
				Thread.sleep(2000);
			}
		}catch(Exception e) {

		}

	}

	///////////Navigate to home page////////////

	@FindBy(xpath="//i[contains(@class,'fi-rr-home byrd_new')]")
	protected	 WebElement HomepageLink;
	public void  ClickOnHomepageLink() throws InterruptedException {
		Thread.sleep(1000);
		HomepageLink.click();
		}
	
	////////////Conditions and Scenario Validation Methods////////////////////////////

	//GOC- Generate Override Code
	//For Scenario 1
	@FindBy(xpath="//h5[contains(text(),'Override Request')]")
	protected	 WebElement OverrideRequest;
	public void DisplayOfOverrideRequest() throws Exception {
		if(OverrideRequest.isDisplayed()) {
			System.out.println("Response of Generate Override Code verified="+"PASS");
			//CloseOverrideCodePopup.click();
			//Thread.sleep(2000);
			//GenerateOverrideCode.click();
		}else {
			System.out.println("Response of Generate Override Code verified="+"FAIL");
			CloseOverrideCodePopup.click();
		}

	}

	//For Scenario 2
	@FindBy(xpath="//div[@id='swal2-html-container']")
	protected	 WebElement GOCRequestsubmitted;
	public void  VerifyGOCSubmittedMsg() {
		if(GOCRequestsubmitted.getText().equals(GOCSuccessmsg)) {
			System.out.println("GOCRequestsubmitted=" +"PASS");
		}else {
			System.out.println("GOCRequestsubmitted=" + "FAIL");
		}
	}

	//For Scenario 3
	@FindBy(xpath="//input[@id='txtOverrideCode']")
	protected WebElement AutofetchOR;

	public void getAutofetchOR() {
		String autofetchedCode = AutofetchOR.getAttribute("value");
		String expectedCodePrefix = "B"; 
		if (autofetchedCode.startsWith(expectedCodePrefix)) {
			System.out.println("Autofetched code generated successfully= " + "PASS");
		} else {
			System.out.println("Failed to generate autofetched code.=" + "FAIL");
		}
	}

	//For Scenario 4
	@FindBy(xpath="//td[contains(text(),'Total Amount to be blocked')]")
	protected WebElement TotalAmounttobeblocked;

	public void verifyAddpackageaddedsuccessfully() {
		if (TotalAmounttobeblocked.isDisplayed()){
			System.out.println("verify Add package added successfully =" + "PASS");
		} else {
			System.out.println("verify Add package added successfully.=" + "FAIL");
		}
	}	

	public void scrollTillAddMoreButton() {
		// Scroll down to the element
		WebElement elementToScrollTo = driver.findElement(By.id("btnVerifyReferralCode"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
	}

	//For Scenario 5
	@FindBy(xpath="//div[@id='swal2-html-container']")
	protected	 WebElement GetSwallMsg;
	public void  VerifyAddPacMsg() {
		if(GetSwallMsg.getText().equals(AddPacAlertMsg)) {
			System.out.println("verifyAddpackage Notaddedsuccessfully= " + "PASS");
		}else {
			System.out.println("verifyAddpackage Notaddedsuccessfully= " + "FAIL");
		}
	}

	//For Scenario 6
	@FindBy(xpath="//tbody/tr[1]/td[13]/button[1]")
	protected	 WebElement DeleteAddPackage;
	@FindBy(xpath="//button[contains(text(),'Yes, Confirm!')]")
	protected	 WebElement ClickYesConfirmButton;
	public void  VerifyDeleteAddPackage() throws InterruptedException {
		DeleteAddPackage.click();
		Thread.sleep(2000);
		if(GetSwallMsg.getText().equals(DeletePacMsg)) {
			System.out.println("Verify the delete functionality under package details section=" + "PASS");
			Thread.sleep(2000);
			ClickYesConfirmButton.click();
		}else {
			System.out.println("Verify the delete functionality under package details section=" + "FAIL");
		}
	}
	//For Scenario 7
	@FindBy(xpath="//th[contains(text(),'Parameter')]")
	protected	 WebElement ParameterAdded;
	public void  VerifyParameterAddedSuccessfully() throws InterruptedException {
		Thread.sleep(2000);
		if(ParameterAdded.isDisplayed()) {
			System.out.println("Verify the add more functionality of vital information=" + "PASS");
		}else {
			System.out.println("Verify the add more functionality of vital information=" + "FAIL");
		}
	}
	//For scenario 8
	@FindBy(xpath="//button[contains(text(),'OK')]")
	protected	 WebElement ALertOk;
	public void  VerifyAddMoreWithoutEnteringParameter() throws InterruptedException {
		Thread.sleep(2000);
		if(GetSwallMsg.getText().equals(ParamterNotAddedAlert)) {
			System.out.println("Verify the add more functionality without select vital information details=" + "PASS");
			Thread.sleep(1000);
			ALertOk.click();
		}else {
			System.out.println("Verify the add more functionality without select vital information details=" + "FAIL");
		}
	}
	//For scenario 9
	public void  VerifyDeleteParameter() throws InterruptedException {
		if(GetSwallMsg.getText().equals(DeleteParaConfimMsg)) {
			System.out.println("Verify the delete functionality under vital information section=" + "PASS");
			Thread.sleep(1000);
			ClickYesConfirmButton.click();
		}else {
			System.out.println("Verify the delete functionality under vital information section=" + "FAIL");
		}
	}
	//For Critical Scenario No 38
	@FindBy(xpath="//button[contains(text(),'Yes, Confirm!')]")
	protected	 WebElement YesConfirmBlock;
	public void  blockedpackageConfirmation() throws InterruptedException {
		Thread.sleep(1000);
		YesConfirmBlock.click();
	}
	@FindBy(xpath="//button[contains(text(),'Close')]")
	protected	 WebElement CloseBlockButton;
	public void  verifypackageblockedsuccessfully() throws InterruptedException {
		Thread.sleep(2000);
		if(GetSwallMsg.getText().equals(BlockSuccessMsg)) {
			System.out.println("Verify Blocked Successfully=" + "PASS");
			Thread.sleep(1000);
			CloseBlockButton.click();
		}else {
			System.out.println("Verify Blocked Successfully=" + "FAIL");
		}
	}
	public void  CloseBlockedSuccessfullyAlert() throws InterruptedException {
		Thread.sleep(1000);
		CloseBlockButton.click();
	}
	//For Critical Scenario No 39
	public void  AlertWhenMRpackagePatientAblockedTwice() throws InterruptedException {
		Thread.sleep(2000);
		if(GetSwallMsg.getText().equals(MRPacAlreadyTakenMsg)) {
			System.out.println("verify when MR package in parent hospital of Patient A blocked twice=" + "PASS");
			Thread.sleep(1000);
			ALertOk.click();
		}else {
			System.out.println("verify when MR package in parent hospital of Patient A blocked twice=" + "FAIL");
		}
	}
	//For Critical Scenario No 40
	public void  AlertWhenMRpackageTakenInOtherHos() throws InterruptedException {
		Thread.sleep(2000);
		if(GetSwallMsg.getText().equals(MRPacAlreadyTakenAnotherHosMsg)) {
			System.out.println("verify when MR package in child hospital(Patient name A) without discharge of patient from parent hospital=" + "PASS");
			Thread.sleep(1000);
			ALertOk.click();
		}else {
			System.out.println("verify when MR package in child hospital(Patient name A) without discharge of patient from parent hospital=" + "FAIL");
		}
	}
	//For Critical Scenario No 42 & 43
	public void  AlretWhenAPatientAlreadyBlockedInAnotherHos() throws InterruptedException {
		Thread.sleep(2000);
		if(GetSwallMsg.getText().equals(AlreayAdmittedAlert)) {
			System.out.println("verifyTheAlretWhenAPatientAlreadyBlockedInAnotherHos=" + "PASS");
			Thread.sleep(1000);
			ALertOk.click();
		}else {
			System.out.println("verifyTheAlretWhenAPatientAlreadyBlockedInAnotherHos=" + "FAIL");
		}
	}
	//For Critical Scenario No 44
	@FindBy(xpath="//div[contains(text(),'Gayatri Rath')]")
	protected	 WebElement PatientAElement;
	public void  PetientAShouldNotVisibleUnderDischarge() throws InterruptedException {
		Thread.sleep(2000);
		if(PatientAElement.isDisplayed()) {
			System.out.println("Verify Patient A should not display under Discharge Page=" + "FAIL");
			Thread.sleep(1000);
			ALertOk.click();
		}else {
			System.out.println("Verify Patient A should not display under Discharge Page=" + "PASS");
		}
	}
	
	//////////////CARD BALANCE SCENARIOS///////////////////////////
	
	private String removeNonNumericCharacters(String input) {
		// Regular expression to remove non-numeric characters
		String regex = "[^\\d.]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.replaceAll("");
	}

////Scenario 47: Verify the card balance after block the package
	
	@FindBy(xpath="//label[contains(text(),'Currently Available Amount (')]/following-sibling::*")
	protected	 WebElement CurrentAvailbleAmount;
	@FindBy(xpath="//label[contains(text(),'Blocked Amount (')]/following-sibling::*")
	protected	 WebElement BlockedAmount;

	////Scenario 48: Verify the card balance before blocking the package////

	public double AvailablecurrentbalanceBeforeBlocking() throws InterruptedException {
		String main = CurrentAvailbleAmount.getText();
		main= removeNonNumericCharacters(main);
		double AvailablecurrentbalanceBeforeBlocking = Double.parseDouble(main);
		//System.out.println("Current Available Amount: " + AvailablecurrentbalanceBeforeBlocking);
		return AvailablecurrentbalanceBeforeBlocking;		
	}

	//Capturing Blocked Amount
	public double CaptureBlockAmount() throws Exception {
		Thread.sleep(2000);	
		String BA = BlockedAmount.getText(); 
		BA = removeNonNumericCharacters(BA);
		double BAmount = Double.parseDouble(BA);
		//System.out.println(BAmount);
		return BAmount;
	}
	////Scenario 48: Verify the Unblocking Amount////
	@FindBy(xpath="//DIV[contains(@class,'pre-bold text-right')]")
	protected	 WebElement AmountBlockedElement;
	public double  CaptureBlockedAmountNeedtoUnblock() throws InterruptedException {
		Thread.sleep(2000);	
		String ABE = AmountBlockedElement.getText(); 
		ABE = removeNonNumericCharacters(ABE);
		double AmntForUnblock = Double.parseDouble(ABE);
		//System.out.println(BAmount);
		return AmntForUnblock;	
	}

	/////////Capturing the claimed amount
	public double CaptureClaimAmount() throws Exception {
		Thread.sleep(2000);	
		String claimamount = ClaimAmountDisabledField.getAttribute("value");
		claimamount = removeNonNumericCharacters(claimamount);
		double  CaptureClaimAmount= Double.parseDouble(claimamount);	
		//System.out.println(CaptureClaimAmount);
		return CaptureClaimAmount;
	}

	///////////////////////////////////// Hospital Slip and Patient Slip//////////////////

	//Patient Slip
	@FindBy(xpath="//h3[contains(text(),'Patient Slip')]")
	protected	 WebElement PatientSlipDoc;
	public void VerifyPatientSlip(){
		// Get handles of all windows
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to the new window
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		// Now you are in the newly opened window. You can perform actions on this window.
		// Example: Print the title of the new window
		System.out.println(driver.getTitle());
		if(PatientSlipDoc.isDisplayed()) {
			System.out.println("Patient Slip Doc is opening=" + "PASS");
			driver.close();
		}else {
			System.out.println("Patient Slip Doc is not opening=" + "FAIL");
			driver.close();
		}
		// After you are done with the new window, you may want to switch back to the original window
		driver.switchTo().window((String) allWindows.toArray()[0]); // Switch back to the first window
	}
	//Hospital Slip	
	@FindBy(xpath="//h3[contains(text(),'Hospital Slip')]")
	protected	 WebElement HospitalSlipDoc;
	public void VerifyHospitalSlip(){
		// Get handles of all windows
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to the new window
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		// Now you are in the newly opened window. You can perform actions on this window.
		// Example: Print the title of the new window
		System.out.println(driver.getTitle());
		if(HospitalSlipDoc.isDisplayed()) {
			System.out.println("Hospital Slip Doc is opening=" + "PASS");
			driver.close();
		}else {
			System.out.println("Hospital Slip Doc is not opening=" + "FAIL");
			driver.close();
		}
		// After you are done with the new window, you may want to switch back to the original window
		driver.switchTo().window((String) allWindows.toArray()[0]); // Switch back to the first window
	}
	
	//////////////For Female Fund//////////
	
	@FindBy(xpath="//label[contains(text(),'Female Fund (')]/following-sibling::*")
	protected	 WebElement FemaleFund;
	
	public double AvailableFemaleFundBeforeBlocking() throws InterruptedException {
		String main = FemaleFund.getText();
		main= removeNonNumericCharacters(main);
		double AvailableFemaleFundBeforeBlocking = Double.parseDouble(main);
		//System.out.println("Current Available Amount: " + AvailableFemaleFundBeforeBlocking);
		return AvailableFemaleFundBeforeBlocking;		
	}
	@FindBy(xpath="//td[@id='allTotalCost']")
	protected	 WebElement blockPacAMount;
	public double CapturingPacBlockingAmount() throws InterruptedException {
		String main = blockPacAMount.getText();
		main= removeNonNumericCharacters(main);
		double CapturingBlockingpackageAmount = Double.parseDouble(main);
		//System.out.println("Current Available Amount: " + AvailableFemaleFundBeforeBlocking);
		return CapturingBlockingpackageAmount;		
	}
	
	@FindBy(xpath="//button[@id='selectFamily1']")
	protected	 WebElement AnyMaleElement;
	public void SelectAnyMaleElement() throws InterruptedException{
		AnyMaleElement.click();
		Thread.sleep(2000);
	}
	
	public void VerifyUseOFFemleFundByMale() throws InterruptedException{
		Thread.sleep(2000);
		if(GetSwallMsg.getText().equals(AlertForInsufficient)) {
			System.out.println("verify insufficient fund amount for block package=" + "PASS");
			Thread.sleep(1000);
			ALertOk.click();
		}else {
			System.out.println("verify insufficient fund amount for block package=" + "FAIL");
		}
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[10]/input[1]")
	protected	 WebElement PackageInfoForPreauth;
	
	public void ChoosePacForPreauth() throws InterruptedException {
	SearchPackage.sendKeys(SearchPreaauthPac);
	Thread.sleep(2000);
	ChooseSearchedPackage.click();
	Thread.sleep(2000);
	}
	public void PackageInfoForPreauth() throws InterruptedException {
		PackageInfoForPreauth.click();
		Thread.sleep(2000);
		ALertOk.click();
	}

	////////////////Implant and HED///////////
	
	@FindBy(xpath="//BUTTON[normalize-space(.)='Implant']")
	protected	 WebElement Implantbtn;
	@FindBy(xpath="//input[@id='implantCheck18']")
	protected	 WebElement Implantchkbox;
	@FindBy(xpath="//button[@id='addImplant']")
	protected	 WebElement Addimplantbtn;
	
	public void AddImplant() throws InterruptedException {
	Implantbtn.click();
	Thread.sleep(1000);
	Implantchkbox.click();
	Thread.sleep(1000);
	Addimplantbtn.click();
	}
	
	@FindBy(xpath="//BUTTON[normalize-space(.)='High End Drugs']")
	protected	 WebElement HEDbtn;
	@FindBy(xpath="//input[@id='hedCheckHED028']")
	protected	 WebElement HEDchkbox;
	@FindBy(xpath="//input[@id='hedUnitCyclePriceHED028']")
	protected	 WebElement unitprice;
	@FindBy(xpath="//button[@id='addHighEndDrugs']")
	protected	 WebElement AddHEDbtn;
	public void AddHED() throws InterruptedException {
		HEDbtn.click();
		Thread.sleep(1000);
		HEDchkbox.click();
		Thread.sleep(1000);
		unitprice.clear();
		Thread.sleep(1000);
		unitprice.sendKeys("10");
		Thread.sleep(1000);
		AddHEDbtn.click();
		Thread.sleep(1000);
		AlertOk.click();
	}
	
	@FindBy(xpath="//td[contains(text(),'Total Cost (Total Package Cost +Implant Cost +High')]")
	protected	 WebElement ImpantHedAdded;
	
	public void verifyImpantHedAddedSuccessfully() throws InterruptedException {
		Thread.sleep(1000);
		if(ImpantHedAdded.isDisplayed()) {
			System.out.print("Add implant and HED for block package if insufficient amount is there= " +"FAIL");
		}else {
			System.out.print("Add implant and HED for block package if insufficient amount is there= " +"PASS");
		}
	}

}

