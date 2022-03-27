package testing.tests.unit.fakes;

import testing.app.game.GameWinnerPrinter;
import testing.app.game.Player;

public class GameWinnerPrinterStub implements GameWinnerPrinter {
    private String winnerName;

    public String getWinnerName() {
        return winnerName;
    }

    public void clearWinnerName(){
        winnerName = null;
    }

    @Override
    public void printWinner(Player winner) {
        if(winner == null ) {
            clearWinnerName();
            return;
        }
        winnerName = winner.getName();
    }
}
