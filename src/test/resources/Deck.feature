# https://deckofcardsapi.com/

@all @deck
Feature: Card deck test

  @uniqueDeck
  Scenario Outline: Check that any new deck is unique
    Given shuffle new <new_deck_amount> decks
    When shuffle another <another_deck_amount> decks
    Then validate that additional deck is unique
    Examples:
      | new_deck_amount | another_deck_amount |
      | 3               | 3                   |
      | 1               | 6                   |
