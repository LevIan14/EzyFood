package com.example.ezyfood.model;

public class Drinks {
    String name;
    int price;

    public Drinks(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
