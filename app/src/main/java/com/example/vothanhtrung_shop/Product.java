package com.example.vothanhtrung_shop;

public class Product {
    private String id; // Thêm trường ID vào lớp Product
    private String name;
    private int price;
    private String imageUrl;

    public Product() {
        // Empty constructor needed for Firebase
    }

    public Product(String id, String name, int price, String imageUrl) {
        this.id = id; // Gán giá trị ID
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
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
