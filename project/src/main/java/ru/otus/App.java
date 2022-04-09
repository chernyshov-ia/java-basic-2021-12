package ru.otus;

public class App {

    public static void main(String[] args) {
        try ( Presentation presentation = new Presentation(Currency.RUBLE, System.in, System.out) ) {
            presentation.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
