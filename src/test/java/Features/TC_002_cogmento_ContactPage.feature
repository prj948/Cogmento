Feature: Test Cogmento ContactPage Application

  Scenario Outline: Validate Contact Page Functionality
    When User is on HomePage and click on contacts
    When User is on contactPage and Validate ContactPage url contains "contacts"
    And User click on create button
    And User enter contact information using "<SheetName>" and <RowNumber>
    And User click on save button
    And User will delete the created contact

    Examples: 
      | SheetName   | RowNumber |
      | ContactList |         0 |
      | ContactList |         1 |
      | ContactList |         2 |
      | ContactList |         3 |

  Scenario: Validate Logout Functionality
    When User click on profile icon
    And User click on Logout option
    And User close the session
