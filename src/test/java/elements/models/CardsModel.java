package elements.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardsModel {

    @JsonProperty("cards")
    private List<CardsItem> cards;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("deck_id")
    private String deckId;

    @JsonProperty("remaining")
    private int remaining;

    @Data
    public static class CardsItem {

        @JsonProperty("image")
        private String image;

        @JsonProperty("code")
        private String code;

        @JsonProperty("suit")
        private String suit;

        @JsonProperty("value")
        private String value;
    }
}