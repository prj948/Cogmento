Feature: Test Cogmento Application

  Scenario: Test Login Functionality
    Given User is on LoginPage using "chrome" browser
    When User enters Valid username and Password
      | prafulp1010@gmail.com | Pr@ful0812  |
    And User should click on LoginButton

  Scenario: Test HomePage Functionality
    Given User is on HomePage and Validate Title  HomePage
    And user Validate Url of HomePage
    And user Validate Logo of HomePage
