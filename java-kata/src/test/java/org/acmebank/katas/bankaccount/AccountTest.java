package org.acmebank.katas.bankaccount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void newAccount() {
        Account account = Account.newAccount();
        assertThat(account.balance()).isEqualTo(Money.ZERO);
    }

    @Test
    public void depositMoneyIntoAccount() {
        Account account = Account.newAccount();
        account.deposit(Money.amountOf(10));
        assertThat(account.balance()).isEqualTo(Money.amountOf(10));
    }

    @Test
    public void depositMoreAndMoreMoneyIntoAccount() {
        Account account = Account.newAccount();
        account.deposit(Money.amountOf(10));
        account.deposit(Money.amountOf(15));
        account.deposit(Money.amountOf(21));
        assertThat(account.balance()).isEqualTo(Money.amountOf(46));
    }

    @Test
    void withdrawMoneyFromAccount() {
        Account account = Account.newAccount();
        account.withdraw(Money.amountOf(11));
        assertThat(account.balance()).isEqualTo(Money.amountOf(-11));
    }

    @Test
    void transferMoneyBetweenAccounts() {
        Account account1 = Account.newAccount();
        Account account2 = Account.newAccount();

        account1.deposit(Money.amountOf(11));
        account2.deposit(Money.amountOf(21));

        account1.transferFrom(account2, Money.amountOf(5));

        assertThat(account1.balance()).isEqualTo(Money.amountOf(16));
        assertThat(account2.balance()).isEqualTo(Money.amountOf(15));
    }
}
