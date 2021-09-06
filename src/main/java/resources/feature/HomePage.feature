@etsy
Feature: Etsy search functionality

  Scenario: first test case
    Given user is on etsy home page
#    When user click save and wagons
#    Then user get all prices
    When  user select SUVs and Wagons
    Then user validate the car title and year

    When user click to build button
    Then validate start price
    And validate 3 version of car
    And validate premium prices
    And validate 3 version of car dif options

  Scenario: second test case
    When select premium plus
    And click view key MSRP info
    Then validate prices of "$ 44,100", "$ 595", "$ 1,095"
    And validate total price
    And close MSR info

  Scenario: third test case
    When user highlights color
    Then validate if color name is "District Green metallic", and price is "$ 595"
    When user clicks green color
    Then validate if total sum is equal to 45790
    When user chooses wheel
    Then validate if the text on wheel label is equal to "19\" 5-double-arm design wheels, bi-color finish, with all-season tires $800"




