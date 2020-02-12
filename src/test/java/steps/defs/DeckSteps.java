package steps.defs;

import elements.models.DeckResponse;
import helpers.card.deck.CardDeckHandler;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.JsonParser.parseJson;

@ScenarioScoped
public class DeckSteps extends CardDeckHandler {

    @Given("shuffle {word} {int} deck(s)")
    public void shuffleDeck(final String option, final int deckAmount) {
        //todo add capture group, to handle only new and another
        //todo steps should be logged in the output
        String response;
        response = cd.shuffleCards(deckAmount);

        final DeckResponse deckResponseModel = parseJson(response, DeckResponse.class);
        cd.validateDeckAfterShuffle(deckResponseModel, deckAmount);

        if (option.equals("new")) {
            DECK_RESPONSE = response;
            assertThat(DECK_RESPONSE)
                    .withFailMessage("New deck is null").isNotNull();
        } else {
            ANOTHER_DECK_RESPONSE = response;
            assertThat(ANOTHER_DECK_RESPONSE)
                    .withFailMessage("Another deck is null").isNotNull();
        }
    }

    @Then("validate that additional deck is unique")
    public void validateThatDeckIsUnique() {
        assertThat(DECK_RESPONSE).isNotEqualTo(ANOTHER_DECK_RESPONSE).isNotNull();
    }
}
