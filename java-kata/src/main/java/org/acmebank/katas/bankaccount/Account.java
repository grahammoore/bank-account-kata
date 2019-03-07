package org.acmebank.katas.bankaccount;

public class Account {

    private Money balance;

    private Account() {
        balance = Money.ZERO;
    }

    public static Account newAccount() {
        return new Account();
    }

    public void deposit(Money money) {
        balance = balance.plus(money);
    }

    public Money balance() {
        return balance;
    }

    public void withdraw(Money money) {
        balance = balance.minus(money);
    }

    public void transferFrom(Account account, Money money) {
        throw new RuntimeException("Not implemented");
    }
}
