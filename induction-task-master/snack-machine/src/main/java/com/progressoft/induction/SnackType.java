package com.progressoft.induction;

public enum SnackType {
    CHEWING_GUM(new Snack(SnackMachine.DEFAULT_QUANTITY, 0.50, "CHEWING_GUM")),
    CHIPS(new Snack(SnackMachine.DEFAULT_QUANTITY, 0.50, "CHIPS")),
    CHOCOLATE(new Snack(SnackMachine.DEFAULT_QUANTITY, 0.50, "CHOCOLATE"));

    private Snack snack;

    SnackType(Snack snack) {
        this.snack = snack;
    }

    public double price() {
        return snack.getPrice();
    }

    public long quantity() {
        return snack.getQuantity();
    }

    public void subtractQuantity(long quantityToSubtract) {
        this.snack.subtractQuantity(quantityToSubtract);
    }

    public void reset() {
        this.snack.setQuantity(SnackMachine.DEFAULT_QUANTITY);
    }

}
