@tag
Feature: BlockPackageWithConditions
  I want to use this template for my feature file
@tag1
@LoginHospital
  Scenario: Block MR package in parent hospital(Patient name A)
   	When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
   	And user select patient name
   	When user click on Package Header
    And user choose Package header
 	 	And user click Package details
   	And user Choose Package information
   	And user Select Ward
		Then user click On Add Package button
		And user Enter Patient Phone No and wait
		And User scroll downn till Vital Parameter 
		And user select parameter
		And user enter parameter value
		And user click on add more button of vital information
		And user enter Blocking Remark
		Then user click on the Block button
		Then Verify MR Package Blocked Successfully
		
		@tag2
@LoginHospital
  Scenario: Block twice MR package in parent hospital(Patient name A)
  When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
   	And user select patient name
   	When user click on Package Header
    And user choose Package header
		Then Verify Proper Alert Messsage should be displayed
		
@tag3
@LoginChildHospital
	Scenario: Generate OC in Child hos
	 	When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
		And user select patient name
		And user tick on declaration checkbox
		#And user validate adhaar OTP
		 Then Click on Generate Override Code
    And user enter data in no of days field 
    And user enter data in description field 
    And user click on SubmitButton
  
  @tag4
  @LoginAsAuthority2
  Scenario: Login To Authority and Approve GOC
    When Auth click on RefferalModule
    And Auth click on FP Override Code 
    And Auth Enter Patient Search data
    And Auth select patient check box
    Then Auth Click on the Approve button

@tag5
@LoginChildHospital
	Scenario: Block MR package in child hospital(Patient name A) without discharge of patient from parent hospital.
	 	When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
		And user select patient name
		And user tick on declaration checkbox    
		When user click on Package Header
    And user choose Package header
  Then verify Proper Alert Message should be displayed for MR package

@tag6
@LoginChildHospital
	Scenario: Block other package in child hospital with patient A without discharge of patient from parent hospital 
after block MR package in parent hospital
	 
	 	When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
		And user select patient name
		And user tick on declaration checkbox
		And user validate adhaar OTP
		When user click on Package Header
    And user choose Package header of Any
 	 	And user click Package details 
   	And user Choose Package information of Any
   	And user Select Ward
		Then user click On Add Package button
		And user Enter Patient Phone No and wait
		And User scroll downn till Vital Parameter 
		And user select parameter
		And user enter parameter value
		And user click on add more button of vital information
		And user enter Blocking Remark
		Then user click on the Block button
		Then Verify Other Package should be blocked successfully
	
@tag7
@LoginHospital
	Scenario: Block package in parent hospital(Patient A) without discharge of patient A from child hospital
	 
	 	When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
		And user select patient name
		Then Verify proper alert message should be displayed for already admitted patient
		
@tag8
@LoginAsThirdHospital
	Scenario: Block package in third hospital for patient A without discharge from child hospital
	 
	 	When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
		And user select patient name
		Then Verify proper alert message should be displayed for already admitted patient
		
@tag9
@LoginHospital
	Scenario: Discharge patient in parent hospital(Patient A) without discharge of patient A from child hospital
	 
	 	When user Click on Discharge Package
		Then Verify Patient A should not display under Discharge Page
	 
@tag10
@LoginHospital
  Scenario: Verify the submission of Override Request
    When user Click on Block package
    And user enter data in the search field "01031110603"
    And user click on search button
    And user select patient name
    And user tick on declaration checkbox
    Then Click on Generate Override Code
    And user enter data in no of days field 
    And user enter data in description field 
    And user click on SubmitButton
		Then Verify the succesful submition of override request
		
	@tag11
@LoginAsAuthority
  Scenario: Login To Authority and Approve GOC
    When Auth click on RefferalModule
    And Auth click on FP Override Code 
    And Auth Enter Patient Search data
    And Auth select patient check box
    Then Auth Click on the Approve button	
	 	
	@tag12
@LoginHospital
	Scenario: Verify the card balance after block the package 
	 	When user Click on Block package
	 	And user enter data in the search field "01031110603"
 	 	And user click on search button
	 	Then Verify the current available balance before block the package
		And user select patient name
		And user tick on declaration checkbox
		When user click on Package Header
    And user choose Package header of Any
 	 	And user click Package details 
   	And user Choose Package information of Any
   	And user Select Ward
		Then user click On Add Package button
		And user Enter Patient Phone No and wait
		And User scroll downn till Vital Parameter 
		And user select parameter
		And user enter parameter value
		And user click on add more button of vital information
		And user enter Blocking Remark
		Then user click on the Block button
		Then user close the Block Successfully Alert
		Then user scroll up
		Then user go to home page
		When user Click on Block package
	 	And user enter data in the search field "01031110603"
 	 	And user click on search button
 	 	Then verify the Blocked Amount
	 	Then Verify the card balance after block the package	
	
	@tag13
	@LoginHospital
	Scenario:  Verify the Patient Slip and Hospital Slip
			When user Click on Block package
			And user click on the view tab
			And user click on search button on view tab
			And user Enter Search data
			And user Click on Patient Slip
			Then user Verify Patient Slip
			And user Click on Hospital Slip
			Then user Verify Hospital Slip
	
 	 	@tag14
