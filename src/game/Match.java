package game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.GameInput;
import fileio.Input;
import game.cards.CardGen;
import game.commands.Test1.GetPlayerDeck;
import game.commands.Test1.GetPlayerHero;
import game.commands.Test1.GetPlayerTurn;
import game.commands.Test10.UseAttackHero;
import game.commands.Test12.UseHeroAbility;
import game.commands.Test16.getTotalGamesPlayed;
import game.commands.Test17.getPlayerWins;
import game.commands.Test2.*;
import game.commands.Test4.GetCardAtPosition;
import game.commands.Test4.GetEnvironmentCardsInHand;
import game.commands.Test4.UseEnvironmentCard;
import game.commands.Test5.GetFrozenCardsOnTable;
import game.commands.Test6.CardUsesAttack;
import game.commands.Test8.CardUsesAbility;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Match {
    @Getter @Setter
    private Player player1;
    @Getter @Setter
    private Player player2;
    @Getter @Setter
    private Input input;
    @Getter @Setter
    private GameInput gameInput;
    @Getter @Setter
    private ArrayNode output;
    @Getter @Setter
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
        this.player1.setMana(0);
        this.player2.setMana(0);
        this.player1.setCurrentHand(new ArrayList<>());
        this.player2.setCurrentHand(new ArrayList<>());
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

    public void endMatch(int attackerIdx) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        if (attackerIdx == 1) {
            node.put("gameEnded", "Player one killed the enemy hero.");
            player1.setWins(player1.getWins() + 1);
        } else {
            node.put("gameEnded", "Player two killed the enemy hero.");
            player2.setWins(player2.getWins() + 1);
        }
        output.add(node);
        player1.setPlays(player1.getPlays() + 1);
        player2.setPlays(player2.getPlays() + 1);
    }

    public void playGame() {
        for (ActionsInput actionsInput : this.gameInput.getActions()) {
            System.out.println(actionsInput.getCommand());
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
                        roundCounter++;
                        round();
                    }
                }
                case "placeCard" -> {
                    PlaceCard placeCard = new PlaceCard();
                    placeCard.action(this, output, actionsInput, gameInput, board);
                }
                case "cardUsesAttack" -> {
                    CardUsesAttack cardUsesAttack = new CardUsesAttack();
                    cardUsesAttack.action(output, actionsInput, board);
                }
                case "cardUsesAbility" -> {
                    CardUsesAbility cardUsesAbility = new CardUsesAbility();
                    cardUsesAbility.action(output, actionsInput, board, this);
                }
                case "useAttackHero" -> {
                    UseAttackHero useAttackHero = new UseAttackHero();
                    useAttackHero.action(output, actionsInput, board, this);
                }
                case "useHeroAbility" -> {
                    UseHeroAbility useHeroAbility = new UseHeroAbility();
                    useHeroAbility.action(output, actionsInput, board, this);
                }
                case "useEnvironmentCard" -> {
                    UseEnvironmentCard useEnvironmentCard = new UseEnvironmentCard();
                    useEnvironmentCard.action(this, output, actionsInput, board, playerTurn);
                }

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
                case "getCardAtPosition" -> {
                    GetCardAtPosition getCardAtPosition = new GetCardAtPosition();
                    getCardAtPosition.action(output, actionsInput, board);
                }
                case "getPlayerMana" -> {
                    GetPlayerMana getPlayerMana = new GetPlayerMana();
                    getPlayerMana.action(this, output, actionsInput.getPlayerIdx());
                }
                case "getEnvironmentCardsInHand" -> {
                    GetEnvironmentCardsInHand getEnvironmentCardsInHand = new GetEnvironmentCardsInHand();
                    getEnvironmentCardsInHand.action(this, output, actionsInput.getPlayerIdx());
                }
                case "getFrozenCardsOnTable" -> {
                    GetFrozenCardsOnTable getFrozenCardsOnTable = new GetFrozenCardsOnTable();
                    getFrozenCardsOnTable.action(output, board);
                }

                // Statistics commands

                case "getTotalGamesPlayed" -> {
                    getTotalGamesPlayed getTotalGamesPlayed = new getTotalGamesPlayed();
                    getTotalGamesPlayed.action(this, output);
                }
                case "getPlayerOneWins", "getPlayerTwoWins" -> {
                    getPlayerWins getPlayerWins = new getPlayerWins();
                    getPlayerWins.action(this, output, actionsInput);
                }
            }
        }
    }
}
