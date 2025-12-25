package com.flipkartdaily.Flipkart.Daily.Application.model;

public class Item {
    private final String brand;
    private final String category;
    private final int price;
    private int quantity;

    public Item(String brand, String category, int price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = 0;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity += qty;
    }

    @Override
    public String toString() {
        return brand + ", " + category + ", " + quantity;
    }
}