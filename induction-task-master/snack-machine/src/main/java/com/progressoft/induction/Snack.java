package com.progressoft.induction;

public class Snack {
    private long quantity;
    private double price;
    private String name;

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Snack(long quantity, double price, String name) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void subtractQuantity(long quantityToSubtract) {
        this.quantity -= quantityToSubtract;
    }

}
