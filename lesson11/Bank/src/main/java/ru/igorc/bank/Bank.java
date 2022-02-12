package ru.igorc.bank;

import java.util.List;

public interface Bank {
    List<Account> getAccounts(Client client);
    Client findClient(Account account);
}
