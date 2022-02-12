package ru.igorc.bank;

public class Account {
    private final int id;
    private final Client client;

    public Account(int id) {
        this.id = id;
        this.client = null;
    }

    public Account(int id, Client client) {
        if (client == null) {
            throw new IllegalArgumentException("client = null");
        }
        this.id = id;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return id == account.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", client=" + client +
                '}';
    }
}
