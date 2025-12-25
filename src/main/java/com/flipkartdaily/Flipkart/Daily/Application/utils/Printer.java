package com.flipkartdaily.Flipkart.Daily.Application.utils;


import com.flipkartdaily.Flipkart.Daily.Application.model.Item;
import com.flipkartdaily.Flipkart.Daily.Application.service.InventoryService;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Printer {

    public static void printInventory(InventoryService service) {
        System.out.println("\nInventory :");

        TreeMap<String, TreeMap<String, Integer>> grouped = new TreeMap<>();
        for (Item item : service.getAllItems()) {
            grouped.computeIfAbsent(item.getBrand(), k -> new TreeMap<>())
                    .put(item.getCategory(), item.getQuantity());
        }

        for (Map.Entry<String, TreeMap<String, Integer>> brandEntry : grouped.entrySet()) {
            for (Map.Entry<String, Integer> catEntry : brandEntry.getValue().entrySet()) {
                System.out.println(brandEntry.getKey() + " -> " + catEntry.getKey() + " -> " + catEntry.getValue());
            }
        }
    }

    public static void printSearchResults(List<Item> results) {
        if (results.isEmpty()) {
            System.out.println("No items found");
            return;
        }
        for (Item item : results) {
            System.out.println(item);
        }
    }
}