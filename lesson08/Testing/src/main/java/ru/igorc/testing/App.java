package ru.igorc.testing;

public class App {
    public static void main(String[] args) {
        try (TestRunner runner = new TestRunner()) {
            runner.run(new ConcreteTest());
        }
    }
}
