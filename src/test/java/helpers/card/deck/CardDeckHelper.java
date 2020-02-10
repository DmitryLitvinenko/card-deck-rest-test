package helpers.card.deck;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static configuration.PropertiesConfiguration.getShuffleUrlPath;
import static helpers.UrlHelper.buildDeckUrl;

public class CardDeckHelper {

    private static final String DECK_COUNT_PARAM = "deck_count";
    private static final String DRAW_CARD_COUNT = "count";

    public String shuffleCards(final int deckCount) {
        var url = buildDeckUrl().path(getShuffleUrlPath())
                .queryParam(DECK_COUNT_PARAM, deckCount).build().toUriString();

        return sendGetRequest(url)
                .and().extract().response().getBody().asString();
    }

    public String shuffleCards() { return shuffleCards(1); }

    public String drawCard(final String deckId, final int deckNumber) {
        var url = buildDeckUrl().path("api/deck/" + deckId + "/draw/")
                .queryParam(DRAW_CARD_COUNT, deckNumber).build().toUriString();

        return sendGetRequest(url)
                .and().extract().response().getBody().asString();
    }

    public String reshuffleCards(final String deckId) {
        var url = buildDeckUrl().path("api/deck/" + deckId + "/shuffle/").build().toUriString();

        return sendGetRequest(url)
                .and().extract().response().getBody().asString();
    }

    private ValidatableResponse sendGetRequest(String url) {
        return RestAssured.given()
                .get(url)
                .then().statusCode(200);
    }
}
