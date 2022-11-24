package game.commands.Test2;

import game.Board;
import game.Match;

public final class EndPlayerTurn {
    /**
     *
     * @param match
     * @param board
     */
    public void action(final Match match, final Board board) {
        if (board != null) {
            if (match.getPlayerTurn() == 2) {
                match.getPlayer2().getHero().setUsedAction(false);
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < board.getCards().get(i).size(); j++) {
                        if (board.getCards().get(i).get(j).isFrozen()) {
                            board.getCards().get(i).get(j).setFrozen(false);
                        }
                        if (board.getCards().get(i).get(j).isUsedAction()) {
                            board.getCards().get(i).get(j).setUsedAction(false);
                        }
                    }
                }
            } else {
                match.getPlayer1().getHero().setUsedAction(false);
                for (int i = 2; i < 2 + 2; i++) {
                    for (int j = 0; j < board.getCards().get(i).size(); j++) {
                        if (board.getCards().get(i).get(j).isFrozen()) {
                            board.getCards().get(i).get(j).setFrozen(false);
                        }
                        if (board.getCards().get(i).get(j).isUsedAction()) {
                            board.getCards().get(i).get(j).setUsedAction(false);
                        }
                    }
                }
            }
        }
    }
}
