package com.flipkartdaily.Flipkart.Daily.Application.service;


import com.flipkartdaily.Flipkart.Daily.Application.constant.SortType;
import com.flipkartdaily.Flipkart.Daily.Application.model.Item;
import com.flipkartdaily.Flipkart.Daily.Application.pojo.SearchFilter;
import com.flipkartdaily.Flipkart.Daily.Application.repository.InventoryRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryService {

    private final InventoryRepository repository = new InventoryRepository();

    public void addItem(String brand, String category, int price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be > 0");

        if (repository.findByBrandAndCategory(brand, category) != null) {
            System.out.println("Warning: Item already exists - " + brand + " " + category);
            return;
        }

        Item item = new Item(brand, category, price);
        repository.save(item);
    }

    public void addInventory(String brand, String category, int quantity) {
        Item item = repository.findByBrandAndCategory(brand, category);
        if (item == null) {
            throw new RuntimeException("Item not found: " + brand + " " + category);
        }
        item.addQuantity(quantity);
    }

    public List<Item> search(SearchFilter filter, SortType sortType) {
        return repository.findAll().stream()
                .filter(item -> matches(item, filter))
                .sorted(getComparator(sortType))
                .collect(Collectors.toList());
    }

    public List<Item> getAllItems() {
        return repository.findAll().stream().toList();
    }

    private boolean matches(Item item, SearchFilter filter) {
        if (filter.getBrands() != null && !filter.getBrands().isEmpty()
                && !filter.getBrands().contains(item.getBrand())) {
            return false;
        }
        if (filter.getCategories() != null && !filter.getCategories().isEmpty()
                && !filter.getCategories().contains(item.getCategory())) {
            return false;
        }
        if (filter.getPriceFrom() != null && item.getPrice() < filter.getPriceFrom()) {
            return false;
        }
        if (filter.getPriceTo() != null && item.getPrice() > filter.getPriceTo()) {
            return false;
        }
        return true;
    }

    private Comparator<Item> getComparator(SortType sortType) {
        if (sortType == null) sortType = SortType.PRICE_ASC;

        return switch (sortType) {
            case PRICE_ASC -> Comparator.comparingInt(Item::getPrice);
            case PRICE_DESC -> Comparator.comparingInt(Item::getPrice).reversed();
            case QUANTITY_ASC -> Comparator.comparingInt(Item::getQuantity);
            case QUANTITY_DESC -> Comparator.comparingInt(Item::getQuantity).reversed();
        };
    }
}