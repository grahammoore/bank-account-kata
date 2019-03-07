package org.acmebank.katas.bankaccount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    public void createANewAccount() {
        Account account = Account.newAccount();
        assertThat(account.balance()).isEqualTo(Money.amountOf(0));
    }
}
