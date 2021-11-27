package com.example.ezyfood.model;

public class Order {
    Drinks drinks;
    int qty;
    int totalPrice;

    public Order(Drinks drinks, int qty, int totalPrice) {
        super();
        this.drinks = drinks;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }

    public Drinks getDrinks() {
        return this.drinks;
    }

    public int getQty() { return this.qty; }

    public int getTotalPrice() { return this.totalPrice; }

    public void addQty(int newQty) {
        this.qty += newQty;
    }

    public void addTotalPrice(int newTotalPrice) {
        this.totalPrice += newTotalPrice;
    }


}
