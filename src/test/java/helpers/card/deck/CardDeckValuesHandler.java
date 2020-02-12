package helpers.card.deck;

import elements.models.DeckResponse;

public abstract class CardDeckValuesHandler {
    //todo dependency injection
    protected CardDeckHelper cd = new CardDeckHelper();

    protected static String deckResponse = null;
    protected static String anotherDeckResponse = null;
    protected static int shuffledDecksAmount;
    protected static DeckResponse deckResponseEntity = null;
}
