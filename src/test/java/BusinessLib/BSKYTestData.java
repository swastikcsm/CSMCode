package BusinessLib;

public interface BSKYTestData {

		//TMS DATA
		String Hospital_UN="21162002";
		String Hospital_PWD="Admin@123";
		String NFSASFSSURNNo= "01031110603";
		String NOOfDays= "25";
		String Description="OVERRIDE CODE REQUESTED";
		String ORSuccessfulmessage="Override Request generated successfully!!"
				+ "Click ok to redirect override view page.";
		//GOC Take action
		String AnugulDC_UN="anuguldc";
		String AnugulDC_PWD="Admin@123";
		String SearchFPOverrideCode= "SUBHRAKANTA";
		String Description1Remark="Approving Unblock";
		String Description2Remark="Approving Block";			
		String GOCApproveConfimationMessage="Are you sure to approve?";
		String GOCApproveSuccessfulMessage="Approved Successfully";
		
		//Adding Block package
		String Ward="Routine Ward";
		String DoctorName="Dr Ambika";
		String DoctorPhoneNo= "8908789088";
		String PatientPhoneNo="7008956426";
		String Parameter="Blood pressure";
		String ParameterValue="123/77";
		String BlockingRemark="Blocking this Package";
		
		//Generate Override code request
		String NoOfDaysdata="10";
		String DescriptionGOC="override request";
		String GOCSuccessmsg="Successfully requested to generate override code.";
		String PatientName= "Gayatri";
		String Autofetchdata="B68971";
		//Discharge
		String mortalitystatus="No";
		String DischageDes="Discharging";
		String claimAMountvalue="50";
		String dischargeremarks="Discharge Successfully";
		//Add Packgae Msg
		String SearchMRPac="MR";
		String SearchAnyPac="Covid";
		String SearchPreaauthPac="Interventional Radiology";
		String SearchPatient="Gayatri";
		String AddPacAlertMsg= "Please select package header!";
		String DeletePacMsg	="Are you sure you want to delete this package?";
		String ParamterNotAddedAlert="Please select a valid vital parameter";
		String DeleteParaConfimMsg="Are you sure ? You want to delete the vital parameter?";
		String BlockConfirmMsg="Are you sure you want to block this package?";
		String BlockSuccessMsg="Package Blocked Successfully.";
		String MRPacAlreadyTakenMsg= "You have already taken MR package in previous blocking, Please select another package!";
		String MRPacAlreadyTakenAnotherHosMsg= "You have already taken MR package in another hospital, Please select another package!";
		String AlreayAdmittedAlert="Patient is already admitted to another hospital!";
		String Unblockingremarks="Unblocking the package";
		String AlertForAlreadytakenPac="You have already taken this package in previous blocking, Please select another package!";
		String AlertForInsufficient="Family's balance is insufficient to block package!";
		
}
