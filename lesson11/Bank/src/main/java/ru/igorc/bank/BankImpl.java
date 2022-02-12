package ru.igorc.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BankImpl implements Bank {
    private String name;

    private AtomicInteger accountsSequence = new AtomicInteger(100);
    private AtomicInteger clientsSequence = new AtomicInteger(10);

    // Набор счетов банка
    private Map<Account, Account> accounts;

    // Набор клиентов банка
    private Map<Client, Client> clients;

    // "индекс" для быстрого получения счетов по клиенту
    private Map<Client, List<Account>> clientAccounts;


    public BankImpl(String name) {
        this.name = name;
        this.accounts = new HashMap<>();
        this.clients = new HashMap<>();
        this.clientAccounts = new HashMap<>();
    }

    @Override
    public List<Account> getAccounts(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("client = null");
        }

        return clientAccounts.get(client);
    }

    @Override
    public Client findClient(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("account = null");
        }

        Account bankAccount = accounts.get(account);
        if (bankAccount == null) {
            return null;
        }

        return bankAccount.getClient();
    }

    public Account createAccount(Client client) {
        Account account = new Account( accountsSequence.getAndAdd(1), clients.get(client));
        accounts.put(account,account);
        clientAccounts.get(client).add(account);
        return account;
    }

    public Client createClient(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name = null");
        }

        Client client = new Client(clientsSequence.getAndAdd(1), name);

        clients.put(client, client);
        clientAccounts.put(client, new ArrayList<>());

        return client;
    }

    @Override
    public String toString() {
        return "BankImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}
