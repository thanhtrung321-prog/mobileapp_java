package com.example.vothanhtrung_shop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private EditText namefoodtext;
    private EditText pricetext;
    private EditText textdescription;
    private EditText listcomponent;
    private Button buttonAddToCart;
    private Uri productImageUri;
    private DetailUploadproduct detailUploadproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        namefoodtext = findViewById(R.id.namefoodtext);
        pricetext = findViewById(R.id.pricetext);
        textdescription = findViewById(R.id.textdescription);
        listcomponent = findViewById(R.id.listcomponent);
        buttonAddToCart = findViewById(R.id.button_add_to_cart);
        detailUploadproduct = new DetailUploadproduct(); // Khởi tạo đối tượng DetailUploadproduct

        buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin sản phẩm từ EditText
                String productName = namefoodtext.getText().toString();
                String priceString = pricetext.getText().toString();
                String productDescription = textdescription.getText().toString();
                String productIngredients = listcomponent.getText().toString();

                if (productName.isEmpty()) {
                    namefoodtext.setError("Vui lòng nhập tên sản phẩm");
                    namefoodtext.requestFocus();
                    return;
                }

                if (priceString.isEmpty()) {
                    pricetext.setError("Vui lòng nhập giá sản phẩm");
                    pricetext.requestFocus();
                    return;
                }

                double productPrice = Double.parseDouble(priceString);

                if (productDescription.isEmpty()) {
                    textdescription.setError("Vui lòng nhập mô tả sản phẩm");
                    textdescription.requestFocus();
                    return;
                }

                if (productIngredients.isEmpty()) {
                    listcomponent.setError("Vui lòng nhập thành phần sản phẩm");
                    listcomponent.requestFocus();
                    return;
                }

                // Kiểm tra xem đã chọn hình ảnh chưa
                if (productImageUri != null) {
                    // Thực hiện upload hình ảnh và thông tin sản phẩm
                    detailUploadproduct.uploadProduct(productName, productPrice, productDescription, productIngredients, productImageUri);
                    // Hiển thị thông báo khi sản phẩm đã được thêm thành công
                    Toast.makeText(DetailActivity.this, "Sản phẩm đã được thêm thành công", Toast.LENGTH_SHORT).show();
                    // Chuyển người dùng trở lại trang chính
                    Intent intent = new Intent(DetailActivity.this, HomeAdminActivity.class);
                    startActivity(intent);
                    finish(); // Kết thúc hoạt động hiện tại để người dùng không thể quay lại trang này từ trang chính
                } else {
                    // Nếu chưa chọn hình ảnh, thông báo cho người dùng
                    Toast.makeText(DetailActivity.this, "Vui lòng chọn hình ảnh", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView addImageProduct = findViewById(R.id.add_image_product);
        ImageView addproductimage = findViewById(R.id.imageviewproduct);
        ImageView pagehome = findViewById(R.id.detail_page_home);
        pagehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, HomeAdminActivity.class);
                startActivity(intent);
                finish(); // Kết thúc hoạt động hiện tại để người dùng không thể quay lại trang này từ trang chính
            }
        });
        addImageProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        addproductimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            productImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), productImageUri);
                ImageView imageView = findViewById(R.id.imageviewproduct);
                imageView.setImageBitmap(bitmap);

                // Ẩn background của ImageView add_image_product
                hideAddProductImageBackground();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void hideAddProductImageBackground() {
        ImageView addProductImageView = findViewById(R.id.uploadimageviewproduct);
        addProductImageView.setImageDrawable(null);
    }

}
