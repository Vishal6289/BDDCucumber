Feature: Login

  @sanity
  Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login?returnUrl=%2F"
    And User enter email "admin@yourstore.com" and password "admin"
    And User clicks on Login Button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout button
    Then Page title should be "nopCommerce demo store. Login"
    And Close the browser

  @Regression
  Scenario Outline: Successful login with valid credentials
    Given User launch chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login?returnUrl=%2F"
    And User enter email "<email>" and password "<password>"
    And User clicks on Login Button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout button
    Then Page title should be "nopCommerce demo store. Login"
    And Close the browser

    Examples:
    |email||password|
    |admin@yourstore.com||admin|
    |test@yourstore.com ||admin|