package helpers.card.deck;

import elements.models.CardsModel;
import elements.models.DeckModel;
import helpers.RequestHelper;
import org.assertj.core.api.SoftAssertions;

import static configuration.PropertiesConfiguration.getShuffleUrlPath;
import static helpers.UrlHelper.buildDeckUrl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardDeckHelper {
    private RequestHelper requestHelper = new RequestHelper();

    private static final String DECK_COUNT_PARAM = "deck_count";
    private static final String DRAW_CARD_COUNT = "count";

    public String shuffleCards(final int deckCount) {
        var url = buildDeckUrl().path(getShuffleUrlPath())
                .queryParam(DECK_COUNT_PARAM, deckCount).build().toUriString();

        return requestHelper.sendGetRequest(url).extractBody();
    }

    public String drawCard(final String deckId, final int deckNumber) {
        var url = buildDeckUrl().path("api/deck/" + deckId + "/draw/")
                .queryParam(DRAW_CARD_COUNT, deckNumber).build().toUriString();

        return requestHelper.sendGetRequest(url).extractBody();
    }

    public String reshuffleCards(final String deckId) {
        var url = buildDeckUrl().path("api/deck/" + deckId + "/shuffle/").build().toUriString();

        return requestHelper.sendGetRequest(url).extractBody();
    }

    public void validateDeckAfterShuffle(final DeckModel actualJson, final int deckAmount) {
        var cardsInOneDeck = 52;
        SoftAssertions softly = new SoftAssertions();
        assertThat(actualJson.getRemaining()).isEqualTo(cardsInOneDeck * deckAmount);
        assertThat(actualJson.getDeckId()).isNotNull();
        assertThat(actualJson.isShuffled()).isTrue();
        assertThat(actualJson.isSuccess()).isTrue();
        softly.assertAll();
    }

    public void validateCardParameters(CardsModel cards, int drawCardAmount) {
        final SoftAssertions softly = new SoftAssertions();
        var pulledCardsAmount = cards.getCards().size();

        softly.assertThat(pulledCardsAmount)
                .withFailMessage("Pulled cards should be: " + drawCardAmount + ", but actual amount of cards is: " + pulledCardsAmount)
                .isEqualTo(drawCardAmount);

        if (pulledCardsAmount > 0) {
            cards.getCards()
                    .forEach(c -> {
                        softly.assertThat(c.getImage()).isNotNull().isNotBlank();
                        softly.assertThat(c.getValue()).isNotNull().isNotBlank();
                        softly.assertThat(c.getSuit()).isNotNull().isNotBlank();
                        softly.assertThat(c.getCode()).isNotNull().isNotBlank();
                    });
        }
        softly.assertAll();
    }
}
