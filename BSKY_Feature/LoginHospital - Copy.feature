
@tag
Feature: LoginHospital Feature

  @tag1
  Scenario: Login with valid data 
   Given User launch chrome browser 
   When User open URL "http://192.168.10.46/bsky_tms_testI/#/login"
   And User enter ID as "<userid>" and Password as "<password>"
   And User click on login button
   
   Examples: 
      | userid  | password  |
       |21173025| Admin@123 |
       
    

