Feature: Customer
  Background: Steps commoon for all scenarios
    Given User launch chrome browser
    When User opens url "https://admin-demo.nopcommerce.com/login?returnUrl=%2F"
    And User enter email "admin@yourstore.com" and password "admin"
    And User clicks on Login Button
    Then User can see Dashboard
@Sanity @Regression
  Scenario: Adding a new customer
    When User clicks on Customer menu
    And clicks on Customers menu item
    And User clicks on Add new button
    Then User can see Add mew customers page
    When User enter customer info
    And Clicks on Save Button
    Then User can see confirmation message "The customer has been added successfully"
    And close the browser

    Scenario: Searching user by email Address
      When User clicks on Customer menu
      And clicks on Customers menu item
      And Enter customer email
      When Click on search button
      Then User should found the email in the search table
      And close the browser

  Scenario: Searching user by Name
    When User clicks on Customer menu
    And clicks on Customers menu item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found the FirstName and LastName in the search table
    And close the browser

