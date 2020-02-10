package helpers.card.deck;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static configuration.PropertiesConfiguration.getCardDeckUrl;
import static configuration.PropertiesConfiguration.getShuffleUrlPath;

public class CardDeckHelper {

    public Response shuffleCards(int deckCount) {
        return RestAssured.given()
                .get(getCardDeckUrl() + getShuffleUrlPath() + "?deck_count=" + deckCount)
                .then().statusCode(200)
                .and().extract().response();
    }
}
