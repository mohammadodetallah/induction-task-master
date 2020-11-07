package com.progressoft.induction;


import java.math.BigDecimal;

public class SnackMachine {
    public static final Long DEFAULT_QUANTITY = 10L;

    private Money moneyInside;
    private Money moneyInTransaction;

    public SnackMachine() {
        moneyInTransaction = Money.ZERO;
        moneyInside = Money.ZERO;
        resetDefaultSnack();
    }

    private void resetDefaultSnack() {
        for (SnackType value : SnackType.values()) {
            value.reset();
        }
    }

    public Money moneyInside() {
        return this.moneyInside;
    }

    public void insertMoney(Money money) {
        validateMoneyUnit(money);
        this.moneyInTransaction = moneyInTransaction.add(money);
    }

    private void validateMoneyUnit(Money money) {
        if (money == null)
            throw new IllegalArgumentException("Should not be null");

        if (!money.equals(Money.QUARTER_DINAR)
                && !money.equals(Money.HALF_DINAR)
                && !money.equals(Money.DINAR)
                && !money.equals(Money.FIVE_DINAR)
                && !money.equals(Money.TEN_DINAR)) {
            throw new IllegalArgumentException("invalid unit");
        }
    }

    public Money moneyInTransaction() {
        return this.moneyInTransaction;
    }

    public SnackType chewingGums() {
        return SnackType.CHEWING_GUM;
    }

    public SnackType chips() {
        return SnackType.CHIPS;
    }

    public SnackType chocolates() {
        return SnackType.CHOCOLATE;
    }

    public Money buySnack(SnackType snack) {
        if (moneyInTransaction.equals(Money.ZERO))
            throw new IllegalStateException("insert money before buy");
        validateQuantity(snack);
        validatePrice(snack);

        doBuy(snack);
        return this.moneyInTransaction;
    }

    private void validatePrice(SnackType snack) {
        if (moneyInTransaction.isLessThan(new Money(BigDecimal.valueOf(snack.price()))))
            throw new IllegalStateException("Insufficient money");
    }

    private void validateQuantity(SnackType snack) {
        if (snack.quantity() <= 0)
            throw new IllegalStateException("Insufficient quantity");
    }

    private void doBuy(SnackType snack) {
        double price = snack.price();
        moneyInTransaction = moneyInTransaction.subtract(new Money(BigDecimal.valueOf(price)));
        moneyInside = moneyInside.add(new Money(BigDecimal.valueOf(price)));
        snack.subtractQuantity(1);
    }
}
