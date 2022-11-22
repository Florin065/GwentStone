package game.commands;

import game.Board;
import game.Match;

public class EndPlayerTurn {
    public void action(Match match, Board board) {
        if (board != null) {
            if (match.getPlayerTurn() == 2) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < board.getCards().get(i).size(); j++) {
                        if (board.getCards().get(i).get(j).isFrozen()) {
                            board.getCards().get(i).get(j).setFrozen(false);
                        }
                    }
                }
            } else {
                for (int i = 2; i < 4; i++) {
                    for (int j = 0; j < board.getCards().get(i).size(); j++) {
                        if (board.getCards().get(i).get(j).isFrozen()) {
                            board.getCards().get(i).get(j).setFrozen(false);
                        }
                    }
                }
            }
        }
//        match.setPlayerTurn(match.getTurnCounter() + 1);
    }
}
