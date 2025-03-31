Feature: Login

  Scenario: Successful login with valid credentials
    Given User launche chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login?returnUrl=%2F"
    And User enter email "admin@yourstore.com" and password "admin"
    And User clicks on Login Button
    Then Page title should be "General settings / nopCommerce administration"
    When User click on logout button
    Then Page title should be "nopCommerce demo store. Login"
    And Close the browser

