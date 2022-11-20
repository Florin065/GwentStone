package game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Card {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    ArrayList<String> colors;

    public Card(String name, String description, ArrayList<String> colors) {
        this.name = name;
        this.description = description;
        this.colors = colors;
    }

    public Card() {
    }


}
