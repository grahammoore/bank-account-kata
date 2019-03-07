package org.acmebank.katas.bankaccount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void compareEqualAmounts() {
        Money oneAmount = Money.amountOf(10);
        Money anotherAmount = Money.amountOf(10);
        assertThat(oneAmount).isEqualTo(anotherAmount);
    }

    @Test
    public void compareNonEqualAmounts() {
        Money oneAmount = Money.amountOf(10);
        Money anotherAmount = Money.amountOf(20);
        assertThat(oneAmount).isNotEqualTo(anotherAmount);
    }
}
