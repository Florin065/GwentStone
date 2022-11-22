package game;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionsInput;
import fileio.GameInput;
import fileio.Input;
import game.cards.CardGen;
import game.commands.check.*;
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
    private Board board;
    @Getter @Setter
    private int playerTurn;
    @Getter @Setter
    private String player1Hero;
    @Getter @Setter
    private String player2Hero;
    @Getter @Setter
    private int initialTurn;
    @Getter @Setter
    private int roundCounter;

    public Match(Player player1, Player player2, Input input, GameInput gameInput, ArrayNode output) {
        this.player1        = player1;
        this.player2        = player2;
        this.input          = input;
        this.gameInput      = gameInput;
        this.output         = output;
        this.player1.setCurrentDeck(CardGen.getDeck(input.getPlayerOneDecks(), gameInput.getStartGame().getPlayerOneDeckIdx()));
        this.player2.setCurrentDeck(CardGen.getDeck(input.getPlayerTwoDecks(), gameInput.getStartGame().getPlayerTwoDeckIdx()));
        this.player1.setHero(CardGen.getCard(gameInput.getStartGame().getPlayerOneHero()));
        this.player2.setHero(CardGen.getCard(gameInput.getStartGame().getPlayerTwoHero()));
        Collections.shuffle(this.player1.getCurrentDeck(), new Random(gameInput.getStartGame().getShuffleSeed()));
        Collections.shuffle(this.player2.getCurrentDeck(), new Random(gameInput.getStartGame().getShuffleSeed()));
        this.playerTurn     = gameInput.getStartGame().getStartingPlayer();
        this.initialTurn    = gameInput.getStartGame().getStartingPlayer();
        this.roundCounter   = 1;
        this.board          = new Board();
        round();
    }

    public void round() {
        if (roundCounter < 10) {
            player1.setMana(player1.getMana() + roundCounter);
            player2.setMana(player2.getMana() + roundCounter);
        }
        else {
            player1.setMana(player1.getMana() + 10);
            player2.setMana(player2.getMana() + 10);
        }

        player1.getCardInHand();
        player2.getCardInHand();
    }

    public void playGame() {
        for (ActionsInput actionsInput : this.gameInput.getActions()) {
            switch (actionsInput.getCommand()) {

                // Gameplay commands

                case "endPlayerTurn" -> {
                    EndPlayerTurn endPlayerTurn = new EndPlayerTurn();
                    endPlayerTurn.action(this, board);

                    if (this.playerTurn == 1) {
                        this.playerTurn = 2;
                    }
                    else {
                        this.playerTurn = 1;
                    }

                    if (this.playerTurn == this.initialTurn) {
                        round();
                        roundCounter++;
                    }
                }
                case "placeCard" -> {
                    PlaceCard placeCard = new PlaceCard();
                    placeCard.action(this, output, actionsInput, gameInput, board);
                }
//                case "cardUsesAttack" -> {
//                    CardUsesAttack cardUsesAttack = new CardUsesAttack();
//                    TODO
//                }
//                case "cardUsesAbility" -> {
//                    CardUsesAbility cardUsesAbility = new CardUsesAbility();
//                    TODO
//                }
//                case "useAttackHero" -> {
//                    UseAttackHero useAttackHero = new UseAttackHero();
//                    TODO
//                }
//                case "useHeroAbility" -> {
//                    UseHeroAbility useHeroAbility = new UseHeroAbility();
//                    TODO
//                }
//                case "useEnvironmentCard" -> {
//                    UseEnvironmentCard useEnvironmentCard = new UseEnvironmentCard();
//                    TODO
//                }

                // Debug commands

                case "getCardsInHand" -> {
                    GetCardsInHand getCardsInHand = new GetCardsInHand();
                    getCardsInHand.action(this, output, actionsInput.getPlayerIdx());
                }
                case "getPlayerDeck" -> {
                    GetPlayerDeck getPlayerDeck = new GetPlayerDeck();
                    getPlayerDeck.action(this, output, actionsInput.getPlayerIdx());
                }
                case "getCardsOnTable" -> {
                    GetCardsOnTable getCardsOnTable = new GetCardsOnTable();
                    getCardsOnTable.action(output, board);
                }
                case "getPlayerTurn" -> {
                    GetPlayerTurn getPlayerTurn = new GetPlayerTurn();
                    getPlayerTurn.action(this, output);
                }
                case "getPlayerHero" -> {
                    GetPlayerHero getPlayerHero = new GetPlayerHero();
                    getPlayerHero.action(this, output, actionsInput.getPlayerIdx());
                }
//                case "getCardAtPosition" -> {
//                    GetCardAtPosition getCardAtPosition = new GetCardAtPosition();
//                    TODO
//                }
                case "getPlayerMana" -> {
                    GetPlayerMana getPlayerMana = new GetPlayerMana();
                    getPlayerMana.action(this, output, actionsInput.getPlayerIdx());
                }
//                case "getEnvironmentCardsInHand" -> {
//                    GetEnvironmentCardsInHand getEnvironmentCardsInHand = new GetEnvironmentCardsInHand();
//                    TODO
//                }
//                case "getFrozenCardsOnTable" -> {
//                    GetFrozenCardsOnTable getFrozenCardsOnTable = new GetFrozenCardsOnTable();
//                    TODO
//                }
//
//                // Statistics commands
//
//                case "getTotalGamesPlayed" -> {
//                    GetTotalGamesPlayed getTotalGamesPlayed = new GetTotalGamesPlayed();
//                    TODO
//                }
//                case "getPlayerOneWins" -> {
//                    GetPlayerWins getPlayerOneWins = new GetPlayerWins();
//
//                    if (actionsInput.getPlayerIdx() == 1) {
//                        getPlayerOneWins.action();
//                    }

//                    TODO
//                }
//                case "getPlayerTwoWins" -> {
//                    GetPlayerWins getPlayerTwoWins = new GetPlayerWins();
//
//                    if (actionsInput.getPlayerIdx() == 2) {
//                        getPlayerTwoWins.action();
//                    }

//                    TODO
//                }
            }
        }
    }
}