@LoginHospital
	Scenario: Verify the card balance after unblock the package
		When user Click on Block package
	 	And user enter data in the search field "01031110603"
 	 	And user click on search button
	 	Then Verify the current available balance before block the package
	 	Then user go to home page
		Then user click on the unblock Package link
		And user search the patient name
		And user click on unblock button against the record
		And user capture the blocked package amount
		And user select package to unblock
		#And user tick on declaration checkbox
		And user enter unblocking remark
		Then user click on the Unblock button
		Then user close the Block Successfully Alert
		#Then user scroll up
		#Then user go to home page
		When user Click on Block package from view page
    And user enter data in the search field "01031110603"
 	 	And user click on search button
 	 	Then user Verify the card balance after unblock the package
 	 	
 	 	@tag15
@LoginHospital
	Scenario: Generate Override code from Discharge Patient
		Then user click on the Discharge Package link
		And user click on search button on view tab
		And Click on discharge link against the record
		And user tick on declaration checkbox
		Then Click on Generate Override Code
    And user enter data in no of days field 
    And user enter data in description field 
    And user click on SubmitButton
   
   @tag16
@LoginAsAuthority
  Scenario: Login To Authority and Approve GOC
    When Auth click on RefferalModule
    And Auth click on FP Override Code 
    And Auth Enter Patient Search data
    And Auth select patient check box
    Then Auth Click on the Approve button 
		
		@tag17
	@LoginHospital
	Scenario: Verify the card balance update after refund amount in patient discharge.
		When user Click on Block package
	 	And user enter data in the search field "01031110603"
 	 	And user click on search button
 	 	Then Verify the current available balance before block the package
 	 	Then user go to home page
		Then user click on the Discharge Package link
		And user click on search button on view tab
		And Click on discharge link against the record
		And user tick on declaration checkbox
		And user tick on the package check box
		Then user change the claim amount
		And user select Actual Date of Discharge
		Then user fetched the claimed amount and capture it
		And user select Mortality
		And user enter Description
		And user select Discharge parameter
		And user enter Discharge parameter value
		And user click on Discharge add more button of vital information
		And user enter Discharge Remarks
		Then user click on the Discharge button
		Then user go to home page
		When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
 	 	Then user verify card balance update after refund amount in patient discharge
		
   @tag18
	@LoginHospital
	Scenario: Verify the card balance as per SNA approve amount in case of preauth.
		When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
		And user select patient name
		And user tick on declaration checkbox
		And user validate adhaar OTP
		When user click on Package Header
    And user choose Package header of Preauth
 	 	And user click Package details 
   	And user Choose Package information of Preauth
   	And user Select Ward
		Then user click On Add Package button
		And user Enter Patient Phone No and wait
		And user choose Preauth file
		And user Enter No.Of.Days
		And user click on the Preauth Description
		And user Enter Patient Phone No and wait
		And User scroll downn till Vital Parameter 
		And user select parameter
		And user enter parameter value
		And user click on add more button of vital information
		And user enter Blocking Remark
		
	@tag19
@LoginHospital
	Scenario: Generate Override code from Discharge Patient
		Then user click on the Discharge Package link
		And user click on search button on view tab
		And Click on discharge link against the record
		And user tick on declaration checkbox
		Then Click on Generate Override Code
    And user enter data in no of days field 
    And user enter data in description field 
    And user click on SubmitButton
   
   @tag20
@LoginAsAuthority
  Scenario: Login To Authority and Approve GOC
    When Auth click on RefferalModule
    And Auth click on FP Override Code 
    And Auth Enter Patient Search data
    And Auth select patient check box
    Then Auth Click on the Approve button 
	
	@tag21
	@LoginHospital
	Scenario: Block package for female to check use of female fund
		When user Click on Block package
	 	And user enter data in the search field "01031110603"
 	 	And user click on search button
 	 	Then Verify the current available balance before block the package
 	 	Then Verify the Current Female Fund
 	 	And user select patient name
   When user click on Package Header
    And user choose Package header of Any
 	 	And user click Package details 
   	And user Choose Package information of Any
   	And user Select Ward
		Then user click On Add Package button
		Then user the Capture Blocking Amount during add pac
		And user Enter Patient Phone No and wait
		And User scroll downn till Vital Parameter 
		And user select parameter
		And user enter parameter value
		And user click on add more button of vital information
		And user enter Blocking Remark
		Then user click on the Block button
		Then user close the Block Successfully Alert
		Then user scroll up
		Then user go to home page
		When user Click on Block package
	 	And user enter data in the search field "01031110603"
 	 	And user click on search button
		Then Verify the Use Of Current Female Fund
		
	@tag22
@LoginHospital
	Scenario: Block package for male&Family to check use of female fund
		When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
		And user select Male patient name
		Then user verify Block package for male&Family to check use of female fund
		
@tag23
@LoginHospital
	Scenario: Verify the insufficient fund amount for block package when total amount is less than blocked package
		When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
 	 	Then Verify the Current Female Fund
		And user select patient name
 	 	When user click on Package Header
  	And user choose Package header of Preauth
 	 	And user click Package details 
   	And user Choose Package information of Preauth
   	And user Select Ward
		Then user click On Add Package button
		Then user the Capture Blocking Amount during add pac
		Then user verify insufficient fund amount for block package
		
@tag24
@LoginHospital
	Scenario: Verify the once insufficient amount coming, other implant,HED and package unable to add for block package
		When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
 	 	Then Verify the Current Female Fund
		And user select patient name
 		When user click on Package Header
    And user choose Package header of Preauth
 	 	And user click Package details 
   	And user Choose Package information of Preauth
   	And user Select Ward
		Then user click On Add Package button
		Then user the Capture Blocking Amount during add pac
		Then user verify insufficient fund amount for block package
		Then user unable to add implant and HED for block package if insufficient amount is there 
		
		
    	