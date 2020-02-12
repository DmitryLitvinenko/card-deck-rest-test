package elements.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeckModel {

    @SerializedName("success")
    private boolean success;
    @SerializedName("shuffled")
    private boolean shuffled;
    @SerializedName("deck_id")
    private String deckId;
    @SerializedName("remaining")
    private int remaining;
}