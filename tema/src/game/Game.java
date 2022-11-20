package game;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.GameInput;
import fileio.Input;

public class Game {

    public static void gameInit(Input input, ArrayNode output) {
        Player player1 = new Player();
        Player player2 = new Player();

        for (GameInput gameInput : input.getGames()) {
            Match match = new Match(player1, player2, input, gameInput, output);
            match.playGame();
        }
    }
}
