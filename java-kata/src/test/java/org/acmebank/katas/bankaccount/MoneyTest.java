package org.acmebank.katas.bankaccount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void compareTwoMoneyObjectsForEquality() {
        Money amount1 = Money.amountOf(10);
        Money amount2 = Money.amountOf(10);

        assertThat(amount1).isEqualTo(amount2);
    }

    @Test
    public void compareTwoMoneyObjectsForInequality() {
        Money amount1 = Money.amountOf(10);
        Money amount2 = Money.amountOf(20);

        assertThat(amount1).isNotEqualTo(amount2);
    }
}