package com.flipkartdaily.Flipkart.Daily.Application;

import com.flipkartdaily.Flipkart.Daily.Application.constant.SortType;
import com.flipkartdaily.Flipkart.Daily.Application.pojo.SearchFilter;
import com.flipkartdaily.Flipkart.Daily.Application.service.InventoryService;
import com.flipkartdaily.Flipkart.Daily.Application.utils.Printer;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();

        // Adding items
        service.addItem("Amul", "Milk", 100);
        service.addItem("Amul", "Curd", 50);
        service.addItem("Nestle", "Milk", 60);
        service.addItem("Nestle", "Curd", 90);

        // Adding stock
        service.addInventory("Amul", "Milk", 10);
        service.addInventory("Nestle", "Milk", 5);
        service.addInventory("Nestle", "Curd", 10);
        service.addInventory("Amul", "Milk", 10);  // now 20
        service.addInventory("Amul", "Curd", 5);

        Printer.printInventory(service);

        System.out.println("\n--- Search by brand Nestle ---");
        SearchFilter filter1 = new SearchFilter();
        filter1.setBrands(Arrays.asList("Nestle"));
        Printer.printSearchResults(service.search(filter1, SortType.PRICE_ASC));

        System.out.println("\n--- Search by category Milk ---");
        SearchFilter filter2 = new SearchFilter();
        filter2.setCategories(Arrays.asList("Milk"));
        Printer.printSearchResults(service.search(filter2, SortType.PRICE_ASC));

        System.out.println("\n--- Search Milk, highest price first ---");
        Printer.printSearchResults(service.search(filter2, SortType.PRICE_DESC));

        System.out.println("\n--- Search price between 70 and 100 ---");
        SearchFilter filter3 = new SearchFilter();
        filter3.setPriceFrom(70);
        filter3.setPriceTo(100);
        Printer.printSearchResults(service.search(filter3, SortType.PRICE_DESC));

        System.out.println("\n--- Search Milk AND price 70-100, highest price first ---");
        SearchFilter filter4 = new SearchFilter();
        filter4.setCategories(Arrays.asList("Milk"));
        filter4.setPriceFrom(70);
        filter4.setPriceTo(100);
        Printer.printSearchResults(service.search(filter4, SortType.PRICE_DESC));

        System.out.println("\n--- Search Milk, lowest quantity first ---");
        Printer.printSearchResults(service.search(filter2, SortType.QUANTITY_ASC));
    }
}