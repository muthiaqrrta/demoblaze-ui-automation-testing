@SignupFeature @Regression
Feature: Signup Feature

  @Positive
  Scenario: user sign up with not existing username and password
    Given user sign up using username: "notExistingUsername" and password: "notExistingPassword"
    When user click sign up button
#    Then user should see alert message
    When user click login button
    And user login using username: "signupUsername" and password: "signupPassword"
    Then user should see welcome "username"
    And user should see logout button

  @Negative
  Scenario: user sign up with existing username and password
    Given user sign up using username: "existingUsername" and password: "existingPassword"
    When user click sign up button
#    Then user should see alert message

  @Negative
  Scenario: user sign up using blank username and password
    Given user sign up using username: "blank" and password: "blank"
    When user click sign up button
#    Then user should see alert message
