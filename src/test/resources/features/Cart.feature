@CartFeature @Regression
Feature: Cart Feature

  Background: user login using valid username and password
    Given user login using username: "validUsername" and password: "validPassword"
    When user click login button
    Then user should see welcome "username"

  @Positive
  Scenario: user delete product on cart page
    When user click first product on home page
    Then user should see product name on product detail page

    When user click add to cart button
    Then user should see "product added." message

    When user click cart button
    Then user should see the added product

    When user delete product on cart page
    Then user should see empty cart