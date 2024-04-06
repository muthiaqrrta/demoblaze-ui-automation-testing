@HomeFeature @Regression
Feature: Home Feature

  Background: user login using valid username and password
    Given user login using username: "validUsername" and password: "validPassword"
    When user click login button
    Then user should see welcome "username"

  @Positive
  Scenario: user verify next and prev button on home page
    When user click next button on home page
    Then user should see product that is different from the first product

    When user click prev button on home page
    Then user should see the same product as the first product

