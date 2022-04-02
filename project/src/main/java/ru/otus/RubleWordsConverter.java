package ru.otus;

public class RubleWordsConverter implements Wordable {
    public static String RUBLE = "рубль";
    public static String RUBLE_RP = "рубля";
    public static String RUBLES = "рублей";

    @Override
    public String toWords(int amount) {
        String rubles;
        if (amount % 100 / 10 == 1) {
            rubles = RUBLES;
        } else {
            rubles = switch (amount % 10) {
                case 1 -> RUBLE;
                case 2, 3, 4 -> RUBLE_RP;
                case 0, 5, 6, 7, 8, 9 -> RUBLES;
                default -> throw new IllegalStateException("Unexpected value: " + amount % 10);
            };
        }
        return amount + " " + rubles;
    }
}
