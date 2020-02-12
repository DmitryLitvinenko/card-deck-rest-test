package steps.defs;

import elements.models.DeckModel;
import helpers.card.deck.CardDeckValuesHandler;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.JsonParser.parseJson;

@ScenarioScoped
public class DeckSteps extends CardDeckValuesHandler {

    @Given("shuffle {word} {int} deck(s)")
    public void shuffleDeck(final String option, final int deckAmount) {
        shuffledDecksAmount = deckAmount;
        String response = cd.shuffleCards(deckAmount);

        deckResponseEntity = parseJson(response, DeckModel.class);
        cd.validateDeckAfterShuffle(deckResponseEntity, deckAmount);

        if (option.equals("new")) {
            deckResponse = response;
        } else {
            anotherDeckResponse = response;
        }
    }

    @Then("validate that additional deck is unique")
    public void validateThatDeckIsUnique() {
        assertThat(deckResponse).isNotEqualTo(anotherDeckResponse).isNotNull();
    }
}
