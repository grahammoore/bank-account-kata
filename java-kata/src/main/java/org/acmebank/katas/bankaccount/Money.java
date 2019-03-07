package org.acmebank.katas.bankaccount;

import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * Immutable class to represent Money as a concept.
 * This class should have no accessor methods.
 */
@EqualsAndHashCode
public class Money {

    public static final Money ZERO = Money.amountOf(0);

    private long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money amountOf(long amount) {
        return new Money(amount);
    }


    public Money plus(Money money) {
        return amountOf(amount + money.amount);
    }

    public Money minus(Money money) {
        return amountOf(amount - money.amount);
    }


/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
*/
}
