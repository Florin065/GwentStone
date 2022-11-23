package game;

import game.cards.Minion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Board {
    @Getter @Setter
    private ArrayList<ArrayList<Minion>> cards;

    public Board() {
        cards = new ArrayList<>();
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
    }
}