package game;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionsInput;
import fileio.GameInput;
import fileio.Input;

import java.util.Collections;
import java.util.Random;

public class Match {
    private Player player1;
    private Player player2;
    private Input input;
    private GameInput gameInput;
    private ArrayNode output;
    private int playerTurn;

    public Match(Player player1, Player player2, Input input, GameInput gameInput, ArrayNode output) {
        this.player1   = player1;
        this.player2   = player2;
        this.input     = input;
        this.gameInput = gameInput;
        this.output    = output;
        this.player1.setCurrentDeck(CardGen.getDeck(input.getPlayerOneDecks(), gameInput.getStartGame().getPlayerOneDeckIdx()));
        this.player2.setCurrentDeck(CardGen.getDeck(input.getPlayerTwoDecks(), gameInput.getStartGame().getPlayerTwoDeckIdx()));
        this.player1.setHero(CardGen.getCard(gameInput.getStartGame().getPlayerOneHero()));
        this.player2.setHero(CardGen.getCard(gameInput.getStartGame().getPlayerTwoHero()));
        Collections.shuffle(this.player1.getCurrentDeck(), new Random(gameInput.getStartGame().getShuffleSeed()));
        Collections.shuffle(this.player2.getCurrentDeck(), new Random(gameInput.getStartGame().getShuffleSeed()));
        this.playerTurn = gameInput.getStartGame().getStartingPlayer();
        round();
    }

    public void round() {
        // TODO: turnCounter
        // TODO: mamaIncrement

        player1.getCardInHand();
        player2.getCardInHand();
    }

    public void playGame() {
        for (ActionsInput actionsInput : this.gameInput.getActions()) {
            switch (actionsInput.getCommand()) {

            }
        }
    }
}
