package com.flipkartdaily.Flipkart.Daily.Application.pojo;
import java.util.List;

public class SearchFilter {
    private List<String> brands;
    private List<String> categories;
    private Integer priceFrom;
    private Integer priceTo;

    // getters and setters
    public List<String> getBrands() { return brands; }
    public void setBrands(List<String> brands) { this.brands = brands; }
    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }
    public Integer getPriceFrom() { return priceFrom; }
    public void setPriceFrom(Integer priceFrom) { this.priceFrom = priceFrom; }
    public Integer getPriceTo() { return priceTo; }
    public void setPriceTo(Integer priceTo) { this.priceTo = priceTo; }
}