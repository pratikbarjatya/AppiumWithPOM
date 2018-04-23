Feature: Watching a Product
  As an application user,
  I should be able to watch a product in the app

  Scenario: Guest user watching a product
    Given I search for a product "oneplus 5t"
    And I sort the search results by "Highest Price"
    When I select the "first" available product
    And I watch the product
    And I enter my credentials to sign in
      | emailId              | password   |
      | helloworld@gmail.com | helloworld |
    And I close the sign in page
    And I press back button
    And I want to print first "2" search results