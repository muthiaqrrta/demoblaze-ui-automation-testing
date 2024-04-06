@CheckoutFeature @Regression
Feature: Checkout Feature

  Background: user login using valid username and password
    Given user login using username: "validUsername" and password: "validPassword"
    When user click login button
    Then user should see welcome "username"

  @Positive
  Scenario: user order a product
    When user click first product on home page
    Then user should see product name on product detail page

    When user click add to cart button
    Then user should see "product added." message

    When user click cart button
    Then user should see the added product

    When user click place order button
    And fill name form using "tester"
    And fill country using "indonesia"
    And fill city using "surabaya"
    And fill credit card using "111"
    And fill month using "2"
    And fill year using "2024"
    And user click purchase button
    Then user should see order successfull

  @Positive
  Scenario: user order empty product
    When user click cart button
    And user click place order button
    And fill name form using "tester"
    And fill country using "indonesia"
    And fill city using "surabaya"
    And fill credit card using "111"
    And fill month using "2"
    And fill year using "2024"
    And user click purchase button
    Then user should not see order successfull