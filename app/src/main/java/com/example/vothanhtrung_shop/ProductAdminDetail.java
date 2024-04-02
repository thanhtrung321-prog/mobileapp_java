package com.example.vothanhtrung_shop;

public class ProductAdminDetail {
    private String productId; // Thêm trường productId
    private String namedetaiproduct;
    private double priceproduct;
    private String imageUrlProduct;
    private String description;
    private String componentproduct;

    public ProductAdminDetail() {
        // HÀM TẠO K CẦN THAM SỐ
    };

    public ProductAdminDetail(String productId, String namedetaiproduct, double priceproduct, String imageUrlProduct, String description, String componentproduct) {
        this.productId = productId; // Thêm khởi tạo cho trường productId
        this.namedetaiproduct = namedetaiproduct;
        this.priceproduct = priceproduct;
        this.imageUrlProduct = imageUrlProduct;
        this.description = description;
        this.componentproduct = componentproduct;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getNamedetaiproduct() {
        return namedetaiproduct;
    }

    public void setNamedetaiproduct(String namedetaiproduct) {
        this.namedetaiproduct = namedetaiproduct;
    }

    public double getPriceproduct() {
        return priceproduct;
    }

    public void setPriceproduct(double priceproduct) {
        this.priceproduct = priceproduct;
    }

    public String getImageUrlProduct() {
        return imageUrlProduct;
    }

    public void setImageUrlProduct(String imageUrlProduct) {
        this.imageUrlProduct = imageUrlProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComponentproduct() {
        return componentproduct;
    }

    public void setComponentproduct(String componentproduct) {
        this.componentproduct = componentproduct;
    }
}
