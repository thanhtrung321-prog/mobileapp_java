package com.example.vothanhtrung_shop;

import android.net.Uri;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailUploadproduct {

    private DatabaseReference productsRef;
    private StorageReference storageRef;

    public DetailUploadproduct() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        productsRef = database.getReference("products");
        storageRef = FirebaseStorage.getInstance().getReference();
    }

    public void uploadProduct(String productName, double productPrice, String productDescription, String productIngredients, Uri productImageUri) {
        // Tạo một đối tượng ProductAdminDetail từ thông tin nhập vào
        ProductAdminDetail product = new ProductAdminDetail(productName, productPrice, "", productDescription, productIngredients);

        // Thêm sản phẩm vào Firebase Realtime Database
        String productId = productsRef.push().getKey();
        productsRef.child(productId).setValue(product);

        // Thực hiện upload hình ảnh vào Storage
        uploadImageToStorage(productId, productImageUri);
    }

    private void uploadImageToStorage(String productId, Uri imageUri) {
        if (imageUri != null) {
            // Chuyển đổi Uri thành đường dẫn của hình ảnh trong Firebase Storage
            String imageFileName = "product_images/" + productId + ".jpg";
            StorageReference imageRef = storageRef.child(imageFileName);

            // Upload hình ảnh lên Firebase Storage
            imageRef.putFile(imageUri)
                    .addOnSuccessListener(taskSnapshot -> {
                        // Lấy đường dẫn của hình ảnh sau khi upload thành công
                        imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                            // Cập nhật đường dẫn hình ảnh vào sản phẩm trong Realtime Database
                            productsRef.child(productId).child("imageUrlProduct").setValue(uri.toString());
                        });
                    })
                    .addOnFailureListener(e -> {
                        // Xử lý khi upload hình ảnh thất bại
                        // Ví dụ: Toast.makeText(context, "Failed to upload image", Toast.LENGTH_SHORT).show();
                    });
        }
    }
}
