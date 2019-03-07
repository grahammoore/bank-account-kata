package org.acmebank.katas.bankaccount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void createANewAccount() {
        Account account = Account.newAccount();
        assertThat(account.balance()).isEqualTo(Money.amountOf(0));
    }

    @Test
    public void depositAnAmount() {
        Account account = Account.newAccount();
        account.deposit(Money.amountOf(10));
        assertThat(account.balance()).isEqualTo(Money.amountOf(10));
    }

    @Test
    public void depositTwoAnAmounts() {
        Account account = Account.newAccount();
        account.deposit(Money.amountOf(10));
        account.deposit(Money.amountOf(5));
        assertThat(account.balance()).isEqualTo(Money.amountOf(15));
    }

    @Test
    public void withdrawAnAmount() {
        Account account = Account.newAccount();
        account.withdraw(Money.amountOf(10));
        assertThat(account.balance()).isEqualTo(Money.amountOf(-10));
    }

    @Test
    public void withdrawTwoAmounts() {
        Account account = Account.newAccount();
        account.withdraw(Money.amountOf(10));
        account.withdraw(Money.amountOf(5));
        assertThat(account.balance()).isEqualTo(Money.amountOf(-15));
    }

    @Test
    public void transferAnAmountWithAvailableFunds() {
        Account sendingAccount = Account.newAccount();
        Account receivingAccount = Account.newAccount();
        sendingAccount.deposit(Money.amountOf(10));
        receivingAccount.deposit(Money.amountOf(5));
        sendingAccount.transferTo(receivingAccount, Money.amountOf(6));
        assertThat(sendingAccount.balance()).isEqualTo(Money.amountOf(4));
        assertThat(receivingAccount.balance()).isEqualTo(Money.amountOf(16));
    }

    @Test
    public void transferAnAmountWithoutAvailableFunds() {
        Account sendingAccount = Account.newAccount();
        Account receivingAccount = Account.newAccount();
        sendingAccount.deposit(Money.amountOf(3));
        receivingAccount.deposit(Money.amountOf(5));
        sendingAccount.transferTo(receivingAccount, Money.amountOf(6));
        //TODO how do we know the funds didn't transfer?
        assertThat(sendingAccount.balance()).isEqualTo(Money.amountOf(3));
        assertThat(receivingAccount.balance()).isEqualTo(Money.amountOf(5));
    }

}
