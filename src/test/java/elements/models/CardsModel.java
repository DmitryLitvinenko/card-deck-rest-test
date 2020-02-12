package elements.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CardsModel {

    @SerializedName("cards")
    private List<CardsItem> cards;

    @SerializedName("success")
    private boolean success;

    @SerializedName("deck_id")
    private String deckId;

    @SerializedName("remaining")
    private int remaining;

    @Data
    public static class CardsItem {

        @SerializedName("image")
        private String image;

        @SerializedName("code")
        private String code;

        @SerializedName("suit")
        private String suit;

        @SerializedName("value")
        private String value;
    }
}