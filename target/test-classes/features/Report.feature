@sprint3 @addreport
Feature: Report

  Background: 
    Given I am logged into HRMS
    And I navigated to the Reports Page

  @smoke
  Scenario Outline: Search for invalid report
    When I enter invalid "<reportName>" report
    And I click search button
    Then I see "No Records Found" message

    Examples: 
      | reportName |
      | Regression |
      | Smoke      |

  Scenario: Search for valid report
    When I enter "Syntax Report" report
    And I click search button
    Then I see the search "Syntax Report" is displayed
