package ru.igorc.bank;

public class App {
    public static Client CLIENT_PETR;
    public static Account ACCOUNT_PETR;
    public static Client CLIENT_IVAN;
    public static Client CLIENT_OLEG;

    public static Bank getBank() {
        BankImpl bank = new BankImpl("СБЕР");

        CLIENT_PETR = bank.createClient("Пётр");
        ACCOUNT_PETR = bank.createAccount(CLIENT_PETR);
        bank.createAccount(CLIENT_PETR);

        CLIENT_OLEG = bank.createClient("Олег");
        bank.createAccount(CLIENT_OLEG);
        bank.createAccount(CLIENT_OLEG);
        bank.createAccount(CLIENT_OLEG);

        CLIENT_IVAN = bank.createClient("Иван");

        return bank;
    }

    public static void main(String[] args) {
        Bank bank = getBank();

        System.out.println("Счета Петра");
        System.out.println(bank.getAccounts(new Client(CLIENT_PETR.getId())));
        System.out.println();
        System.out.println("Счета Олега");
        System.out.println(bank.getAccounts(new Client(CLIENT_OLEG.getId())));
        System.out.println();
        System.out.println("Счета Ивана");
        System.out.println(bank.getAccounts(new Client(CLIENT_IVAN.getId())));
        System.out.println();
        System.out.println("Поиск клиента по счету Петра");
        System.out.println(bank.findClient(new Account(ACCOUNT_PETR.getId())));

    }
}
