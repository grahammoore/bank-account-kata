package org.acmebank.katas.bankaccount;

public class Account {

    private Money balance = Money.amountOf(0);

    public static Account newAccount() {
        return new Account();
    }

    public Money balance() {
        return balance;
    }

    public void deposit(Money amount) {
        balance = balance.plus(amount);
    }

    public void withdraw(Money amount) {
        balance = balance.minus(amount);
    }

    public void transferTo(Account receivingAccount, Money amount) {
        withdraw(amount);
        receivingAccount.deposit(amount);
    }
}
