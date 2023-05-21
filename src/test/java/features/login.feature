@Browser
Feature: This feature will be used to test the login functionality of Simplilearn Application


  Background: 
    Given I have launched the application
    And I have clicked on Login Link
	@WIP
  Scenario: Validate the Login success scenario
    When I enter username
    And I enter password
    And I clicked on login button
    Then I should land on home page
	
	@Sanity
  Scenario: Validate the Login failure scenario
    When I enter username
    And I enter password
    And I clicked on login button
    Then I should get the error message
    
	@Sanity
  Scenario: Validate the Login failure scenario with parameter
    When I enter username as "Testing4304@gmail.com"
    And I enter password as "Testing@123"
    And I clicked on login button
    Then I should get the error message as "The email or password you have entered is invalid."
	@Regression @Sanity
  Scenario Outline: Validate the Login failure scenario using examples
    When I enter username as "<UserName>"
    And I enter password as "<Password>"
    And I clicked on login button
    Then I should get the error message as "<Error>"

    Examples: 
      | UserName    | Password | Error                                              |
      | pqr@xyz.com | Pqr@1234 | The email or password you have entered is invalid. |
      | xyz@abc.com | Xyz@1234 | The email or password you have entered is invalid. |
