package steps.defs;

import elements.models.CardsModel;
import helpers.card.deck.CardDeckValuesHandler;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.JsonParser.parseJson;

@ScenarioScoped
public class CardsSteps extends CardDeckValuesHandler {

    private int drawCardAmount;

    @When("draw {int} card(s)")
    public void drawCards(final int cardAmount) {
        drawCardAmount = cardAmount;
        final var drawCardResponse = cd.drawCard(deckResponseEntity.getDeckId(), cardAmount);

        cardsResponseEntity = parseJson(drawCardResponse, CardsModel.class);
    }

    @Then("check remaining cards")
    public void checkRemainingCards() {
        var cardsInOneDeck = 52;
        var expectedRemaining = cardsInOneDeck * shuffledDecksAmount - drawCardAmount;
        assertThat(cardsResponseEntity.getRemaining()).isEqualTo(expectedRemaining);
    }

    @Then("validate card parameters")
    public void validateCardParameters() {
        cd.validateCardParameters(cardsResponseEntity, drawCardAmount);
    }
}
