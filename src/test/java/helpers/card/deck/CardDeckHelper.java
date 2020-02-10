package helpers.card.deck;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static configuration.PropertiesConfiguration.getShuffleUrlPath;
import static helpers.UrlHelper.buildDeckUrl;

public class CardDeckHelper {

    private static final String DECK_COUNT_PARAM = "deck_count";
    private static final String DRAW_CARD_COUNT = "count";

    public Response shuffleCards(final int deckCount) {
        var url = buildDeckUrl().path(getShuffleUrlPath())
                .queryParam(DECK_COUNT_PARAM, deckCount).build().toUriString();

        return RestAssured.given()
                .get(url)
                .then().statusCode(200)
                .and().extract().response();
    }

    public Response drawCard(final String deckId, final int deckNumber) {
        var url = buildDeckUrl().path("api/deck/" + deckId + "/draw/")
                .queryParam(DRAW_CARD_COUNT, deckNumber).build().toUriString();

        return RestAssured.given()
                .get(url)
                .then().statusCode(200)
                .and().extract().response();
    }
}
