package testing.tests.unit;

import testing.app.game.Dice;
import testing.app.game.Game;
import testing.app.game.Player;
import testing.assertions.Assertions;
import testing.tests.unit.fakes.FakeDice;
import testing.tests.unit.fakes.GameWinnerPrinterStub;

public class GameTest {
    private final Player player1 = new Player("1");
    private final Player player2 = new Player("2");

    public void testGameWithPlayer1Win() {
        String scenario = "Тест когда игрок №1 выигрывает по выпавшему значению";
        try {
            Dice dice = new FakeDice(6,1);
            GameWinnerPrinterStub printer = new GameWinnerPrinterStub();
            Game game = new Game(dice, printer);
            game.playGame(player1, player2);
            Assertions.assertEquals(player1.getName(), printer.getWinnerName());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testGameWithPlayer2Win() {
        String scenario = "Тест когда игрок №2 выигрывает по выпавшему значению";
        try {
            Dice dice = new FakeDice(2,3);
            GameWinnerPrinterStub printer = new GameWinnerPrinterStub();
            Game game = new Game(dice, printer);
            game.playGame(player1, player2);
            Assertions.assertEquals(player2.getName(), printer.getWinnerName());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testGameWithNobodyWin() {
        String scenario = "Тест на ничью";
        try {
            Dice dice = new FakeDice(4,4);
            GameWinnerPrinterStub printer = new GameWinnerPrinterStub();
            Game game = new Game(dice, printer);
            game.playGame(player1, player2);
            if(player1.getName().equals(printer.getWinnerName()) || player2.getName().equals(printer.getWinnerName()) ) {
                throw new Exception("Ничья не зафиксирована");
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
