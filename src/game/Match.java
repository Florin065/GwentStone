package game;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionsInput;
import fileio.GameInput;
import fileio.Input;
import game.cards.CardGen;
import game.commands.GetPlayerDeck;
import game.commands.GetPlayerHero;
import game.commands.GetPlayerTurn;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Random;

public class Match {
    @Getter @Setter
    private Player player1;
    @Getter @Setter
    private Player player2;
    private Input input;
    private GameInput gameInput;
    private ArrayNode output;
    @Getter @Setter
    private int playerTurn;
    @Getter @Setter
    private String player1Hero;
    @Getter @Setter
    private String player2Hero;

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

        // TODO: manaIncrement


        player1.getCardInHand();
        player2.getCardInHand();
    }

    public void playGame() {
        for (ActionsInput actionsInput : this.gameInput.getActions()) {
            switch (actionsInput.getCommand()) {
                case "getPlayerDeck" -> {
                    GetPlayerDeck getPlayerDeck = new GetPlayerDeck();
                    getPlayerDeck.action(this, output, actionsInput.getPlayerIdx());
                }
                case "getPlayerHero" -> {
                    GetPlayerHero getPlayerHero = new GetPlayerHero();
                    getPlayerHero.action(this, output, actionsInput.getPlayerIdx());
                }
                case "getPlayerTurn" -> {
                    GetPlayerTurn getPlayerTurn = new GetPlayerTurn();
                    getPlayerTurn.action(this, output);
                }
                case
            }
        }
    }
}
