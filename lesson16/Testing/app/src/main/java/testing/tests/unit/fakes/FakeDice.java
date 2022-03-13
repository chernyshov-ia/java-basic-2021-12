package testing.tests.unit.fakes;

import testing.app.game.Dice;

public class FakeDice implements Dice {
    private final int[] values;
    private int index;

    public FakeDice(int... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }

        this.values = values;
        this.index = 0;
    }

    @Override
    public int roll() {
        if ( index >= values.length ) {
            index = 0;
        }
        int value = values[index];
        index++;
        return value;
    }
}
