# https://deckofcardsapi.com/

@all @deck
Feature: Card deck test

  @uniqueDeck
  Scenario: Check that additional deck is unique
    Given shuffle new 10 decks
    When shuffle another 10 decks
    Then validate that additional deck is unique