# Flipkart Daily - Grocery Inventory System

Java + Spring Boot implementation of the Flipkart Daily browsing feature.

This project demonstrates an in-memory inventory system where users can:
- Add items (defined by brand + category + price)
- Add stock quantities
- Search items with flexible filters (brand, category, price range)
- Sort results (lowest/highest price, lowest/highest quantity)

**Strictly follows the boilerplate structure** provided:
https://github.com/lusiferjr/CabBookingSystem/tree/main/src

## Features Implemented
- AddItem(brand, category, price)
- AddInventory(brand, category, quantity)
- Search with single or combined filters (brand, category, price range)
- Sorting: lowest price (default), highest price, lowest quantity, highest quantity
- Fully extensible for new filters and sort options
- Proper separation: model, repository, service, pojo, constant, Utils
- Exception handling and edge case validation

## How to Run
1. Clone the repository
2. Open in any Java IDE (IntelliJ, Eclipse, VS Code)
3. Run `Driver.java` as the main class

It will execute all the sample test cases and print:
- Full inventory summary
- All required search scenarios with filters and sorting
