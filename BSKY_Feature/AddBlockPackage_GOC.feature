@tag
Feature: AddBlockPackage_GOC

 @tag1
 @LoginHospital
  Scenario: Verify the response of generate override code
   	When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
   	And user select patient name
    And user tick on declaration checkbox
    Then Click on Generate Override Code
		Then Verify the response when click on Generate Override Code
		
		@tag2
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
		
	@tag3
  @LoginAsAuthority
  Scenario: Login To Authority and Approve GOC
    When Auth click on RefferalModule
    And Auth click on FP Override Code 
    And Auth Enter Patient Search data
    And Auth select patient check box
    Then Auth Click on the Approve button
    
    @tag4
	@LoginHospital
	 Scenario: Block Package with valid data
		 When user Click on Block package
    And user enter data in the search field "01031110603"
    And user click on search button
    And user select patient name
    When user click on Package Header
    And user choose Package header of covid
 	 	And user click Package details 
   	And user Choose Package information of Covid
   	And user Select Ward
		Then user click On Add Package button
		And user Enter Patient Phone No and wait
		And User scroll downn till Vital Parameter 
		And user select parameter
		And user enter parameter value
		And user click on add more button of vital information
		And user enter Blocking Remark
		Then user click on the Block button
	
 