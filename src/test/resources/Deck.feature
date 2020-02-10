# https://deckofcardsapi.com/

@all @deck
Feature: Card deck test

  @uniqueDeck
  Scenario: Check that new deck is unique

    Given shuffled deck
    And validate that deck has all parameters
    When shuffle another deck
    Then validate that deck is unique