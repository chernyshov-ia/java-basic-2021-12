package ru.otus;

public enum Currency {
    RUBLE("рубль","рублей","рубля");

    private final String nameSingular;
    private final String namePlural;
    private final String nameRP;

    Currency(String nameSingular, String namePlural, String nameRP) {
        this.nameSingular = nameSingular;
        this.namePlural = namePlural;
        this.nameRP = nameRP;
    }

    public String getNameSingular() {
        return nameSingular;
    }

    public String getNamePlural() {
        return namePlural;
    }

    public String getNameRP() {
        return nameRP;
    }
}
