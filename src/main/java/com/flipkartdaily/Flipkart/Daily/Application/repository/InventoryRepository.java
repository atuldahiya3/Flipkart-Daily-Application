package com.flipkartdaily.Flipkart.Daily.Application.repository;


import com.flipkartdaily.Flipkart.Daily.Application.model.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InventoryRepository {
    private final Map<String, Item> items = new HashMap<>();

    private String key(String brand, String category) {
        return brand + "#" + category;
    }

    public void save(Item item) {
        items.put(key(item.getBrand(), item.getCategory()), item);
    }

    public Item findByBrandAndCategory(String brand, String category) {
        return items.get(key(brand, category));
    }

    public Collection<Item> findAll() {
        return items.values();
    }
}