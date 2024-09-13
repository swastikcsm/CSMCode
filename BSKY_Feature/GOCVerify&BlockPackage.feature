@tag
Feature: GOCVerify&BlockPackage
  I want to use this template for my feature file

 @tag1
 # @LoginHospital
  Scenario: Verify the Auto fetched of Override code
   	When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
   	And user select patient name
		Then Verify the Auto fetched of Override code
		
	@tag2
 # @LoginHospital
  Scenario: Verify add package functionality with select package details
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
		Then user verify add package added successfully
	
	@tag3
 #@LoginHospital
  Scenario: Verify add package functionality without select package details
  When user Click on Block package
    And user enter data in the search field "01031110603"
 	 	And user click on search button
   	And user select patient name
  Then user scrolldown till Add Package button
   	Then user click On Add Package button
		Then user verify add package sould not added successfully
		
	@tag4
  #@LoginHospital
  Scenario: Verify the delete functionality under package details section.
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
		Then user verify the delete functionality under package details section
	
	@tag5
  #@LoginHospital
  Scenario: Verify the add more functionality with select data under vital information section
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
		And User scroll downn till Vital Parameter 
		And user select parameter
		And user enter parameter value
		And user click on add more button of vital information
		Then Verify the add more functionality of vital information
	
	@tag6
 #@LoginHospital
  Scenario: Verify the add more functionality without select data under vital information section
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
		And User scroll downn till Vital Parameter 
		And user click on add more button of vital information
		Then Verify the add more functionality without select vital information details
	
	@tag7
# @LoginHospital
  Scenario: Verify the delete functionality under vital information section.
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
		And User scroll downn till Vital Parameter 
		And user select parameter
		And user enter parameter value
		And user click on add more button of vital information
		And user click on delete button of added vital information
		Then Verify the delete functionality under vital information section
		
