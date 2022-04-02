package ru.otus;

public enum Currency implements Wordable {
    RUBLE(new RubleWordsConverter());

    private final Wordable wordsConverter;

    Currency(Wordable wordsConverter) {
        this.wordsConverter = wordsConverter;
    }

    @Override
    public String toWords(int amount) {
        if( wordsConverter == null ) {
            return Integer.toString(amount);
        }
        return wordsConverter.toWords(amount);
    }
}
