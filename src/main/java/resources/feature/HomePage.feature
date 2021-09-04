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
    Then validate prices
      # latter I will add the Array list
    And validate total price
    And close MSR info


