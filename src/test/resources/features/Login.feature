Feature: Login feature

  Scenario: Login Success
    Given I open login page
    When I provide email "viktoryia.zhuk@testpro.io"
    And I provide password "te$t$tudent"
    And I click on submit button
    Then I am on Home Page

    Scenario: Login with invalid email, invalid password
      Given I open login page
      When I provide email "viktoryia@testpro.io"
      And I provide password "te$t$tudent11111"
      And I click on submit button
      Then I stayed on Login Page

  Scenario: Login with valid email, invalid password
    Given I open login page
    When I provide email "viktoryia.zhuk@testpro.io"
    And I provide password "te$t$tudent11111"
    And I click on submit button
    Then I stayed on Login Page

  Scenario: Login with invalid email, valid password
    Given I open login page
    When I provide email "viktoryia@testpro.io"
    And I provide password "te$t$tudent"
    And I click on submit button
    Then I stayed on Login Page

  Scenario: Login with empty email, empty password
    Given I open login page
    When I provide email ""
    And I provide password ""
    And I click on submit button
    Then I stayed on Login Page

  Scenario: Login with valid email, empty password
    Given I open login page
    When I provide email "viktoryia.zhuk@testpro.io"
    And I provide password ""
    And I click on submit button
    Then I stayed on Login Page

  Scenario: Login with empty email, valid password
    Given I open login page
    When I provide email ""
    And I provide password "te$t$tudent"
    And I click on submit button
    Then I stayed on Login Page






