package testing.tests.unit;

import testing.app.game.Dice;
import testing.app.game.DiceImpl;

public class DiceTest {

    public void testBounds() {
        String scenario = "Проверка на диапазон значений кубика 1-6";
        try {
            Dice dice = new DiceImpl();
            for (int i = 0; i < 10000; i++) {
                int value = dice.roll();
                if (value < 1 || value > 6) {
                    throw new Exception("Значение вне диапазона(" + value + ")");
                }
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
