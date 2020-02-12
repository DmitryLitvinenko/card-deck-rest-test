# https://deckofcardsapi.com/

@all @cards
Feature: Cards from deck test

  @drawCard
  Scenario: Draw cards from deck and check remaining
    Given shuffle new 10 deck
    When draw 2 cards
    Then check remaining cards