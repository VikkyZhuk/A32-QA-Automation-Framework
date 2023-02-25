Feature: Login feature

  Scenario: Login Success
    Given I open login page
    When I provide email "viktoryia.zhuk@testpro.io"
    And I provide password "te$t$tudent"
    And I click on submit button
    Then I am on Home Page

