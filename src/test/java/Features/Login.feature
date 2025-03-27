#Author : Saranya M
Feature: Login
Background: Given user Launches Browser

  @RegressionTest
  Scenario: Login with valid credentials
    Given user Opens the Url "https://tutorialsninja.com/demo/"
    When clicks on Login link
    And user enters Email as "tutorialninja2025@gmail.com" and password as "Tutorial@2025"
    And click on Login button
    When user click on Logout link
    Then Page title should be "My Account"

  @RegressionTest
  Scenario Outline: Verify login with various credentials
    Given user Opens the Url "https://tutorialsninja.com/demo/"
    When clicks on Login link
    And user enters Email as '<Email>' and password as "<Password>"
    And click on Login button
    When user click on Logout link
    Then Page title should be "Account Login"

    Examples: 
      | Email                       | Password      |
      | tutorialninja2025           | Tutorial@2025 |
      | tutorialninja2025@gmail.com | Tutorial      |

      @functionalTests
  Scenario: Login without credentials
    Given user Opens the Url "https://tutorialsninja.com/demo/"
    When clicks on Login link
    Then application should throw error