package steps.defs;

import elements.models.CardsResponse;
import helpers.card.deck.CardDeckValuesHandler;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.JsonParser.parseJson;

@ScenarioScoped
public class CardsSteps extends CardDeckValuesHandler {

    private String drawCardResponse;
    private int drawCardAmount;

    @When("draw {int} card(s)")
    public void drawCards(final int cardAmount) {
        drawCardAmount = cardAmount;
        drawCardResponse = cd.drawCard(deckResponseEntity.getDeckId(), cardAmount);
    }

    @Then("check remaining cards")
    public void checkRemainingCards() {
        final CardsResponse cardsResponse = parseJson(drawCardResponse, CardsResponse.class);

        var cardsInOneDeck = 52;
        var expectedRemaining = cardsInOneDeck * shuffledDecksAmount - drawCardAmount;
        assertThat(cardsResponse.getRemaining()).isEqualTo(expectedRemaining);
    }
}
