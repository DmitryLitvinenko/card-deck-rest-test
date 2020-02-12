# https://deckofcardsapi.com/

@all @cards
Feature: Cards from deck test

  @drawCardRemaining
  Scenario: Draw cards from deck and check remaining
    Given shuffle new 10 deck
    When draw 2 cards
    Then check remaining cards

  @drawCardValidation
  Scenario: Validate pulled cards from deck
    Given shuffle new 10 deck
    When draw 1 cards
    Then validate card parameters