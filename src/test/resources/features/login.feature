Feature: Ipoteka module functionality

  @wip
  Scenario: Invalid credentials test
    When  the user is logged in ipotekalar module
    And the user selects "Torpaq ipotekası" from Ipoteka növü drop down
    And the user enters "567" in FIN kod box
    And the user enters "+994 50 770" in Mobil nömrə box
    And the user selects "Evli" from Ailə vəziyyəti drop down
    And the user enters "A#" in Ailə üzvlərin sayı box
    And the user enters "789ABcdE152" in Digər xərclər və öhdəliklər box
    And the user clicks "Sahibkarlıq gəliri" and "Digər gəlir mənbəyi" in the checkbox
    And the user enters "KlglYu" in VÖEN box
    And the user enters "B#" in Orta aylıq xalis mənfəət (₼) box
    And the user enters "b%" in Fəaliyyət müddəti box
    And the user clicks on submit button
    Then error message should be displayed

