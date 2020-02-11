package steps.defs;

import elements.models.DeckResponse;
import helpers.card.deck.CardDeckHelper;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.JsonParser.parseJson;

@ScenarioScoped
public class CardDeckSteps {
    private CardDeckHelper cardDeck = new CardDeckHelper();

    private String deckResponse;
    private String anotherDeckResponse;

    @Given("shuffle {string} {int} deck(s)")
    public void shuffleDeck(final String option, int deckAmount) {
        String response;
        response = cardDeck.shuffleCards(deckAmount);

        DeckResponse actual = parseJson(response, DeckResponse.class);
        cardDeck.validateDeckAfterShuffle(actual, deckAmount);

        if (option.equals("new")) {
            deckResponse = response;
            assertThat(deckResponse)
                    .withFailMessage("New deck is null").isNotNull();
        } else {
            anotherDeckResponse = response;
            assertThat(anotherDeckResponse)
                    .withFailMessage("Additional deck is null").isNotNull();
        }
    }

    @Then("validate that additional deck is unique")
    public void validateThatDeckIsUnique() {
        assertThat(deckResponse).isNotEqualTo(anotherDeckResponse).isNotNull();
    }
}
