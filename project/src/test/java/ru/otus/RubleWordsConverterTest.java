package ru.otus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RubleWordsConverterTest {
    private final static Map<Integer, String> pairs = new HashMap<>();
    String rubles = "рублей";
    String ruble = "рубль";
    String ruble_rp = "рубля";

    @Before
    public void init() {
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
    }

    @Test
    public void amountToRoubleString() {
        System.out.println("amountToRoubleString");
        for (Integer amount : pairs.keySet()) {
            Assert.assertEquals(amount + " " + pairs.get(amount), CurrencyToStringConvertor.convert(Currency.RUBLE, amount));
        }
    }
}
