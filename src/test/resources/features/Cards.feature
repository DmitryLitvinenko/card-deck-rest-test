# https://deckofcardsapi.com/

@all @cards
Feature: Cards from deck test

  @drawCardRemaining
  Scenario: Draw cards from deck and check remaining
    Given shuffle new 10 deck
    When draw 2 cards
    Then check remaining cards

  @drawCardValidation
  Scenario Outline: Validate <cardAmount> pulled cards from deck
    Given shuffle new 10 deck
    When draw <cardAmount> cards
    Then validate card parameters
    
    Examples:
      | cardAmount |
      | 0          |
      | 1          |
      | 10         |