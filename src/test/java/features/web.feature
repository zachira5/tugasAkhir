Feature: Test automation web

  @web
  Scenario: Test login web normal
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon chart in homepage