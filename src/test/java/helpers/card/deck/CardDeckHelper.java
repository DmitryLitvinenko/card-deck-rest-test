package helpers.card.deck;

import helpers.RequestHelper;

import static configuration.PropertiesConfiguration.getShuffleUrlPath;
import static helpers.UrlHelper.buildDeckUrl;

public class CardDeckHelper {
    private RequestHelper requestHelper = new RequestHelper();

    private static final String DECK_COUNT_PARAM = "deck_count";
    private static final String DRAW_CARD_COUNT = "count";

    public String shuffleCards(final int deckCount) {
        var url = buildDeckUrl().path(getShuffleUrlPath())
                .queryParam(DECK_COUNT_PARAM, deckCount).build().toUriString();

        return requestHelper.sendGetRequest(url).extractBody();
    }

    public String shuffleCards() { return shuffleCards(1); }

    public String drawCard(final String deckId, final int deckNumber) {
        var url = buildDeckUrl().path("api/deck/" + deckId + "/draw/")
                .queryParam(DRAW_CARD_COUNT, deckNumber).build().toUriString();

        return requestHelper.sendGetRequest(url).extractBody();
    }

    public String reshuffleCards(final String deckId) {
        var url = buildDeckUrl().path("api/deck/" + deckId + "/shuffle/").build().toUriString();

        return requestHelper.sendGetRequest(url).extractBody();
    }
}
