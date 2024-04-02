package com.example.vothanhtrung_shop;

public class Product {
    private String name;
    private int price;
    private String imageUrl;

    public Product() {
        // Empty constructor needed for Firebase
    }

    public Product(String name, int price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}