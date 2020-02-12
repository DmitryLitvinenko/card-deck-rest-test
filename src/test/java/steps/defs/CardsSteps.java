package steps.defs;

import helpers.card.deck.CardsDeckTestBase;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ScenarioScoped
public class CardsSteps extends CardsDeckTestBase {

    @When("draw {int} card(s)")
    public void drawCards(final int cardAmount) {
    }

    @Then("check remaining cards")
    public void checkRemainingCards() {
    }
}
