package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money ZERO = new Money(BigDecimal.valueOf(0.00));
    public static final Money QUARTER_DINAR = new Money(BigDecimal.valueOf(0.25));
    public static final Money HALF_DINAR = new Money(BigDecimal.valueOf(0.50));
    public static final Money DINAR = new Money(BigDecimal.valueOf(1.0));
    public static final Money FIVE_DINAR = new Money(BigDecimal.valueOf(5.0));
    public static final Money TEN_DINAR = new Money(BigDecimal.valueOf(10.0));

    private BigDecimal amount;

    public Money(BigDecimal amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(BigDecimal amount) {
        if (amount.floatValue() < 0)
            throw new IllegalArgumentException("Negative amount not accepted");
    }

    public Money add(Money money) {
        validateAmount(money.getAmount());
        return new Money(this.amount.add(money.getAmount()));
    }

    public boolean isLessThan(Money money) {
        if (money == null)
            return false;
        return this.amount.compareTo(money.getAmount()) < 0;
    }

    public Money subtract(Money money) {
        return new Money(this.amount.subtract(money.getAmount()));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return this.amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
