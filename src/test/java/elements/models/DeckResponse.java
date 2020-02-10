package elements.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeckResponse {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("shuffled")
    private boolean shuffled;

    @JsonProperty("deck_id")
    private String deckId;

    @JsonProperty("remaining")
    private int remaining;
}