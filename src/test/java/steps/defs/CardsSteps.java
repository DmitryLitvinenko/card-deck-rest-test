package steps.defs;

import elements.models.CardsResponse;
import elements.models.DeckResponse;
import helpers.card.deck.CardDeckHandler;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.JsonParser.parseJson;

@ScenarioScoped
public class CardsSteps extends CardDeckHandler {

    @When("draw {int} card(s)")
    public void drawCards(final int cardAmount) {
        final DeckResponse deckResponseModel = parseJson(DECK_RESPONSE, DeckResponse.class);
        final var drawCardResponse = cd.drawCard(deckResponseModel.getDeckId(), cardAmount);

        final CardsResponse cardsResponse = parseJson(drawCardResponse, CardsResponse.class);

        var cardsInOneDeck = 52;
        assertThat(cardsResponse.getRemaining()).isEqualTo(cardsInOneDeck - cardAmount);
    }

    @Then("check remaining cards")
    public void checkRemainingCards() {
    }
}
