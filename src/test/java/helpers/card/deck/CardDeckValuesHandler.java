package helpers.card.deck;

import elements.models.DeckResponse;

public class CardDeckValuesHandler {
    //todo dependency injection
    protected CardDeckHelper cd = new CardDeckHelper();

    protected static String DECK_RESPONSE = null;
    protected static String ANOTHER_DECK_RESPONSE = null;
    protected static int SHUFFLED_DECKS_AMOUNT;
    protected static DeckResponse DECK_RESPONSE_ENTITY = null;
}
