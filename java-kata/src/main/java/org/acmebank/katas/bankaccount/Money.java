package org.acmebank.katas.bankaccount;

import lombok.EqualsAndHashCode;

/**
 * Immutable class to represent Money as a concept.
 * This class should have no accessor methods.
 */
@EqualsAndHashCode
public class Money {

    private long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money amountOf(long amount) {
        return new Money(amount);
    }

}
