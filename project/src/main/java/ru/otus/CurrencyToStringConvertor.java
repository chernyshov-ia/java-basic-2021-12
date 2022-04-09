package ru.otus;

public class CurrencyToStringConvertor {
    public static String convert(Currency currency, int amount) {
        String name;
        if (amount % 100 / 10 == 1) {
            name = currency.getNamePlural();
        } else {
            name = switch (amount % 10) {
                case 1 -> currency.getNameSingular();
                case 2, 3, 4 -> currency.getNameRP();
                case 0, 5, 6, 7, 8, 9 -> currency.getNamePlural();
                default -> throw new IllegalStateException("Unexpected value: " + amount % 10);
            };
        }
        return amount + " " + name;
    }
}
