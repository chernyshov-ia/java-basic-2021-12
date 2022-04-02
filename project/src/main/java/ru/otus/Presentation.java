package ru.otus;

import java.io.*;

public class Presentation implements AutoCloseable {
    public final static String EXIT = "exit";

    private final BufferedReader reader;

    private final Currency currency;

    private final PrintWriter writer;

    public Presentation(Currency currency, InputStream inputStream, OutputStream outputStream) {
        this.currency = currency;
        this.writer = new PrintWriter(outputStream);
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void show() {
        String textAmount;
        try {
            while (true) {
                textAmount = reader.readLine();
                if("".equals(textAmount)) {
                    break;
                }
                int amount = Integer.parseInt(textAmount);
                writer.println(currency.toWords(amount));
                writer.flush();
            }
        } catch (Exception E) {
            writer.println(E.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
