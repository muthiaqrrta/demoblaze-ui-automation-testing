@LoginFeature @Regression
Feature: Login Feature

  @Positive
  Scenario: user login using valid username and password
    Given user login using username: "validUsername" and password: "validPassword"
    When user click login button
    Then user should see welcome "username"
    And user should see logout button

  @Negative
  Scenario: user login using invalid username and password
    Given user login using username: "invalidUsername" and password: "invalidPassword"
    When user click login button
    Then user should see "wrong password." message

  @Negative
  Scenario: user login using blank username and password
    Given user login using username: "blank" and password: "blank"
    When user click login button
    And user click close button
    Then user should not see logout button