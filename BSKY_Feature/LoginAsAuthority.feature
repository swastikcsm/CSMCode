@tag
Feature: LoginAsAuthority
  I want to use this template for my feature file

  @tag1
  Scenario: LoginAuth with valid data 
   Given Authority launch chrome browser 
   When Authority open URL "http://192.168.10.46/bsky_portal_testI/#/login"
   And Authority enter ID as "<userid>" and Password as "<password>"
   And Authority click on login button
   
   Examples: 
      | userid  | password  |
       |karaputdc    | Admin@123 |
