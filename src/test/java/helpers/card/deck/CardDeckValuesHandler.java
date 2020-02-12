package helpers.card.deck;

import elements.models.CardsModel;
import elements.models.DeckModel;

public abstract class CardDeckValuesHandler {
    protected CardDeckHelper cd = new CardDeckHelper();

    protected static String deckResponse = null;
    protected static String anotherDeckResponse = null;
    protected static int shuffledDecksAmount;

    protected static DeckModel deckResponseEntity = null;
    protected static CardsModel cardsResponseEntity = null;

}
