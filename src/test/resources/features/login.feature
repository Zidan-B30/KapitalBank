
Feature: Login functionality
  @ipoteka
  Scenario: Negative login test
    Given the user is logged in



  Scenario Outline: Negative login test
    Given the user is logged in
    When the user is in "İPOTEKALAR" module
    And the user clicks on "Müraciət et" button
    And the user should fill up letters in "<input box>"
    Then the user should see "<error message>"
    Examples:
      | input box                    | error message                                              |
      | Ailə üzvlərin sayı           | Zəhmət olmasa, ailə üzvlərinin sayını düzgün daxil edin    |
      | Fəaliyyət müddəti, ay        | Zəhmət olmasa, müddəti düzgün daxil edin                   |
      | Orta aylıq xalis mənfəət (₼) | Zəhmət olmasa, orta aylıq xalis mənfəəti düzgün daxil edin |


    And the user should fill up letters in "Ailə üzvlərin sayı" input box
    Then the user should see "Zəhmət olmasa, ailə üzvlərinin sayını düzgün daxil edin" error message


    And the user should fill up all input boxes
    And the user clicks on "Müraciət et" button
    Then the user should see "Zəhmət olmasa, ailə üzvlərinin sayını düzgün daxil edin" error message
