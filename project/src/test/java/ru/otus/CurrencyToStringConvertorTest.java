package ru.otus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

public class CurrencyToStringConvertorTest {
    private static Stream<Arguments> generateData() {
        final String rubles = "рублей";
        final String ruble = "рубль";
        final String ruble_rp = "рубля";

        HashMap<Integer, String> pairs = new HashMap<>();

        for (int i = 10; i <= 19; i++) {
            pairs.put(i, rubles);
            pairs.put(100 + i, rubles);
            pairs.put(200 + i, rubles);
        }
        for (Integer i : new Integer[]{0, 20, 30, 40, 50, 60, 70, 80, 90, 100, 120, 130, 1000, 1020}) {
            pairs.put(0, rubles);
            pairs.put(i + 1, ruble);
            pairs.put(i + 2, ruble_rp);
            pairs.put(i + 3, ruble_rp);
            pairs.put(i + 4, ruble_rp);
            pairs.put(i + 5, rubles);
            pairs.put(i + 6, rubles);
            pairs.put(i + 7, rubles);
            pairs.put(i + 8, rubles);
            pairs.put(i + 9, rubles);
        }

        return pairs.entrySet().stream().map( s -> Arguments.of(s.getKey(), s.getValue()));
    }

    @DisplayName("Конвертор в рубли")
    @ParameterizedTest
    @MethodSource("generateData")
    public void amountToRoubleString( int amount, String text ) {
        Assertions.assertEquals(amount + " " + text,
                CurrencyToStringConvertor.convert(Currency.RUBLE, amount));
    }

}
